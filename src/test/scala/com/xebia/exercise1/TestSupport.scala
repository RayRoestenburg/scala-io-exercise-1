package com.xebia.exercise1

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}

import org.specs2.specification.After

object TestSupport {

  /** Simple specs2 bridge for Akka TestKit. */
  abstract class AkkaTestkitContext(actorSystem:ActorSystem) extends TestKit(actorSystem) with ImplicitSender with After {
    private var owner = false

    def this() = {
      this(ActorSystem())
      owner = true
    }

    def after {
      if(owner) system.shutdown()
    }
  }
}
