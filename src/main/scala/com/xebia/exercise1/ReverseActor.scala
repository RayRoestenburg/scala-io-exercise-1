package com.xebia.exercise1

import akka.actor.{Actor, Props}

object ReverseActor {
  def props = Props[ReverseActor]
  def name = "reverse"
  case class Reverse(value:String)
  case class ReverseResult(value:String)
}

class ReverseActor extends Actor{
  import ReverseActor._
  def receive = {
    case Reverse(value) => sender ! ReverseResult(value.reverse)
  }

}
