/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.awt.Color;

/**
 *
 * @author CANALEIJA
 */
public class Rango {

    private Color colorInicial;
    private Color colorFinal;

    public Rango(Color colorInicial, Color colorFinal) {
        this.colorInicial = colorInicial;
        this.colorFinal = colorFinal;
    }

    /**
     * @return the colorInicial
     */
    public Color getColorInicial() {
        return colorInicial;
    }

    /**
     * @param colorInicial the colorInicial to set
     */
    public void setColorInicial(Color colorInicial) {
        this.colorInicial = colorInicial;
    }

    /**
     * @return the colorFinal
     */
    public Color getColorFinal() {
        return colorFinal;
    }

    /**
     * @param colorFinal the colorFinal to set
     */
    public void setColorFinal(Color colorFinal) {
        this.colorFinal = colorFinal;
    }
}