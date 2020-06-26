package br.com.caminha.boundary;

import br.com.caminha.control.CarRepository;
import br.com.caminha.entity.Car;
import br.com.caminha.entity.Specification;

import javax.inject.Inject;

public class CarManufacturer {

    @Inject
    CarFactory carFactory;

    @Inject
    CarRepository carRepository;

    public Car manufactureCar(Specification specification) {
        Car car = carFactory.createCar(specification);
        carRepository.store(car);
        return car;
    }
}
