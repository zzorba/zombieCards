package controllers

import play.api._
import play.api.mvc._
import play.api.mvc.BodyParsers.parse
import com.zzorba.cards.Deck
import com.zzorba.zombicide._
import java.net.URLEncoder
import util.Random


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
      LinkButton(set.name, "/deck/?deck=%s&name=%s".format(ZombieCardFactory.reshuffle(deck).encode, set.name))
    })

   Ok(views.html.index(decks, true))
  }

  def home = Action {
    val decks = ZombieCardSet.SuggestedDecks.map(set => {
      val deck = ZombieCardFactory.createDeck(Nil, set.ids.map(ZombieCardFactory.forId))
      LinkButton(set.name, "/deck/?deck=%s&name=%s".format(ZombieCardFactory.reshuffle(deck).encode, set.name))
    })

    Ok(views.html.index(decks, false))
  }

  def deck(deck: String,
           level: Option[String],
           action: Option[String],
           count: Option[Int],
           name: Option[String],
           form: Option[Boolean]) = Action { request =>
    val survivorLevel = level.flatMap(s => SurvivorLevel.values.find(_.toString == s)).getOrElse(SurvivorLevel.Blue)
    val zDeck = ZombieCardFactory.decode(deck)
    def link(d: Deck[ZombieCard], l: SurvivorLevel.Value,
             text: String,
             action: Option[String] = None,
             color: String = "white"): LinkButton = {
      val link =
        "/deck/?deck=%s&level=%s%s".format(d.encode, l.toString, action.map(a => "&action=%s".format(a)).getOrElse(""))
      LinkButton(text, link, color)
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
        link(d, l, "Move up to %s Level".format(l.toString), Some("level"))).toList ++
      SurvivorLevel.previous(survivorLevel).map(l =>
          link(d, l, "Move down to %s Level".format(l.toString), Some("level"))).toList ++
      (if (d.drawPile.size > 1)
        List(link(d, survivorLevel, "Shuffle Draw Pile (%d)".format(d.drawPile.size), Some("shuffle-draw"), "gray"))
       else Nil) ++
      List(LinkButton("End Game", "/home", "red"))

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

          case ZombieBehavior.Spawn(zombieType, count, zType, sewer) =>
            "Spawn %d %s%s".format(count, ZombieType.plural(zombieType, zType, count),
              if (sewer) " on each sewer marker that is on a tile containing a survivor" else "")

          case ZombieBehavior.ExtraActivation(zombieType) =>
            "All %s get an extra activation!".format(ZombieType.plural(zombieType, ZType.Normal, 2))
        })

        (results, newDeck)
      case Some("shuffle") =>
        val newDeck = ZombieCardFactory.reshuffle(zDeck)
        (List("Reshuffled!"), newDeck)
      case Some("shuffle-draw") =>
        val newDeck = ZombieCardFactory.createDeck(zDeck.discardPile, Random.shuffle(zDeck.drawPile))
        (List("Reshuffled the draw pile, no peeking!"), newDeck)
      case Some("level") =>
        (List("Now at %s level".format(survivorLevel.toString)), zDeck)
      case Some(x) =>
        throw new Exception("Unknown action=%s".format(x))
      case None =>
        (List(name.map(deckName => "Deck: %s".format(deckName)).getOrElse("Bring it on!")), zDeck)
    }

    val dlinks =
      if (newDeck.drawPile.size > 1) List(dlink(newDeck, survivorLevel, "Draw Multiple", Some("draw"))) else Nil
    val links =
      (if (!newDeck.hasCards)
        List(link(newDeck, survivorLevel, "Shuffle Deck", Some("shuffle")))
       else
        List(link(newDeck, survivorLevel, "Draw One", Some("draw")))) ++
      basicLinks(newDeck).toList

    val title = "Level %s".format(survivorLevel.toString)

    val id = Random.nextInt().toString
    val url = {
      "/deck/?deck=%s&form=1".format(zDeck.encode) +
        level.map(l => "&level=%s".format(l)).getOrElse("") +
        action.map(a => "&action=%s".format(a)).getOrElse("") +
        count.map(c => "&count=%d".format(c)).getOrElse("") +
        name.map(n => "&name=%s".format(n)).getOrElse("")
    }
    if (form.exists(x => x)) {
      Ok(views.html.deck(url, id, title, headers, dlinks, links))
    } else {
      Ok(views.html.deckFragment(url, id, title, headers, dlinks, links))
    }
  }
}