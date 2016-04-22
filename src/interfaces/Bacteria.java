/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Data.Rango;
import java.awt.Dimension;

/**
 *
 * @author CANALEIJA
 */
public interface Bacteria {
    
   void definirForma();
   void definirPosicion(Dimension dimensionCaja);
   void definirColor(Rango rangoColor);
   void definirTamaño(double diametro);
   void definirTiempoDuplicacion(double x1, double x2, double y1,double y2);
}