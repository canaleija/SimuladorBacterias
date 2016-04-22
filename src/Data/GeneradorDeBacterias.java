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
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author CANALEIJA
 */
public class GeneradorDeBacterias {

    private Image imagenColonias;
    private int numBacterias;
    private int numImagenes;
    private String bacteria;
    private String medio;
    private BufferedImage buffer;

    public GeneradorDeBacterias(int numBacterias) {
        this.numBacterias = numBacterias;
    }

    /**
     * @return the imagenColonias
     */
    public Image getImagenColonias(String bacteria, String medio, int numImagenes) {
        String nombreBacteria = bacteria;
        String nombreMedio = medio;
        int imagenes = numImagenes;
        this.imagenColonias = generaImagen(nombreBacteria, nombreMedio, imagenes);
        return this.imagenColonias;
    }

    /**
     * @return the numBacterias
     */
    public int getNumBacterias() {
        return numBacterias;
    }

    private Image generaImagen(String nombreBacteria, String nombreMedio, int numImagenes) {
        this.bacteria = nombreBacteria;
        this.medio = nombreMedio;
        this.numImagenes = numImagenes;

        buffer = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);

        generarImagen();

        return buffer.getScaledInstance(300, 300, BufferedImage.TYPE_INT_RGB);
    }

    public void generarImagen() {
        
        for(int x = 1; x <= numImagenes; x++) {
            try {
                generarBacteria(bacteria, medio);
                // retrieve image
                String nombreImagen = "muestra_" + bacteria + "_" + medio + "_" + x + ".png";
                File outputfile = new File(nombreImagen);
                ImageIO.write(buffer, "png", outputfile);
            } catch (IOException e) {}
        }
    }

    public void generarBacteria(String bacteria, String medio) {

        // EMB
        if (medio.equals("EMB") && bacteria.equals("E. coli")) {
            EMB emb = new EMB();
            EscherichiaColi ecoli;
            for (int x = 0; x < buffer.getWidth(); x++) {
                for (int y = 0; y < buffer.getHeight(); y++) {
                    buffer.setRGB(x, y, emb.getColorMedio().getRGB());
                }
            }
            for (int x = 0; x < this.numBacterias; x++) {
                emb.definirColorEcoli();
                ecoli = new EscherichiaColi();
                ecoli.definirTamaño(100);
                buffer.setRGB((int) ecoli.getPosicionFinal().getX(),
                        (int) ecoli.getPosicionFinal().getY(),
                        emb.getColorEcoli().getRGB());
            }
        }

        if (medio.equals("EMB") && bacteria.equals("S. typhimurium")) {
            EMB emb = new EMB();
            SalmonellaTyphimurium stiphy;
            for (int x = 0; x < buffer.getWidth(); x++) {
                for (int y = 0; y < buffer.getHeight(); y++) {
                    buffer.setRGB(x, y, emb.getColorMedio().getRGB());
                }
            }
            for (int x = 0; x < this.numBacterias; x++) {
                emb.definirColorStiphy();
                stiphy = new SalmonellaTyphimurium();
                stiphy.definirTamaño(100);
                buffer.setRGB((int) stiphy.getPosicionFinal().getX(),
                        (int) stiphy.getPosicionFinal().getY(),
                        emb.getColorStiphy().getRGB());
            }
        }

        // Salmonella-Shigella
        if (medio.equals("Salmonella Shigella") && bacteria.equals("E. coli")) {
            SalmonellaShigella ss = new SalmonellaShigella();
            EscherichiaColi ecoli;
            for (int x = 0; x < buffer.getWidth(); x++) {
                for (int y = 0; y < buffer.getHeight(); y++) {
                    buffer.setRGB(x, y, ss.getColorMedio().getRGB());
                }
            }
            for (int x = 0; x < this.numBacterias; x++) {
                ss.definirColorEcoli();
                ecoli = new EscherichiaColi();
                ecoli.definirTamaño(100);
                buffer.setRGB((int) ecoli.getPosicionFinal().getX(),
                        (int) ecoli.getPosicionFinal().getY(),
                        ss.getColorEcoli().getRGB());
            }
        }

        if (medio.equals("Salmonella Shigella") && bacteria.equals("S. typhimurium")) {
            SalmonellaShigella ss = new SalmonellaShigella();
            SalmonellaTyphimurium stiphy;
            for (int x = 0; x < buffer.getWidth(); x++) {
                for (int y = 0; y < buffer.getHeight(); y++) {
                    buffer.setRGB(x, y, ss.getColorMedio().getRGB());
                }
            }
            for (int x = 0; x < this.numBacterias; x++) {
                ss.definirColorStiphy();
                stiphy = new SalmonellaTyphimurium();
                stiphy.definirTamaño(100);
                buffer.setRGB((int) stiphy.getPosicionFinal().getX(),
                        (int) stiphy.getPosicionFinal().getY(),
                        ss.getColorStiphy().getRGB());
            }
        }

        //Verde Brillante
        if (medio.equals("Verde Brillante") && bacteria.equals("E. coli")) {
            VerdeBrillante vb = new VerdeBrillante();
            EscherichiaColi ecoli;
            for (int x = 0; x < buffer.getWidth(); x++) {
                for (int y = 0; y < buffer.getHeight(); y++) {
                    buffer.setRGB(x, y, vb.getColorMedio().getRGB());
                }
            }
            for (int x = 0; x < this.numBacterias; x++) {
                vb.definirColorEcoli();
                ecoli = new EscherichiaColi();
                ecoli.definirTamaño(100);
                buffer.setRGB((int) ecoli.getPosicionFinal().getX(),
                        (int) ecoli.getPosicionFinal().getY(),
                        vb.getColorEcoli().getRGB());
            }
        }

        if (medio.equals("Verde Brillante") && bacteria.equals("S. typhimurium")) {
            VerdeBrillante vb = new VerdeBrillante();
            SalmonellaTyphimurium stiphy;
            for (int x = 0; x < buffer.getWidth(); x++) {
                for (int y = 0; y < buffer.getHeight(); y++) {
                    buffer.setRGB(x, y, vb.getColorMedio().getRGB());
                }
            }
            for (int x = 0; x < this.numBacterias; x++) {
                vb.definirColorStiphy();
                stiphy = new SalmonellaTyphimurium();
                stiphy.definirTamaño(100);
                buffer.setRGB((int) stiphy.getPosicionFinal().getX(),
                        (int) stiphy.getPosicionFinal().getY(),
                        vb.getColorStiphy().getRGB());
            }
        }

        //Baird Parker
        if (medio.equals("Baird Parker") && bacteria.equals("S. typhimurium")) {
            BairdParker bp = new BairdParker();
            SalmonellaTyphimurium stiphy;
            for (int x = 0; x < buffer.getWidth(); x++) {
                for (int y = 0; y < buffer.getHeight(); y++) {
                    buffer.setRGB(x, y, bp.getColorMedio().getRGB());
                }
            }
            for (int x = 0; x < this.numBacterias; x++) {
                bp.definirColorStiphy();
                stiphy = new SalmonellaTyphimurium();
                stiphy.definirTamaño(100);
                buffer.setRGB((int) stiphy.getPosicionFinal().getX(),
                        (int) stiphy.getPosicionFinal().getY(),
                        bp.getColorStiphy().getRGB());
            }
        }

        //Baird Parker
        if (medio.equals("Yema de Huevo") && bacteria.equals("B. cereus")) {
            YemaHuevo yh = new YemaHuevo();
            BacillusCereus bcereus;
            for (int x = 0; x < buffer.getWidth(); x++) {
                for (int y = 0; y < buffer.getHeight(); y++) {
                    buffer.setRGB(x, y, yh.getColorMedio().getRGB());
                }
            }
            for (int x = 0; x < this.numBacterias; x++) {
                yh.definirColorBcereus();
                bcereus = new BacillusCereus();
                bcereus.definirTamaño(100);
                buffer.setRGB((int) bcereus.getPosicionFinal().getX(),
                        (int) bcereus.getPosicionFinal().getY(),
                        yh.getColorBcereus().getRGB());
            }
        }
    }
}