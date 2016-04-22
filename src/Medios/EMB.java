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
public class EMB implements Medio{
    
    private Color colorMedio;
    private Color colorEcoli;
    private Color colorStiphy;
    
    public EMB() {
        definirColor();
    }

    @Override
    public void definirColor() {
        int rojo = 152;
        int verde = 27;
        int azul = 42;
        int color = (rojo << 16) | (verde << 8) | azul;
        colorMedio = new Color(color);
    }
    
    public void definirColorEcoli() {
        int r = 120;
        int g = 174;
        int b = 58;
        int color = (r << 16) | (g << 8) | b;
        colorEcoli = new Color(color);
    }
    
    public void definirColorStiphy() {
        int r = 215;
        int g = 217;
        int b = 215;
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