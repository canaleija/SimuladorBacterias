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
public class SalmonellaShigella implements Medio{
    private Color colorMedio;
    private Color colorEcoli;
    private Color colorStiphy;
    
    public SalmonellaShigella() {
        definirColor();
    }

    @Override
    public void definirColor() {
        int rojo = 238;
        int verde = 8;
        int azul = 52;
        int color = (rojo << 16) | (verde << 8) | azul;
        colorMedio = new Color(color);
    }
    
    public void definirColorEcoli() {
        int r = 159;
        int g = 86;
        int b = 115;
        int color = (r << 16) | (g << 8) | b;
        colorEcoli = new Color(color);
    }
    
    // Falta cambiar el color
    public void definirColorStiphy() {
        int r = 220;
        int g = 193;
        int b = 136;
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
