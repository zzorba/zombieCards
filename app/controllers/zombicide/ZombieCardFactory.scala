package com.zzorba.zombicide

import com.zzorba.cards.CardFactory
import com.zzorba.zombicide.ZombieBehavior._

object ZombieCardFactory extends CardFactory[ZombieCard] {
  val allCards: Map[Byte, ZombieCard] = Map(
     1 -> ZombieBehaviors(Clear,            SpawnRunners(2),  SpawnRunners(2),  SpawnWalkers(5)),
     2 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnWalkers(6),  SpawnWalkers(7)),
     3 -> ZombieBehaviors(SpawnWalkers(1),  SpawnRunners(1),  SpawnFatties(1),  SpawnRunners(4)),
     4 -> ZombieBehaviors(SpawnWalkers(2),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnRunners(2)),
     5 -> ZombieBehaviors(Clear,            SpawnWalkers(4),  SpawnFatties(2),  SpawnWalkers(5)),
     6 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnRunners(3),  SpawnWalkers(7)),
     7 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(2),  SpawnWalkers(2),  SpawnRunners(4)),
     8 -> ZombieBehaviors(SpawnWalkers(2),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnFatties(2)),
     9 -> ZombieBehaviors(Clear,            SpawnWalkers(4),  SpawnRunners(2),  SpawnWalkers(5)),
    10 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnRunners(3),  SpawnWalkers(7)),
    11 -> ZombieBehaviors(SpawnWalkers(1),  SpawnRunners(1),  SpawnRunners(1),  SpawnFatties(4)),
    12 -> ZombieBehaviors(SpawnFatties(1),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnRunners(2)),
    // Repeat cards 1-12 as 13-24
    13 -> ZombieBehaviors(Clear,            SpawnRunners(2),  SpawnRunners(2),  SpawnWalkers(5)),
    14 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnWalkers(6),  SpawnWalkers(7)),
    15 -> ZombieBehaviors(SpawnWalkers(1),  SpawnRunners(1),  SpawnFatties(1),  SpawnRunners(4)),
    16 -> ZombieBehaviors(SpawnWalkers(2),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnRunners(2)),
    17 -> ZombieBehaviors(Clear,            SpawnWalkers(4),  SpawnFatties(2),  SpawnWalkers(5)),
    18 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnRunners(3),  SpawnWalkers(7)),
    19 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(2),  SpawnWalkers(2),  SpawnRunners(4)),
    20 -> ZombieBehaviors(SpawnWalkers(2),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnFatties(2)),
    21 -> ZombieBehaviors(Clear,            SpawnWalkers(4),  SpawnRunners(2),  SpawnWalkers(5)),
    22 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnRunners(3),  SpawnWalkers(7)),
    23 -> ZombieBehaviors(SpawnWalkers(1),  SpawnRunners(1),  SpawnRunners(1),  SpawnFatties(4)),
    24 -> ZombieBehaviors(SpawnFatties(1),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnRunners(2)),

    25 -> ZombieBehaviors(SpawnWalkers(1),  SpawnRunners(2),  SpawnWalkers(5),  SpawnFatties(3)),
    26 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(2),  SpawnWalkers(3),  SpawnWalkers(7)),
    27 -> ZombieBehaviors(SpawnWalkers(2),  SpawnWalkers(2),  SpawnRunners(3),  SpawnFatties(4)),
    28 -> ZombieBehaviors(SpawnWalkers(2),  SpawnAbomination, SpawnRunners(2),  SpawnWalkers(5)),
    29 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(4),  SpawnAbomination, SpawnWalkers(6)),
    30 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(2),  SpawnWalkers(6),  SpawnAbomination),
    31 -> ZombieBehaviors(SpawnRunners(1),  SpawnRunners(1),  SpawnWalkers(3),  SpawnWalkers(8)),
    32 -> ZombieBehaviors(SpawnFatties(1),  SpawnWalkers(3),  SpawnFatties(2),  SpawnWalkers(5)),
    33 -> ZombieBehaviors(SpawnWalkers(1),  SpawnRunners(2),  SpawnWalkers(5),  SpawnRunners(3)),
    34 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(2),  SpawnRunners(3),  SpawnWalkers(7)),
    35 -> ZombieBehaviors(SpawnRunners(1),  SpawnFatties(1),  SpawnWalkers(3),  SpawnRunners(4)),
    36 -> ZombieBehaviors(SpawnAbomination, SpawnWalkers(3),  SpawnRunners(2),  SpawnWalkers(5)),

    37 -> ZombieBehaviors(Clear, ExtraActivationWalkers, ExtraActivationWalkers, ExtraActivationWalkers),
    38 -> ZombieBehaviors(Clear, ExtraActivationWalkers, ExtraActivationWalkers, ExtraActivationWalkers),
    39 -> ZombieBehaviors(Clear, ExtraActivationFatties, ExtraActivationFatties, ExtraActivationFatties),
    40 -> ZombieBehaviors(Clear, ExtraActivationRunners, ExtraActivationRunners, ExtraActivationRunners),


    41 -> ZombieBehaviors(SpawnWalkers(1, sewer = true), SpawnWalkers(2, sewer = true),
                          SpawnFatties(1, sewer = true), SpawnRunners(1, sewer = true)),
    42 -> ZombieBehaviors(SpawnWalkers(1, sewer = true), SpawnRunners(1, sewer = true),
                          SpawnWalkers(2, sewer = true), SpawnFatties(1, sewer = true)),

    // Walk of the dead, repeated 3x
    43 -> ZombieBehaviors(Clear,            SpawnWalkers(4),  SpawnWalkers(4),  SpawnWalkers(5)),
    44 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnWalkers(6),  SpawnWalkers(7)),
    45 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(2),  SpawnWalkers(2),  SpawnWalkers(8)),
    46 -> ZombieBehaviors(SpawnWalkers(2),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnWalkers(4)),
    47 -> ZombieBehaviors(Clear,            SpawnWalkers(4),  SpawnWalkers(4),  SpawnWalkers(5)),
    48 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnWalkers(6),  SpawnWalkers(7)),
    49 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(2),  SpawnWalkers(2),  SpawnWalkers(8)),
    50 -> ZombieBehaviors(SpawnWalkers(2),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnWalkers(4)),
    51 -> ZombieBehaviors(Clear,            SpawnWalkers(4),  SpawnWalkers(4),  SpawnWalkers(5)),
    52 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnWalkers(6),  SpawnWalkers(7)),
    53 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(2),  SpawnWalkers(2),  SpawnWalkers(8)),
    54 -> ZombieBehaviors(SpawnWalkers(2),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnWalkers(4))
  ).map(s => {
    val id = s._1.toByte
    id -> ZombieCard(id, s._2)
  })

  override def forId(id: Byte): ZombieCard = {
    allCards.getOrElse(id,
      throw new Exception("Invalid card %d".format(id))
    )
  }

  override def createDeck(discard: Seq[ZombieCard], draw: Seq[ZombieCard]): ZombieDeck = {
    new ZombieDeck(discard, draw)
  }
}