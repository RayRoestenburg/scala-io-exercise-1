package com.xebia.exercise1

import org.specs2.mutable.Specification
import TestSupport._
import spray.testkit.Specs2RouteTest

class ReverseActorSpec extends Specification with Specs2RouteTest {

  "The ReverseActor" should {
    "Reverse a string that it receive and determine if the string is a palindrome" in new AkkaTestkitContext(system) {
      // You can use the TestKit here, it is provided by the AkkaTestkitContext
      // The ImplicitSender is also available so you can expect responses to be sent to the testActor
      // which can be asserted with the TestKit expect... methods.
      //
      // TODO make this test work

      import ReverseActor._

      val reverseActor = system.actorOf(props, name)

      reverseActor ! Reverse("reverse this!")

      expectMsg("!siht esrever")

      expectNoMsg()

    }
  }
}
