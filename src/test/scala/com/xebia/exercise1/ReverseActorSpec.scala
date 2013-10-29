package com.xebia
package exercise1

import org.specs2.mutable.Specification

import spray.testkit.Specs2RouteTest

import TestSupport._

class ReverseActorSpec extends Specification {

  "The ReverseActor" should {
    "Reverse a string that it receives" in new AkkaTestkitContext() {
      // You can use the TestKit here, it is provided by the AkkaTestkitContext
      // The ImplicitSender is also available so you can expect responses to be sent to the testActor
      // which can be asserted with the TestKit expect... methods.
      //

      import ReverseActor._

//TODO make this test work, uncomment the commented lines below

//      val reverseActor = system.actorOf(props, name)
//
//      reverseActor ! Reverse("reverse this!")
//
//      expectMsg(ReverseResult("!siht esrever"))

      expectNoMsg()

    }
  }
}
