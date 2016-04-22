/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Medios;

import interfaces.Medio;
import java.awt.Color;

/**
 *
 * @author É
 */
public class BairdParker implements Medio{
    private Color colorMedio;
    private Color colorStiphy;
    
    public BairdParker() {
        definirColor();
    }

    @Override
    public void definirColor() {
        int rojo = 221;
        int verde = 225;
        int azul = 114;
        int color = (rojo << 16) | (verde << 8) | azul;
        colorMedio = new Color(color);
    }

    public void definirColorStiphy() {
        int r = 255;
        int g = 253;
        int b = 255;
        int color = (r << 16) | (g << 8) | b;
        colorStiphy = new Color(color);
    }

    /**
     * @return the colorMedio
     */
    public Color getColorMedio() {
        return colorMedio;
    } 

    /**
     * @return the colorStiphy
     */
    public Color getColorStiphy() {
        return colorStiphy;
    }
}
