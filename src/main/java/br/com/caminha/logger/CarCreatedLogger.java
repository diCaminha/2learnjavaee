package br.com.caminha.logger;

import br.com.caminha.entity.CarCreated;

import javax.enterprise.event.Observes;

public class CarCreatedLogger {

    public void onCarCreated(@Observes CarCreated carCreated) {
        System.out.println("a car was created with id: " + carCreated.getIdentifier());
    }
}
