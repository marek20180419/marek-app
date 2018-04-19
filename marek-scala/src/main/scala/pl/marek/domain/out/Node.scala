package pl.marek.domain.out

case class Node(id: Int, name: String, var nodes: List[Node])