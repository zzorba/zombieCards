package com.zzorba.zombicide

import com.zzorba.cards.CardSet

class ZombieCardSet(val name: String,
                    val rawIds: Iterable[Int]) extends CardSet {
  override val ids = rawIds.map(_.toByte).toSeq
}


object ZombieCardSet {
  val Season1 = new ZombieCardSet("Season 1", 1 to 42)
  val PrisonOutbreak = new ZombieCardSet("Prison Outbreak", 79 to 120)
  val ToxicCityMall = new ZombieCardSet("Toxic City Mall", 67 to 78)

  val Sections = List(
    new ZombieCardSet("Easy Section", 1 to 24),
    new ZombieCardSet("Harder Section", 25 to 36),
    new ZombieCardSet("Exceptional Section", 37 to 42),
    new ZombieCardSet("Walk of the Dead", 43 to 54)
  )

  val ExpansionPacks = List(
    new ZombieCardSet("Walk of the Dead", 43 to 54),
    new ZombieCardSet("Toxic City Mall", 67 to 78),
    new ZombieCardSet("Zombie Dogs", 55 to 66),
    new ZombieCardSet("Walk of the Dead 2", 121 to 132),
    new ZombieCardSet("Toxic Crowd", 133 to 138),
    new ZombieCardSet("Angry Zombies", 139 to 144)
  )

  val SuggestedDecks = List(
    Season1,
    PrisonOutbreak,
    new ZombieCardSet("Season 1 + Toxic City Mall", Season1.rawIds ++ ToxicCityMall.rawIds),
    new ZombieCardSet("Prison Outbreak + Toxic City Mall", PrisonOutbreak.rawIds ++ ToxicCityMall.rawIds),

    new ZombieCardSet("Season 1 + Walk of the Dead (Abomination Pack)", 1 to 54),
    new ZombieCardSet("Predictable", 1 to 12),
    new ZombieCardSet("Sunday Walk in Zombieland", 1 to 24),
    new ZombieCardSet("No Sudden Death", (1 to 12) ++ (25 to 36) ++ (41 to 42)),
    new ZombieCardSet("On Your Guard", (1 to 12) ++ (25 to 36) ++ (37 to 42)),
    new ZombieCardSet("Zombie Hell", (25 to 36) ++ (37 to 42)),
    new ZombieCardSet("Walk of the Dead", 43 to 54)
  )
}