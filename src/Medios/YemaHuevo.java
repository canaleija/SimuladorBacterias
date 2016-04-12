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
public class YemaHuevo implements Medio{
    private Color colorMedio;
    
    public YemaHuevo() {
        definirColor();
    }

    @Override
    public void definirColor() {
        int rojo = 220;
        int verde = 218;
        int azul = 24;
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
