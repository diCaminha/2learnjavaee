package br.com.caminha.exposers;

import br.com.caminha.entity.Color;
import br.com.caminha.exposers.annotations.PrimaryColor;

import javax.enterprise.inject.Produces;

public class PrimaryColorExposer {

    @Produces
    @PrimaryColor
    public Color exposurePrimaryColor() {
        return Color.YELLOW;
    }
}
