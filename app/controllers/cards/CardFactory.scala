package com.zzorba.cards

import com.zzorba.misc.Base64
import scala.util.Random

trait CardFactory[T <: Card] {
  def forId(id: Byte): T

  def createDeck(discard: Seq[T], draw: Seq[T]): Deck[T]

  def decode(input: String): Deck[T] = {
    input.split("-").toList match {
      case discard :: Nil =>
        createDeck(
          Base64.decode(discard).map(forId),
          Nil)
      case discard :: draw :: Nil =>
        createDeck(
          Base64.decode(discard).map(forId),
          Base64.decode(draw).map(forId))
      case _ =>
        throw new Exception("Invalid Deck Encoding %s".format(input))
    }
  }

  def draw(deck: Deck[T]): (T, Deck[T]) = {
    if (deck.drawPile.isEmpty) throw new Exception("Need to shuffle the deck")

    deck.drawPile match {
      case Seq(x) => (x, createDeck(x +: deck.discardPile, Nil))
      case Seq(x, xs@_*) => (x, createDeck(x +: deck.discardPile, xs))
    }
  }

  def reshuffle(deck: Deck[T]): Deck[T] = {
    createDeck(Nil, Random.shuffle(deck.discardPile ++ deck.drawPile))
  }
}