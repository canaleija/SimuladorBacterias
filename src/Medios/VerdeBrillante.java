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
    
    public VerdeBrillante() {
        definirColor();
    }

    @Override
    public void definirColor() {
        int rojo = 176;
        int verde = 198;
        int azul = 54;
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
