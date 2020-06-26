package br.com.caminha.boundary;

import br.com.caminha.control.CarRepository;
import br.com.caminha.entity.Car;
import br.com.caminha.entity.Specification;

public class CarManufacturer {

    private final CarFactory carFactory = new CarFactory();
    private final CarRepository carRepository = new CarRepository();

    public Car manufactureCar(Specification specification) {
        Car car = carFactory.createCar(specification);
        carRepository.store(car);
        return car;
    }
}
