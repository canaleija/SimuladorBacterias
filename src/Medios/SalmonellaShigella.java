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

    /**
     * @return the colorMedio
     */
    public Color getColorMedio() {
        return colorMedio;
    } 
}
