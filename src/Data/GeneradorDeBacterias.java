/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * - Genera N bacterias de un tipo en especifico
 * -
 */
package Data;

import Bacterias.EscherichiaColi;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author CANALEIJA
 */
public class GeneradorDeBacterias {
    
    private Image imagenColonias;
    private int numBacterias;

    public GeneradorDeBacterias( int numBacterias) {
      
        this.numBacterias = numBacterias;
    }

    /**
     * @return the imagenColonias
     */
    public Image getImagenColonias() {
        this.imagenColonias = generaImagen();
        return this.imagenColonias;
    }

    /**
     * @return the numBacterias
     */
    public int getNumBacterias() {
        return numBacterias;
    }

    private Image generaImagen() {
        BufferedImage buffer = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        for (int x=0; x < buffer.getWidth();x++)
            for (int y=0; y < buffer.getHeight();y++){
            buffer.setRGB(x, y, new Color(255, 255, 255).getRGB());
            }
        // GENERAMOS Y DIBUJAMOS LAS BACTERIAS
        EscherichiaColi aux;
        for (int x=0; x < this.numBacterias;x++){
           aux = new EscherichiaColi();
           aux.definirTamaño(100);
           buffer.setRGB((int)aux.getPosicionFinal().getX(),(int) aux.getPosicionFinal().getY(), new Color(0, 0, 0).getRGB());
        }
      
        return  buffer.getScaledInstance(300,300,BufferedImage.TYPE_INT_RGB);
    }
    
    

 
    
    
    
}
