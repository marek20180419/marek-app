package pl.marek

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory

object Main extends App with ScaleRest with CorsSupport {

  val config = ConfigFactory.load()
  val host = config.getString("http.host")
  val port = config.getInt("http.port")

  implicit val system = ActorSystem("scale-service")
  implicit val materializer = ActorMaterializer()

  implicit val executionContext = system.dispatcher

  val api = routes

  Http().bindAndHandle(handler = corsHandler(api), interface = host, port = port)
}
