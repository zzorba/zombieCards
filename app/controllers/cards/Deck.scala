package com.zzorba.cards

import com.zzorba.misc.Base64
import java.net.URLEncoder

trait Deck[T <: Card] {
  def discardPile: Seq[T]
  def drawPile: Seq[T]

  def encode: String = {
    URLEncoder.encode(Base64.encode(discardPile.map(_.id)) + "-" + Base64.encode(drawPile.map(_.id)), "UTF-8")
  }
}