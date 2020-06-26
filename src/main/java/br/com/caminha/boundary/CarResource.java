package br.com.caminha.boundary;

import br.com.caminha.entity.Car;
import br.com.caminha.entity.Specification;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

    @Inject
    CarManufacturer carManufacturer;

    @GET
    public List<Car> getCars() {
        return carManufacturer.retrieveCars();
    }

    @POST
    public void saveNewCar(Specification specification) {
        carManufacturer.manufactureCar(specification);
    }
}
