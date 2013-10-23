package com.xebia.exercise1

import spray.http.StatusCodes
import spray.routing._

import spray.httpx.SprayJsonSupport._
import scala.concurrent.{ExecutionContext, Future}
import akka.util.Timeout

class Receptionist extends HttpServiceActor with ReverseRoute {

  //TODO add a createChild method which creates a child actor from props and name

  def receive = runRoute(reverseRoute)

}

trait ReverseRoute extends HttpService {

  //TODO define a val that returns the one ActorRef to the reverse actor using the createChild method

  def reverseRoute:Route = path("reverse") {
    post {
      entity(as[ReverseRequest]) { request =>
        import ExecutionContext.Implicits.global
        import scala.concurrent.duration._
        implicit val timeout = Timeout(20 seconds)

        import akka.pattern.ask

        //TODO replace the next line by asking the actor to Reverse
        //and converting (hint: mapping) the result to a Future[ReverseResponse]
        val futureResponse = Future.successful(ReverseResponse(request.value.reverse))

        complete(futureResponse)
      }
    }
  }
}

