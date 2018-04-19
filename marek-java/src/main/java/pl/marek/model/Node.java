package pl.marek.model;

import java.util.List;

public class Node {

	private int id;
	
	private String name;
	
	private List<Node> nodes;

	public Node() {
	}

	public Node(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Node(int id, String name, List<Node> nodes) {
		this.id = id;
		this.name = name;
		this.nodes = nodes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	@Override
	public String toString() {
		return "Node{" +
				"id=" + id +
				", name='" + name + '\'' +
				", nodes=" + nodes +
				'}';
	}
}
