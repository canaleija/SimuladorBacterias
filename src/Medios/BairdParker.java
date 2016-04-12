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

    /**
     * @return the colorMedio
     */
    public Color getColorMedio() {
        return colorMedio;
    } 
}
