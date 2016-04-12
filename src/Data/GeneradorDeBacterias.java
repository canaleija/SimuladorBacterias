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
import Medios.BairdParker;
import Medios.EMB;
import Medios.SalmonellaShigella;
import Medios.VerdeBrillante;
import Medios.YemaHuevo;
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
    private String medio;

    public GeneradorDeBacterias(int numBacterias) {
        this.numBacterias = numBacterias;
    }

    /**
     * @return the imagenColonias
     */
    public Image getImagenColonias(String bacteria, String medio) {
        String nombreBacteria = bacteria;
        String nombreMedio = medio;
        this.imagenColonias = generaImagen(nombreBacteria, nombreMedio);
        return this.imagenColonias;
    }

    /**
     * @return the numBacterias
     */
    public int getNumBacterias() {
        return numBacterias;
    }

    private Image generaImagen(String nombreBacteria, String nombreMedio) {
        this.bacteria = nombreBacteria;
        this.medio = nombreMedio;

        BufferedImage buffer = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);

        switch (medio) {
            case "EMB":
                EMB emb;
                for (int x = 0; x < buffer.getWidth(); x++) {
                    for (int y = 0; y < buffer.getHeight(); y++) {
                        emb = new EMB();
                        buffer.setRGB(x, y, emb.getColorMedio().getRGB());
                    }
                }
                break;
            case "Verde Brillante":
                VerdeBrillante verdeBrillante;
                for (int x = 0; x < buffer.getWidth(); x++) {
                    for (int y = 0; y < buffer.getHeight(); y++) {
                        verdeBrillante = new VerdeBrillante();
                        buffer.setRGB(x, y, verdeBrillante.getColorMedio().getRGB());
                    }
                }
                break;
            case "Baird Parker":
                BairdParker bairdParker;
                for (int x = 0; x < buffer.getWidth(); x++) {
                    for (int y = 0; y < buffer.getHeight(); y++) {
                        bairdParker = new BairdParker();
                        buffer.setRGB(x, y, bairdParker.getColorMedio().getRGB());
                    }
                }
                break;
            case "Yema de Huevo":
                YemaHuevo yemaHuevo;
                for (int x = 0; x < buffer.getWidth(); x++) {
                    for (int y = 0; y < buffer.getHeight(); y++) {
                        yemaHuevo = new YemaHuevo();
                        buffer.setRGB(x, y, yemaHuevo.getColorMedio().getRGB());
                    }
                }
                break;
            case "Salmonella Shigella":
                SalmonellaShigella salmonellaShigella;
                for (int x = 0; x < buffer.getWidth(); x++) {
                    for (int y = 0; y < buffer.getHeight(); y++) {
                        salmonellaShigella = new SalmonellaShigella();
                        buffer.setRGB(x, y, salmonellaShigella.getColorMedio().getRGB());
                    }
                }
                break;
            default:
                for (int x = 0; x < buffer.getWidth(); x++) {
                    for (int y = 0; y < buffer.getHeight(); y++) {
                        buffer.setRGB(x, y, new Color(255, 255, 255).getRGB());
                    }
                }
                break;
        }
        
        switch (bacteria) {
            case "E. coli":
                // GENERAMOS Y DIBUJAMOS LAS BACTERIAS
                EscherichiaColi ecoli;

                int r = 120;
                int g = 174;
                int b = 58;
                int color = (r << 16) | (g << 8) | b;

                for (int x = 0; x < this.numBacterias; x++) {
                    ecoli = new EscherichiaColi();
                    ecoli.definirTamaño(100);
                    buffer.setRGB((int) ecoli.getPosicionFinal().getX(),
                            (int) ecoli.getPosicionFinal().getY(),
                            new Color(color).getRGB());
                }
                break;
            case "B. cereus":
                BacillusCereus bcereus;
                for (int x = 0; x < this.numBacterias; x++) {
                    bcereus = new BacillusCereus();
                    bcereus.definirTamaño(100);
                    buffer.setRGB((int) bcereus.getPosicionFinal().getX(),
                            (int) bcereus.getPosicionFinal().getY(),
                            new Color(0, 0, 0).getRGB());
                }
                break;
            case "S. aureus":
                StaphilococousAureus saureus;
                for (int x = 0; x < this.numBacterias; x++) {
                    saureus = new StaphilococousAureus();
                    saureus.definirTamaño(100);
                    buffer.setRGB((int) saureus.getPosicionFinal().getX(),
                            (int) saureus.getPosicionFinal().getY(),
                            new Color(0, 0, 0).getRGB());
                }
                break;
            case "S. typhimurium":
                SalmonellaTyphimurium stiphy;
                for (int x = 0; x < this.numBacterias; x++) {
                    stiphy = new SalmonellaTyphimurium();
                    stiphy.definirTamaño(100);
                    buffer.setRGB((int) stiphy.getPosicionFinal().getX(),
                            (int) stiphy.getPosicionFinal().getY(),
                            new Color(0, 0, 0).getRGB());
                }
                break;
            case "Muestra mixta":
                break;
        }
        return buffer.getScaledInstance(300, 300, BufferedImage.TYPE_INT_RGB);
    }
}