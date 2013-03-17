package com.zzorba.zombicide

import com.zzorba.cards.Deck

class ZombieDeck(override val discardPile: Seq[ZombieCard],
                 override val drawPile: Seq[ZombieCard]) extends Deck[ZombieCard]
