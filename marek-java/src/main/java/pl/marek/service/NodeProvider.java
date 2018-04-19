package pl.marek.service;

import pl.marek.model.Node;

import java.util.List;

public interface NodeProvider {
    List<Node> retrieveNodes();
}
