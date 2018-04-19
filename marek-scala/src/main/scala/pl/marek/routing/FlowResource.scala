package pl.marek.routing

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpRequest, HttpResponse}
import akka.stream.Materializer
import akka.stream.scaladsl.{Flow, Sink, Source}
import pl.marek.serializers.Protocols

import scala.concurrent.ExecutionContext

trait FlowResource extends Protocols {

  implicit def executionContext: ExecutionContext

  implicit val system: ActorSystem
  implicit val materializer: Materializer

  def createFlow(url: String): Flow[HttpRequest, HttpResponse, Any] =
    Http().outgoingConnectionHttps(url)

  def goByFlow(request: HttpRequest, flow: Flow[HttpRequest, HttpResponse, Any]) =
    Source.single(request).via(flow).runWith(Sink.head)
}