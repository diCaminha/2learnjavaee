package br.com.caminha.exposers;

import br.com.caminha.entity.Color;
import br.com.caminha.exposers.annotations.DefaultColor;

import javax.enterprise.inject.Produces;

public class DefaultColorExposer {

    @Produces
    @DefaultColor
    public Color exposeDefaultColor() {
        return Color.BLUE;
    }
}
