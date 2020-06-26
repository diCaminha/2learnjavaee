package br.com.caminha.control;

import br.com.caminha.entity.Color;

import javax.enterprise.inject.Produces;

public class DefaultColorExposer {

    @Produces
    public Color exposeDefaultColor() {
        return Color.BLUE;
    }
}
