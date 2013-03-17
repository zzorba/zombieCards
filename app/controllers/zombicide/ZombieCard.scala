package com.zzorba.zombicide

import com.zzorba.cards.Card

sealed trait ZombieBehavior

object ZombieType extends Enumeration {
  val Walker = Value("walker")
  val Fatty = Value("fatty")
  val Runner = Value("runner")
  val Abomination = Value("abomination")

  def plural(zombieType: ZombieType.Value, count: Int): String = {
    if (count == 1) zombieType match {
      case ZombieType.Walker => "Walker"
      case ZombieType.Fatty => "Fatty"
      case ZombieType.Runner => "Runner"
      case ZombieType.Abomination => "Abomination"
    } else zombieType match {
      case ZombieType.Walker => "Walkers"
      case ZombieType.Fatty => "Fatties"
      case ZombieType.Runner => "Runners"
      case ZombieType.Abomination => "Abominations"
    }
  }
}
object ZombieBehavior {
  case object Clear extends ZombieBehavior

  case class Spawn(zombieType: ZombieType.Value, count: Int, sewer: Boolean) extends ZombieBehavior
  def SpawnWalkers(count: Int, sewer: Boolean = false) = Spawn(ZombieType.Walker, count, sewer)
  def SpawnFatties(count: Int, sewer: Boolean = false) = Spawn(ZombieType.Fatty, count, sewer)
  def SpawnRunners(count: Int, sewer: Boolean = false) = Spawn(ZombieType.Runner, count, sewer)
  def SpawnAbomination = Spawn(ZombieType.Abomination, 1, sewer = false)

  case class ExtraActivation(zombieType: ZombieType.Value) extends ZombieBehavior
  val ExtraActivationWalkers = ExtraActivation(ZombieType.Walker)
  val ExtraActivationFatties  = ExtraActivation(ZombieType.Fatty)
  val ExtraActivationRunners  = ExtraActivation(ZombieType.Runner)
}
case class ZombieBehaviors(blue: ZombieBehavior, yellow: ZombieBehavior, orange: ZombieBehavior, red: ZombieBehavior) {
  def forLevel(level: SurvivorLevel.Value): ZombieBehavior = level match {
    case SurvivorLevel.Blue => blue
    case SurvivorLevel.Yellow => yellow
    case SurvivorLevel.Orange => orange
    case SurvivorLevel.Red => red
  }
}

case class ZombieCard(override val id: Byte, behaviors: ZombieBehaviors) extends Card