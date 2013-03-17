package controllers

import play.api._
import play.api.mvc._
import play.api.mvc.BodyParsers.parse
import com.zzorba.cards.Deck
import com.zzorba.zombicide._
import java.net.URLEncoder


case class LinkButton(text: String, link: String, color: String = "white") {
  val colorButton = "%sButton".format(color)
}

case class DialogLink(id: String, text: String, link: String, color: String = "white") {
  val colorButton = "%sButton".format(color)

  val (uri, params) = link.split("\\?").toList match {
    case u :: p :: Nil => (u, p.split("\\&").map(_.split("\\=").toList match {
      case k :: v :: Nil => (k, v)
      case x => throw new Exception("Unknown '%s'".format(x.toString))
    }))
    case x =>
      throw new Exception("Unknown '%s'".format(x.toString))
  }
}

object Application extends Controller {
  def index = Action {
    val decks = ZombieCardSet.SuggestedDecks.map(set => {
      val deck = ZombieCardFactory.createDeck(Nil, set.ids.map(ZombieCardFactory.forId))
      LinkButton(set.name, "deck/?deck=%s".format(ZombieCardFactory.reshuffle(deck).encode))
    })
    Ok(views.html.index(decks))
  }

  def deck(deck: String, level: Option[String], action: Option[String], count: Option[Int]) = Action { request =>
    val survivorLevel = level.flatMap(s => SurvivorLevel.values.find(_.toString == s)).getOrElse(SurvivorLevel.Blue)
    val zDeck = ZombieCardFactory.decode(deck)
    def link(d: Deck[ZombieCard], l: SurvivorLevel.Value,
             text: String,
             action: Option[String] = None): LinkButton = {
      val link =
        "/deck/?deck=%s&level=%s%s".format(d.encode, l.toString, action.map(a => "&action=%s".format(a)).getOrElse(""))
      LinkButton(text, link)
    }

    def dlink(d: Deck[ZombieCard], l: SurvivorLevel.Value,
              text: String,
              action: Option[String] = None,
              id: String = "spawn"): DialogLink = {
      val x = link(d, l, text, action)
      DialogLink(id, x.text, x.link, x.color)
    }

    def basicLinks(d: Deck[ZombieCard]): List[LinkButton] =
      SurvivorLevel.next(survivorLevel).map(l =>
        link(d, l, "Move to %s Level".format(l.toString), Some("level"))).toList ++
      List(LinkButton("End Game", "/", "red"))

    val (headers, newDeck) = action.map(_.toLowerCase) match {
      case Some("draw") =>
        val (cards, newDeck) = {
          val (c1, d1) = ZombieCardFactory.draw(zDeck)
          (1 to count.getOrElse(1)).tail.foldLeft((List(c1), d1))((result, b) => {
            if (result._2.hasCards) {
              val (c2, d2) = ZombieCardFactory.draw(result._2)
              (result._1 ++ List(c2), d2)
            } else {
              result
            }
          })
        }

        val results = cards.map(_.behaviors.forLevel(survivorLevel) match {
          case ZombieBehavior.Clear =>
            "All Clear!"

          case ZombieBehavior.Spawn(zombieType, count, sewer) =>
            "Spawn %d %s%s".format(count, ZombieType.plural(zombieType, count),
              if (sewer) " on each sewer marker that is on a tile containing a survivor" else "")

          case ZombieBehavior.ExtraActivation(zombieType) =>
            "All %s get an extra activation!".format(ZombieType.plural(zombieType, 2))
        })

        (results, newDeck)
      case Some("shuffle") =>
        val newDeck = ZombieCardFactory.reshuffle(zDeck)
        (List("Reshuffled!"), newDeck)
      case Some("level") =>
        (List("Now at %s level".format(survivorLevel.toString)), zDeck)
      case Some(x) =>
        throw new Exception("Unknown action=%s".format(x))
      case None =>
        (List("Choose an action"), zDeck)
    }

    val dlinks =
      if (newDeck.hasCards) List(dlink(newDeck, survivorLevel, "Draw Multiple", Some("draw"))) else Nil
    val links =
      (if (!newDeck.hasCards)
        List(link(newDeck, survivorLevel, "Shuffle Deck", Some("shuffle")))
       else
        List(link(newDeck, survivorLevel, "Draw One", Some("draw")))) ++
      basicLinks(newDeck).toList

    val title = "Level %s".format(survivorLevel.toString)
    Ok(views.html.deck(title, headers, dlinks, links))
  }
}