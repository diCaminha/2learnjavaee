package br.com.caminha.boundary;

import br.com.caminha.control.CarRepository;
import br.com.caminha.entity.Car;
import br.com.caminha.entity.CarCreated;
import br.com.caminha.entity.Specification;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;

    @Inject
    CarRepository carRepository;

    @Inject
    private Event<CarCreated> carCreatedEvent;

    public Car manufactureCar(Specification specification) {
        Car car = carFactory.createCar(specification);
        carRepository.store(car);
        carCreatedEvent.fire(new CarCreated(car.getIdentifier()));
        return car;
    }

    public List<Car> retrieveCars() {
        return carRepository.loadCars();
    }
}
