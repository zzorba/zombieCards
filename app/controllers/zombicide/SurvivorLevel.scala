package com.zzorba.zombicide

object SurvivorLevel extends Enumeration {
  val Blue = Value("Blue")
  val Yellow = Value("Yellow")
  val Orange = Value("Orange")
  val Red = Value("Red")

  def next(level: SurvivorLevel.Value): Option[SurvivorLevel.Value] = level match {
    case SurvivorLevel.Blue => Some(SurvivorLevel.Yellow)
    case SurvivorLevel.Yellow => Some(SurvivorLevel.Orange)
    case SurvivorLevel.Orange => Some(SurvivorLevel.Red)
    case SurvivorLevel.Red => None
  }

  def previous(level: SurvivorLevel.Value): Option[SurvivorLevel.Value] = level match {
    case SurvivorLevel.Blue => None
    case SurvivorLevel.Yellow => Some(SurvivorLevel.Blue)
    case SurvivorLevel.Orange => Some(SurvivorLevel.Yellow)
    case SurvivorLevel.Red => Some(SurvivorLevel.Orange)
  }
}