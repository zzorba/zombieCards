package com.zzorba.zombicide

import com.zzorba.cards.CardSet

class ZombieCardSet(val name: String,
                    rawIds: Iterable[Int]) extends CardSet {
  override val ids = rawIds.map(_.toByte).toSeq
}


object ZombieCardSet {
  val Sections = List(
    new ZombieCardSet("Easy Section", 1 to 24),
    new ZombieCardSet("Harder Section", 25 to 36),
    new ZombieCardSet("Exceptional Section", 37 to 42),
    new ZombieCardSet("Walk of the Dead", 43 to 54)
  )

  val SuggestedDecks = List(
    new ZombieCardSet("Season 1", 1 to 42),
    new ZombieCardSet("Season 1 + Walk of the Dead (Abomination Pack)", 1 to 54),
    new ZombieCardSet("Predictable", 1 to 12),
    new ZombieCardSet("Sunday Walk in Zombieland", 1 to 24),
    new ZombieCardSet("No Sudden Death", (1 to 12) ++ (25 to 36) ++ (41 to 42)),
    new ZombieCardSet("On Your Guard", (1 to 12) ++ (25 to 36) ++ (37 to 42)),
    new ZombieCardSet("Zombie Hell", (25 to 36) ++ (37 to 42)),
    new ZombieCardSet("Walk of the Dead", 43 to 54)
  )
}