package com.xebia.exercise1

import org.specs2.mutable.Specification
import TestSupport._
import spray.testkit.Specs2RouteTest

//TODO implement
class ReverseActorSpec extends Specification with Specs2RouteTest {

  "The ReverseActor" should {
    "Reverse a string that it receive and determine if the string is a palindrome" in new AkkaTestkitContext(system) {

      // create the actor
      // send message
      // expect the message
      // expect no messages after the expected message
    }
  }
}
