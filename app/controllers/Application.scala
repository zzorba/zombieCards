package controllers

import play.api._
import play.api.mvc._
import play.api.mvc.BodyParsers.parse
import com.zzorba.cards.Deck
import com.zzorba.zombicide._

case class LinkButton(text: String, link: String, color: String = "white") {
  val colorButton = "%sButton".format(color)
}

object Application extends Controller {
  def index = Action {
    val decks = ZombieCardSet.SuggestedDecks.map(set => {
      val deck = ZombieCardFactory.createDeck(Nil, set.ids.map(ZombieCardFactory.forId))
      LinkButton(set.name, "deck/?deck=%s".format(ZombieCardFactory.reshuffle(deck).encode))
    })
    Ok(views.html.index(decks))
  }

  def deck(deck: String, level: Option[String], action: Option[String]) = Action { request =>
    val survivorLevel = level.flatMap(s => SurvivorLevel.values.find(_.toString == s)).getOrElse(SurvivorLevel.Blue)
    val zDeck = ZombieCardFactory.decode(deck)
    def link(d: Deck[ZombieCard], l: SurvivorLevel.Value,
             text: String,
             action: Option[String] = None): LinkButton = {
      val link =
        "/deck/?deck=%s&level=%s%s".format(d.encode, l.toString, action.map(a => "&action=%s".format(a)).getOrElse(""))
      LinkButton(text, link)
    }

    def basicLinks(d: Deck[ZombieCard]): List[LinkButton] =
      SurvivorLevel.next(survivorLevel).map(l =>
        link(d, l, "Move to %s Level".format(l.toString), Some("level"))).toList ++
      List(LinkButton("End Game", "/", "red"))

    val (header, links) = action.map(_.toLowerCase) match {
      case Some("draw") =>
        val (card, newDeck) = ZombieCardFactory.draw(zDeck)
        val actionLink = if (newDeck.drawPile.isEmpty) "Shuffle" else "Draw"
        val result = card.behaviors.forLevel(survivorLevel) match {
          case ZombieBehavior.Clear =>
            "All Clear!"

          case ZombieBehavior.Spawn(zombieType, count, sewer) =>
            "Spawn %d %s%s".format(count, ZombieType.plural(zombieType, count),
              if (sewer) " on each sewer marker that is on a tile containing a survivor" else "")

          case ZombieBehavior.ExtraActivation(zombieType) =>
            "All %s get an extra activation!".format(ZombieType.plural(zombieType, 2))
        }

        (result,
         link(newDeck, survivorLevel, actionLink, Some(actionLink)) :: basicLinks(newDeck).toList)
      case Some("shuffle") =>
        val newDeck = ZombieCardFactory.reshuffle(zDeck)
        ("Reshuffled!",
          link(newDeck, survivorLevel, "Draw", Some("draw")) :: basicLinks(newDeck).toList)
      case Some("level") =>
        ("Now at %s level".format(survivorLevel.toString),
         link(zDeck, survivorLevel, "Draw", Some("draw")) :: basicLinks(zDeck).toList)
      case Some(x) =>
        throw new Exception("Unknown action=%s".format(x))
      case None =>
        ("Choose an action",
         link(zDeck, survivorLevel, "Draw", Some("draw")) :: basicLinks(zDeck).toList)
    }
    Ok(views.html.deck(header, links))
  }
}