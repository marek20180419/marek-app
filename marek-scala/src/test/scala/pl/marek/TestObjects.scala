package pl.marek

import pl.marek.domain.in.JobResponse
import pl.marek.domain.out.Node

object TestObjects {
  val jobs = List(Node("senior software engineer", 3, Option.empty), Node("intern", 1, Option.empty))
  val job = Node("software engineer", 2, Option.empty)
  val jobResponse = JobResponse("software engineer", "USD", 2, Nil)
}
