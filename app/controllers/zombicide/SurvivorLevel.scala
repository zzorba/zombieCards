package com.zzorba.zombicide

object SurvivorLevel extends Enumeration {
  val Blue = Value("blue")
  val Yellow = Value("yellow")
  val Orange = Value("orange")
  val Red = Value("red")

  def next(level: SurvivorLevel.Value): Option[SurvivorLevel.Value] = level match {
    case SurvivorLevel.Blue => Some(SurvivorLevel.Yellow)
    case SurvivorLevel.Yellow => Some(SurvivorLevel.Orange)
    case SurvivorLevel.Orange => Some(SurvivorLevel.Red)
    case SurvivorLevel.Red => None
  }
}