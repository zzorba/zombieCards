package com.zzorba.zombicide

import com.zzorba.cards.Card

sealed trait ZombieBehavior

object ZType extends Enumeration {
  val Normal = Value("normal")
  val Toxic = Value("toxic")
  val Berserker = Value("berserker")
}

object ZombieType extends Enumeration {
  val Walker = Value("walker")
  val Fatty = Value("fatty")
  val Runner = Value("runner")
  val Abomination = Value("abomination")
  val Dog = Value("dog")

  def plural(zombieType: ZombieType.Value, zType: ZType.Value, count: Int): String = {
    (zType match {
      case ZType.Normal => ""
      case ZType.Toxic => "Toxic "
      case ZType.Berserker => "Berserker "
    }) +
    (if (count == 1) zombieType match {
      case ZombieType.Walker => "Walker"
      case ZombieType.Fatty => "Fatty"
      case ZombieType.Runner => "Runner"
      case ZombieType.Abomination => "Abomination"
      case ZombieType.Dog => "Dog"
    } else zombieType match {
      case ZombieType.Walker => "Walkers"
      case ZombieType.Fatty => "Fatties"
      case ZombieType.Runner => "Runners"
      case ZombieType.Abomination => "Abominations"
      case ZombieType.Dog => "Dogs"
    })
  }
}
object ZombieBehavior {
  case object Clear extends ZombieBehavior

  case class Spawn(zombieType: ZombieType.Value,
                   count: Int,
                   zType: ZType.Value,
                   sewer: Boolean) extends ZombieBehavior

  def SpawnWalkers(count: Int,
                   zType: ZType.Value = ZType.Normal,
                   sewer: Boolean = false) =
    Spawn(ZombieType.Walker, count, zType, sewer)

  def SpawnFatties(count: Int,
                   zType: ZType.Value = ZType.Normal,
                   sewer: Boolean = false) =
    Spawn(ZombieType.Fatty, count, zType, sewer)

  def SpawnRunners(count: Int,
                   zType: ZType.Value = ZType.Normal,
                   sewer: Boolean = false) =
    Spawn(ZombieType.Runner, count, zType, sewer)

  def SpawnAbom(zType: ZType.Value = ZType.Normal) =
    Spawn(ZombieType.Abomination, 1, zType, sewer = false)

  def SpawnDogs(count: Int, sewer: Boolean = false) =
    Spawn(ZombieType.Dog, count, ZType.Normal, sewer)


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