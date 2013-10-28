package com.xebia.exercise1

import org.specs2.mutable.Specification
import TestSupport._

class ReverseActorSpec extends Specification {

  "The ReverseActor" should {
    "Reverse a string that it receives" in new AkkaTestkitContext() {

      import ReverseActor._

      val reverseActor = system.actorOf(props, name)

      reverseActor ! Reverse("reverse this!")

      expectMsg(ReverseResult("!siht esrever"))

      expectNoMsg()

    }
  }
}
