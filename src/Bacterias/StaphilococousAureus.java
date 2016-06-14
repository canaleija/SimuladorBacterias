/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bacterias;

import interfaces.Bacteria;
import Data.Ellipse2dAdapter;
import Data.Rango;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author CANALEIJA
 */
public class StaphilococousAureus implements Bacteria {

    private Point2D posicionFinal;
    private Shape recipiente, bacteria;
    private double diametro;
    private Color colorBacteria;

    public StaphilococousAureus() {
        definirColor(null);
        definirTamaño(1);
        definirPosicion(new Dimension(300, 300));
        definirForma();

    }

    @Override
    public void definirForma() {
        this.bacteria = new Ellipse2dAdapter.Float((float) this.getPosicionFinal().getX(), 
                (float) this.getPosicionFinal().getY(), 
                (float) this.diametro, 
                (float) this.diametro);

    }

    @Override
    public void definirPosicion(Dimension dimensionCaja) {
        // DECLARAMOS X y Y
        int x, y;
        // construir la el elipse
        this.recipiente = new Ellipse2D.Float(0, 0, dimensionCaja.width, dimensionCaja.height);
        Random ran = new Random();
        x = ran.nextInt((int) dimensionCaja.getWidth());
        y = ran.nextInt((int) dimensionCaja.getHeight());
        Point2D aux = new Point(x, y * -1);
        // GENERA PUNTOS HASTA ECONTRAR PUNTO VALIDO
        while (!validar(aux)) {
            // GENERAMOS UN NUEVO PUNTO ALEATORIO
            ran = new Random();
            x = ran.nextInt((int) dimensionCaja.getWidth());
            y = ran.nextInt((int) dimensionCaja.getHeight());
            aux = new Point(x, y);

        }
        // GUARDAMOS/ASIGNAMOS EL PUNTO VALIDO
        this.posicionFinal = aux;
    }

    @Override
    public void definirColor(Rango rangoColor) {
        // definimos en colores negros
        // Color colorInicial = new Color(0);
        this.colorBacteria = new Color(255);

    }

    @Override
    public void definirTamaño(double diametro) {
        // definiendo el diametro del elipse
        this.diametro = diametro;

    }

    @Override
    public void definirTiempoDuplicacion(double x1, double x2, double y1, double y2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean validar(Point2D point) {
        if (this.recipiente.contains(point)) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void dibujarBacteria (BufferedImage bi,int color){
      // construir maskara con respecto al tamaño
        for (int x= (int)this.posicionFinal.getX();x < this.diametro+(int)this.posicionFinal.getX();x++)   
           for (int y= (int)this.posicionFinal.getY();y < this.diametro+(int)this.posicionFinal.getY();y++){
               Point2D nuevoPunto = new Point(x, y);
               
               if (validar(nuevoPunto)){
                 bi.setRGB(x, y, color);
               }
           }   
    }

    @Override
    public boolean equals(Object obj) {
        Point aux = (Point) obj;
        if (aux.getX() == this.getPosicionFinal().getX() && aux.getY() == this.getPosicionFinal().getY()) {
            return true;
        }
        return false;
    }

    /**
     * @return the posicionFinal
     */
    public Point2D getPosicionFinal() {
        return posicionFinal;
    }
}