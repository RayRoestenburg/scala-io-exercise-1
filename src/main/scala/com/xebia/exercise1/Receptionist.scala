package com.xebia.exercise1

import scala.concurrent.duration._

import spray.routing._

import spray.httpx.SprayJsonSupport._
import scala.concurrent.{ExecutionContext, Future}
import akka.util.Timeout
import akka.actor.{Props, ActorRef}
import com.xebia.exercise1.ReverseActor.{ReverseResult, Reverse}

class Receptionist extends HttpServiceActor with ReverseRoute {
  implicit def executionContext = context.dispatcher

  def createChild(props:Props, name:String) = context.actorOf(props, name)
  def receive = runRoute(reverseRoute)

}

trait ReverseRoute extends HttpService {
  // we need this so we can use Futures and Timeout
  implicit def executionContext: ExecutionContext

  def createChild(props:Props, name:String):ActorRef

  val reverseActor = createChild(ReverseActor.props, ReverseActor.name)


  def reverseRoute:Route = path("reverse") {
    post {
      entity(as[ReverseRequest]) { request =>
        implicit val timeout = Timeout(20 seconds)

        import akka.pattern.ask

        val futureResponse = reverseActor.ask(Reverse(request.value))
                                         .mapTo[ReverseResult]
                                         .map(r=> ReverseResponse(r.value))

        complete(futureResponse)
      }
    }
  }
}

