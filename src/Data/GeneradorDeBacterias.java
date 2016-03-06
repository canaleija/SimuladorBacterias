
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * - Genera N bacterias de un tipo en especifico
 * -
 */
package Data;

import Bacterias.BacillusCereus;
import Bacterias.EscherichiaColi;
import Bacterias.SalmonellaTyphimurium;
import Bacterias.StaphilococousAureus;
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
    private String bacteria;

    public GeneradorDeBacterias(int numBacterias) {

        this.numBacterias = numBacterias;
    }

    /**
     * @return the imagenColonias
     */
    public Image getImagenColonias(String bacteria) {
        String nombreBacteria = bacteria;
        this.imagenColonias = generaImagen(nombreBacteria);
        return this.imagenColonias;
    }

    /**
     * @return the numBacterias
     */
    public int getNumBacterias() {
        return numBacterias;
    }

    private Image generaImagen(String nombreBacteria) {
        this.bacteria = nombreBacteria;

        BufferedImage buffer = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < buffer.getWidth(); x++) {
            for (int y = 0; y < buffer.getHeight(); y++) {
                buffer.setRGB(x, y, new Color(255, 255, 255).getRGB());
            }
        }

        switch (bacteria) {
            case "E.Coli":
                // GENERAMOS Y DIBUJAMOS LAS BACTERIAS
                EscherichiaColi ecoli;
                for (int x = 0; x < this.numBacterias; x++) {
                    ecoli = new EscherichiaColi();
                    ecoli.definirTamaño(100);
                    buffer.setRGB((int) ecoli.getPosicionFinal().getX(),
                            (int) ecoli.getPosicionFinal().getY(),
                            new Color(0, 0, 0).getRGB());
                }
                break;
            case "B.Cereus":
                BacillusCereus bcereus;
                for (int x = 0; x < this.numBacterias; x++) {
                    bcereus = new BacillusCereus();
                    bcereus.definirTamaño(100);
                    buffer.setRGB((int) bcereus.getPosicionFinal().getX(),
                            (int) bcereus.getPosicionFinal().getY(),
                            new Color(0, 0, 0).getRGB());
                }
                break;
            case "S.Aureus":
                StaphilococousAureus saureus;
                for (int x = 0; x < this.numBacterias; x++) {
                    saureus = new StaphilococousAureus();
                    saureus.definirTamaño(100);
                    buffer.setRGB((int) saureus.getPosicionFinal().getX(),
                            (int) saureus.getPosicionFinal().getY(),
                            new Color(0, 0, 0).getRGB());
                }
                break;
            case "S.Typhimurium":
                SalmonellaTyphimurium stiphy;
                for (int x = 0; x < this.numBacterias; x++) {
                    stiphy = new SalmonellaTyphimurium();
                    stiphy.definirTamaño(100);
                    buffer.setRGB((int) stiphy.getPosicionFinal().getX(),
                            (int) stiphy.getPosicionFinal().getY(),
                            new Color(0, 0, 0).getRGB());
                }
                break;
        }
        return buffer.getScaledInstance(300, 300, BufferedImage.TYPE_INT_RGB);
    }
}