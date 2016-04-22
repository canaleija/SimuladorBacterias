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
public class VerdeBrillante implements Medio{
    private Color colorMedio;
    private Color colorEcoli;
    private Color colorStiphy;
    
    public VerdeBrillante() {
        definirColor();
    }

    @Override
    public void definirColor() {
        int rojo = 187;
        int verde = 122;
        int azul = 42;
        int color = (rojo << 16) | (verde << 8) | azul;
        colorMedio = new Color(color);
    }
    
    public void definirColorEcoli() {
        int r = 171;
        int g = 177;
        int b = 97;
        int color = (r << 16) | (g << 8) | b;
        colorEcoli = new Color(color);
    }

    public void definirColorStiphy() {
        int r = 255;
        int g = 191;
        int b = 165;
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
     * @return the colorEcoli
     */
    public Color getColorEcoli() {
        return colorEcoli;
    }

    /**
     * @return the colorStiphy
     */
    public Color getColorStiphy() {
        return colorStiphy;
    }
}
