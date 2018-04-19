package pl.marek.serializers

import spray.json.{DefaultJsonProtocol, JsonFormat}
import pl.marek.domain.out.{FailedResponse, Node, SuccessfulResponse}

trait Protocols extends DefaultJsonProtocol {

  implicit val nodeFormat: JsonFormat[Node] = lazyFormat(jsonFormat3(Node.apply))
  implicit val scrFormat = jsonFormat2(SuccessfulResponse.apply)
  implicit val fcrFormat = jsonFormat2(FailedResponse.apply)

}