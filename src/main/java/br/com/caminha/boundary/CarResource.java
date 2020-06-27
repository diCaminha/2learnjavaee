package br.com.caminha.boundary;

import br.com.caminha.entity.Car;
import br.com.caminha.entity.Specification;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

    @Inject
    CarManufacturer carManufacturer;

    @GET
    public JsonArray getCars() {
        List<Car> cars = carManufacturer.retrieveCars();
        return cars.stream()
                .map(c -> Json.createObjectBuilder()
                        .add("id", c.getIdentifier())
                        .add("color", c.getColor().toString())
                        .add("engine", c.getEngineType().toString())
                        .add("anotherAttrb", "another attr value")
                .build()).collect(JsonCollectors.toJsonArray());
    }

    @POST
    public void saveNewCar(Specification specification) {
        carManufacturer.manufactureCar(specification);
    }
}
