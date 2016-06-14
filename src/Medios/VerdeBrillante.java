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
        int rojo = 202;
        int verde = 133;
        int azul = 78;
        int color = (rojo << 16) | (verde << 8) | azul;
        colorMedio = new Color(color);
    }
    
    public void definirColorEcoli() {
        int r = 203;
        int g = 103;
        int b = 88;
        int color = (r << 16) | (g << 8) | b;
        colorEcoli = new Color(color);
    }

    public void definirColorStiphy() {
        int r = 255;
        int g = 190;
        int b = 152;
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
