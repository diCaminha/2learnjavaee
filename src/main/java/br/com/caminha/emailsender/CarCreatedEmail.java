package br.com.caminha.emailsender;

import br.com.caminha.entity.CarCreated;

import javax.enterprise.event.Observes;

public class CarCreatedEmail {

    public void onCarCreatedSendEmail(@Observes CarCreated carCreated) {
        System.out.println("sending an email...");
    }
}
