package br.com.caminha.boundary;

import br.com.caminha.entity.Car;
import br.com.caminha.entity.Color;
import br.com.caminha.entity.Specification;
import br.com.caminha.exposers.annotations.DefaultColor;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

public class CarFactory {

    @Inject
    @DefaultColor
    Color defaultColor;

    private Client client;
    private WebTarget target;

    @PostConstruct
    public void initClient() {
        client = ClientBuilder.newClient();
        target = client.target("http://externalwebsite.com/identifier-gen");
    }

    Car createCar(Specification specification) {
        Car car = new Car();
        car.setIdentifier(retrieveCarIdentification(specification));
        car.setColor(specification.getColor() == null ? defaultColor : specification.getColor());
        car.setEngineType(specification.getEngineType());
        return car;
    }

    private String retrieveCarIdentification(Specification specification) {
        JsonObject jsonObject = buildJsonObjectRequest(specification);
        Response response = sendRequest(jsonObject);
        return extractIdentifierFromResponse(response);
    }

    private String extractIdentifierFromResponse(Response response) {
        return response
                .readEntity(JsonObject.class)
                .getString("identifier");
    }

    private Response sendRequest(JsonObject jsonObject) {
        return target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(jsonObject));
    }

    private JsonObject buildJsonObjectRequest(Specification specification) {
        return Json.createObjectBuilder()
                .add("engine", specification.getEngineType().toString())
                .build();
    }
}