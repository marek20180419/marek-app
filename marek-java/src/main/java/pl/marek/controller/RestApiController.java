package pl.marek.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.marek.model.Node;
import pl.marek.model.SuccessfulResponse;
import pl.marek.service.NodeProvider;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    private NodeProvider nodeProvider;

    public RestApiController(@Autowired NodeProvider nodeProvider) {
        this.nodeProvider = nodeProvider;
    }

    @RequestMapping(value = "/nodes/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuccessfulResponse> listAllUsers() {
        List<Node> nodes = nodeProvider.retrieveNodes();
        if (nodes.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        SuccessfulResponse response = new SuccessfulResponse();
        response.setData(nodes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}