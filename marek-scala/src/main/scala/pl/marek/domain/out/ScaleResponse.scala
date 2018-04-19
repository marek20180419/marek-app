package pl.marek.domain.out

case class FailedResponse(message: String, code: Int = 1)
case class SuccessfulResponse(data: List[Node], code: Int = 0)
