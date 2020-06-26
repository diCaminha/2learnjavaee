package br.com.caminha.boundary;

import br.com.caminha.entity.Car;
import br.com.caminha.entity.Color;
import br.com.caminha.entity.Specification;
import br.com.caminha.exposers.annotations.DefaultColor;

import javax.inject.Inject;
import java.util.UUID;

public class CarFactory {

    @Inject
    @DefaultColor
    Color defaultColor;

    public CarFactory() {
    }

    Car createCar(Specification specification) {
        Car car = new Car();
        car.setIdentifier(UUID.randomUUID().toString());
        car.setColor(specification.getColor() == null ? defaultColor : specification.getColor());
        car.setEngineType(specification.getEngineType());
        return car;
    }
}