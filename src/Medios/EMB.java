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

    /**
     * @return the colorMedio
     */
    public Color getColorMedio() {
        return colorMedio;
    } 
}