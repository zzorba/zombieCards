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
    28 -> ZombieBehaviors(SpawnWalkers(2),  SpawnAbom(),      SpawnRunners(2),  SpawnWalkers(5)),
    29 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(4),  SpawnAbom(),      SpawnWalkers(6)),
    30 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(2),  SpawnWalkers(6),  SpawnAbom()),
    31 -> ZombieBehaviors(SpawnRunners(1),  SpawnRunners(1),  SpawnWalkers(3),  SpawnWalkers(8)),
    32 -> ZombieBehaviors(SpawnFatties(1),  SpawnWalkers(3),  SpawnFatties(2),  SpawnWalkers(5)),
    33 -> ZombieBehaviors(SpawnWalkers(1),  SpawnRunners(2),  SpawnWalkers(5),  SpawnRunners(3)),
    34 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(2),  SpawnRunners(3),  SpawnWalkers(7)),
    35 -> ZombieBehaviors(SpawnRunners(1),  SpawnFatties(1),  SpawnWalkers(3),  SpawnRunners(4)),
    36 -> ZombieBehaviors(SpawnAbom(),      SpawnWalkers(3),  SpawnRunners(2),  SpawnWalkers(5)),

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
    54 -> ZombieBehaviors(SpawnWalkers(2),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnWalkers(4)),

    // Zombie Dogz
    55 -> ZombieBehaviors(SpawnDogs(1),     SpawnRunners(2),  SpawnDogs(4),     SpawnWalkers(5)),
    56 -> ZombieBehaviors(SpawnWalkers(1),  SpawnDogs(1),     SpawnWalkers(6),  SpawnDogs(7)),
    57 -> ZombieBehaviors(SpawnDogs(1),     SpawnRunners(1),  SpawnDogs(2),     SpawnRunners(4)),
    58 -> ZombieBehaviors(SpawnWalkers(2),  SpawnDogs(3),     SpawnWalkers(4),  SpawnDogs(4)),
    59 -> ZombieBehaviors(SpawnDogs(1),     SpawnWalkers(4),  SpawnDogs(4),     SpawnWalkers(5)),
    60 -> ZombieBehaviors(SpawnWalkers(1),  SpawnDogs(1),     SpawnRunners(3),  SpawnDogs(7)),
    61 -> ZombieBehaviors(SpawnDogs(1),     SpawnWalkers(2),  SpawnDogs(2),     SpawnRunners(4)),
    62 -> ZombieBehaviors(SpawnDogs(2),     SpawnWalkers(3),  SpawnDogs(4),     SpawnFatties(2)),
    63 -> ZombieBehaviors(Clear,            SpawnDogs(4),     SpawnRunners(2),  SpawnDogs(5)),
    64 -> ZombieBehaviors(SpawnDogs(1),     SpawnWalkers(1),  SpawnDogs(6),     SpawnWalkers(7)),
    65 -> ZombieBehaviors(SpawnWalkers(1),  SpawnDogs(2),     SpawnRunners(1),  SpawnDogs(8)),
    66 -> ZombieBehaviors(SpawnFatties(1),  SpawnDogs(3),     SpawnWalkers(4),  SpawnDogs(4)),

    // Toxic City Mall
    67 -> ZombieBehaviors(SpawnWalkers(1, ZType.Toxic), SpawnRunners(2, ZType.Toxic), SpawnWalkers(5, ZType.Toxic), SpawnFatties(3, ZType.Toxic)),
    68 -> ZombieBehaviors(SpawnWalkers(1, ZType.Toxic), SpawnWalkers(2, ZType.Toxic), SpawnRunners(3, ZType.Toxic), SpawnWalkers(7, ZType.Toxic)),
    69 -> ZombieBehaviors(SpawnWalkers(1, ZType.Toxic), SpawnWalkers(2, ZType.Toxic), SpawnWalkers(3, ZType.Toxic), SpawnFatties(4, ZType.Toxic)),
    70 -> ZombieBehaviors(SpawnWalkers(2, ZType.Toxic), SpawnAbom(ZType.Toxic),       SpawnRunners(2, ZType.Toxic), SpawnWalkers(5, ZType.Toxic)),
    71 -> ZombieBehaviors(SpawnWalkers(1, ZType.Toxic), SpawnWalkers(4, ZType.Toxic), SpawnAbom(ZType.Toxic),       SpawnRunners(3, ZType.Toxic)),
    72 -> ZombieBehaviors(SpawnWalkers(1, ZType.Toxic), SpawnWalkers(2, ZType.Toxic), SpawnWalkers(6, ZType.Toxic), SpawnAbom(ZType.Toxic)),
    73 -> ZombieBehaviors(SpawnFatties(1, ZType.Toxic), SpawnRunners(1, ZType.Toxic), SpawnWalkers(3, ZType.Toxic), SpawnWalkers(8, ZType.Toxic)),
    74 -> ZombieBehaviors(SpawnRunners(1, ZType.Toxic), SpawnWalkers(3, ZType.Toxic), SpawnFatties(2, ZType.Toxic), SpawnWalkers(5, ZType.Toxic)),
    75 -> ZombieBehaviors(SpawnWalkers(1, ZType.Toxic), SpawnFatties(2, ZType.Toxic), SpawnWalkers(5, ZType.Toxic), SpawnRunners(3, ZType.Toxic)),
    76 -> ZombieBehaviors(SpawnWalkers(1, ZType.Toxic), SpawnWalkers(2, ZType.Toxic), SpawnFatties(3, ZType.Toxic), SpawnWalkers(7, ZType.Toxic)),
    77 -> ZombieBehaviors(SpawnWalkers(1, ZType.Toxic), SpawnFatties(1, ZType.Toxic), SpawnWalkers(3, ZType.Toxic), SpawnRunners(4, ZType.Toxic)),
    78 -> ZombieBehaviors(SpawnAbom(ZType.Toxic),       SpawnWalkers(3, ZType.Toxic), SpawnRunners(2, ZType.Toxic), SpawnWalkers(5, ZType.Toxic)),

    // Prison Outbreak
    79 -> ZombieBehaviors(SpawnWalkers(1, ZType.Berserker), SpawnRunners(2, ZType.Berserker), SpawnWalkers(5, ZType.Berserker), SpawnFatties(3, ZType.Berserker)),
    80 -> ZombieBehaviors(SpawnWalkers(1, ZType.Berserker), SpawnWalkers(2, ZType.Berserker), SpawnRunners(3, ZType.Berserker), SpawnWalkers(7, ZType.Berserker)),
    81 -> ZombieBehaviors(SpawnWalkers(2, ZType.Berserker), SpawnWalkers(2, ZType.Berserker), SpawnWalkers(3, ZType.Berserker), SpawnFatties(4, ZType.Berserker)),
    82 -> ZombieBehaviors(SpawnWalkers(2, ZType.Berserker), SpawnAbom(ZType.Berserker),       SpawnRunners(2, ZType.Berserker), SpawnWalkers(5, ZType.Berserker)),
    83 -> ZombieBehaviors(SpawnWalkers(1, ZType.Berserker), SpawnWalkers(4, ZType.Berserker), SpawnAbom(ZType.Berserker),       SpawnRunners(3, ZType.Berserker)),
    84 -> ZombieBehaviors(SpawnWalkers(1, ZType.Berserker), SpawnWalkers(2, ZType.Berserker), SpawnWalkers(6, ZType.Berserker), SpawnAbom(ZType.Berserker))
    85 -> ZombieBehaviors(SpawnFatties(1, ZType.Berserker), SpawnRunners(1, ZType.Berserker), SpawnWalkers(3, ZType.Berserker), SpawnWalkers(8, ZType.Berserker)),
    86 -> ZombieBehaviors(SpawnRunners(1, ZType.Berserker), SpawnWalkers(3, ZType.Berserker), SpawnFatties(2, ZType.Berserker), SpawnWalkers(5, ZType.Berserker)),
    87 -> ZombieBehaviors(SpawnWalkers(1, ZType.Berserker), SpawnFatties(2, ZType.Berserker), SpawnWalkers(5, ZType.Berserker), SpawnRunners(3, ZType.Berserker)),
    88 -> ZombieBehaviors(SpawnWalkers(1, ZType.Berserker), SpawnWalkers(2, ZType.Berserker), SpawnFatties(3, ZType.Berserker), SpawnWalkers(7, ZType.Berserker)),
    89 -> ZombieBehaviors(SpawnRunners(1, ZType.Berserker), SpawnFatties(1, ZType.Berserker), SpawnWalkers(3, ZType.Berserker), SpawnRunners(4, ZType.Berserker)),
    90 -> ZombieBehaviors(SpawnAbom(ZType.Berserker),       SpawnWalkers(3, ZType.Berserker), SpawnRunners(2, ZType.Berserker), SpawnWalkers(5, ZType.Berserker)),
    91 -> ZombieBehaviors(Clear,            SpawnRunners(2),  SpawnRunners(2),  SpawnWalkers(5)),
    92 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnWalkers(6),  SpawnWalkers(7)),
    93 -> ZombieBehaviors(SpawnWalkers(1),  SpawnRunners(1),  SpawnFatties(1),  SpawnWalkers(4)),
    94 -> ZombieBehaviors(SpawnWalkers(2),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnRunners(2)),
    95 -> ZombieBehaviors(Clear,            SpawnWalkers(4),  SpawnFatties(2),  SpawnWalkers(5)),
    96 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnRunners(3),  SpawnWalkers(7)),
    97 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(2),  SpawnWalkers(2),  SpawnRunners(4)),
    98 -> ZombieBehaviors(SpawnWalkers(2),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnFatties(2)),
    99 -> ZombieBehaviors(Clear,            SpawnWalkers(4),  SpawnRunners(2),  SpawnWalkers(5)),
   100 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnRunners(3),  SpawnWalkers(7)),
   101 -> ZombieBehaviors(SpawnWalkers(1),  SpawnRunners(1),  SpawnRunners(1),  SpawnFatties(4)),
   102 -> ZombieBehaviors(SpawnFatties(1),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnRunners(2)),
   103 -> ZombieBehaviors(Clear,            SpawnRunners(2),  SpawnRunners(2),  SpawnWalkers(5)),
   104 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnAbom(),      SpawnWalkers(7)),
   105 -> ZombieBehaviors(SpawnWalkers(1),  SpawnRunners(1),  SpawnFatties(1),  SpawnWalkers(4)),
   106 -> ZombieBehaviors(SpawnWalkers(2),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnRunners(2)),
   107 -> ZombieBehaviors(Clear,            SpawnWalkers(4),  SpawnFatties(2),  SpawnWalkers(5)),
   108 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnRunners(3),  SpawnWalkers(7)),
   109 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(2),  SpawnWalkers(2),  SpawnRunners(4)),
   110 -> ZombieBehaviors(SpawnAbom(),      SpawnWalkers(3),  SpawnWalkers(4),  SpawnFatties(2)),
   111 -> ZombieBehaviors(Clear,            SpawnAbom(),      SpawnRunners(2),  SpawnWalkers(5)),
   112 -> ZombieBehaviors(SpawnWalkers(1),  SpawnWalkers(1),  SpawnRunners(3),  SpawnWalkers(7)),
   113 -> ZombieBehaviors(SpawnWalkers(1),  SpawnRunners(1),  SpawnRunners(1),  SpawnAbom()),
   114 -> ZombieBehaviors(SpawnFatties(1),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnRunners(2)),
   115 -> ZombieBehaviors(Clear, ExtraActivationWalkers, ExtraActivationWalkers, ExtraActivationWalkers),
   116 -> ZombieBehaviors(Clear, ExtraActivationWalkers, ExtraActivationWalkers, ExtraActivationWalkers),
   117 -> ZombieBehaviors(Clear, ExtraActivationFatties, ExtraActivationFatties, ExtraActivationFatties),
   118 -> ZombieBehaviors(Clear, ExtraActivationRunners, ExtraActivationRunners, ExtraActivationRunners),
   119 -> ZombieBehaviors(SpawnWalkers(1, sewer = true),  SpawnWalkers(2, sewer = true),  SpawnFatties(1, sewer = true),  SpawnRunners(1, sewer = true)),
   120 -> ZombieBehaviors(SpawnWalkers(1, sewer = true),  SpawnRunners(1, sewer = true),  SpawnWalkers(2, sewer = true),  SpawnFatties(1, sewer = true)),

    // Walk of the Dead 2
   121 -> ZombieBehaviors(SpawnWalkers(1),  SpawnRunners(2),  SpawnWalkers(5),  SpawnFatties(3)),
   122 -> ZombieBehaviors(SpawnWalkers(2),  SpawnWalkers(2),  SpawnRunners(3),  SpawnWalkers(7)),
   123 -> ZombieBehaviors(SpawnRunners(1),  SpawnWalkers(3),  SpawnWalkers(4),  SpawnFatties(4)),
   124 -> ZombieBehaviors(SpawnWalkers(1),  SpawnRunners(2),  SpawnWalkers(5),  SpawnWalkers(6)),
   125 -> ZombieBehaviors(SpawnWalkers(2),  SpawnFatties(1),  SpawnRunners(3),  SpawnWalkers(7)),
   126 -> ZombieBehaviors(SpawnFatties(1),  SpawnWalkers(3),  SpawnFatties(2),  SpawnRunners(4)),
   127 -> ZombieBehaviors(Clear, ExtraActivationWalkers, ExtraActivationWalkers, ExtraActivationWalkers),
   128 -> ZombieBehaviors(Clear, ExtraActivationWalkers, ExtraActivationWalkers, ExtraActivationWalkers),
   129 -> ZombieBehaviors(Clear, ExtraActivationFatties, ExtraActivationFatties, ExtraActivationFatties),
   130 -> ZombieBehaviors(Clear, ExtraActivationRunners, ExtraActivationRunners, ExtraActivationRunners),
   131 -> ZombieBehaviors(SpawnWalkers(1, sewer = true),  SpawnWalkers(2, sewer = true),  SpawnFatties(1, sewer = true),  SpawnRunners(1, sewer = true)),
   132 -> ZombieBehaviors(SpawnWalkers(1, sewer = true),  SpawnRunners(1, sewer = true),  SpawnWalkers(2, sewer = true),  SpawnFatties(1, sewer = true)),

    // Toxic Crowd
   133 -> ZombieBehaviors(Clear,                        SpawnWalkers(4, ZType.Toxic), SpawnWalkers(4, ZType.Toxic), SpawnRunners(3, ZType.Toxic)),
   134 -> ZombieBehaviors(SpawnWalkers(1, ZType.Toxic), SpawnRunners(1, ZType.Toxic), SpawnWalkers(6, ZType.Toxic), SpawnWalkers(7, ZType.Toxic)),
   135 -> ZombieBehaviors(SpawnWalkers(2, ZType.Toxic), SpawnWalkers(3, ZType.Toxic), SpawnRunners(1, ZType.Toxic), SpawnWalkers(8, ZType.Toxic)),
   136 -> ZombieBehaviors(Clear,                        SpawnWalkers(4, ZType.Toxic), SpawnWalkers(4, ZType.Toxic), SpawnFatties(3, ZType.Toxic)),
   137 -> ZombieBehaviors(SpawnWalkers(1, ZType.Toxic), SpawnFatties(1, ZType.Toxic), SpawnRunners(3, ZType.Toxic), SpawnWalkers(7, ZType.Toxic)),
   138 -> ZombieBehaviors(SpawnRunners(1, ZType.Toxic), SpawnWalkers(3, ZType.Toxic), SpawnFatties(1, ZType.Toxic), SpawnWalkers(8, ZType.Toxic)),

    // Angry Zombies
   139 -> ZombieBehaviors(Clear,                            SpawnWalkers(4, ZType.Berserker), SpawnWalkers(4, ZType.Berserker), SpawnRunners(3, ZType.Berserker)),
   140 -> ZombieBehaviors(SpawnWalkers(1, ZType.Berserker), SpawnFatties(1, ZType.Berserker), SpawnWalkers(6, ZType.Berserker), SpawnWalkers(7, ZType.Berserker)),
   141 -> ZombieBehaviors(SpawnWalkers(2, ZType.Berserker), SpawnWalkers(3, ZType.Berserker), SpawnFatties(1, ZType.Berserker), SpawnRunners(4, ZType.Berserker)),
   142 -> ZombieBehaviors(Clear,                            SpawnWalkers(4, ZType.Berserker), SpawnWalkers(4, ZType.Berserker), SpawnFatties(3, ZType.Berserker)),
   143 -> ZombieBehaviors(SpawnWalkers(1, ZType.Berserker), SpawnRunners(1, ZType.Berserker), SpawnRunners(3, ZType.Berserker), SpawnWalkers(7, ZType.Berserker)),
   144 -> ZombieBehaviors(SpawnRunners(1, ZType.Berserker), SpawnWalkers(3, ZType.Berserker), SpawnFatties(1, ZType.Berserker), SpawnWalkers(8, ZType.Berserker))
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