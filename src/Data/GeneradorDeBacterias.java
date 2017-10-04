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
import Medios.BairdParker;
import Medios.EMB;
import Medios.SalmonellaShigella;
import Medios.VerdeBrillante;
import Medios.YemaHuevo;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author CANALEIJA
 */
public class GeneradorDeBacterias {

    private Image imagenColonias;
    private int numBacterias;
    private int numImagenes;
    private ArrayList<String> bacteria;
    private String medio;
    private BufferedImage buffer;
    private int numBact1 = 0, numBact2 = 0;
    public String dirPath;

    public GeneradorDeBacterias(int numBacterias) {
        this.numBacterias = numBacterias;
        numBact1 = 1 + (int) (Math.random() * ((this.numBacterias - 1) + 1));
        numBact2 =  this.numBacterias - numBact1;
    }

    /**
     * @return the imagenColonias
     */
    public Image getImagenColonias(ArrayList<String> bacteria, String medio, int numImagenes) {
        ArrayList<String> nombreBacteria = bacteria;
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

    private Image generaImagen(ArrayList<String> nombreBacteria, String nombreMedio, int numImagenes) {
        this.bacteria = nombreBacteria;
        this.medio = nombreMedio;
        this.numImagenes = numImagenes;

        buffer = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);

        generarImagen();

        return buffer.getScaledInstance(300, 300, BufferedImage.TYPE_INT_RGB);
    }

    public void generarImagen() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Random rand = new Random();
        String nombreDir = "Muestra_" + rand.nextInt()+ "_" + medio + "_" + dateFormat.format(date) + "_"  + bacteria;
        File dir = new File(nombreDir);
        dir.mkdir();
        dirPath = dir.getAbsolutePath();

        if (bacteria.size() == 1) {
            for (int x = 1; x <= numImagenes; x++) {
                try {
                    generarBacteria(bacteria, medio);
                    // retrieve image
                    String nombreImagen = numBacterias + "_" + bacteria + "_" + medio + "_" + x + ".png";
                    File outputfile = new File(dir, nombreImagen);
                    ImageIO.write(buffer, "png", outputfile);
                } catch (IOException e) {
                }
            }
        } else {
            for (int x = 1; x <= numImagenes; x++) {
                try {
                    generarMixta(bacteria, medio);
                    // retrieve image
                    String nombreImagen = numBacterias + "_" + bacteria + "_" + medio + "_" + x + ".png";
                    File outputfile = new File(dir, nombreImagen);
                    ImageIO.write(buffer, "png", outputfile);
                } catch (IOException e) {
                }
            }
        }
    }

    public void generarMixta(ArrayList<String> bacterias, String medio) {

        if (medio.equals("EMB") && bacteria.contains("E. coli") && bacteria.contains("S. typhimurium")) {
            EMB emb = new EMB();
            EscherichiaColi ecoli;
            SalmonellaTyphimurium typhi;

            for (int x = 0; x < buffer.getWidth(); x++) {
                for (int y = 0; y < buffer.getHeight(); y++) {
                    buffer.setRGB(x, y, emb.getColorMedio().getRGB());
                }
            }

            for (int x = 0; x < getNumBact1(); x++) {
                emb.definirColorEcoli();
                ecoli = new EscherichiaColi();
                ecoli.definirTamaño(3);
                ecoli.dibujarBacteria(buffer, emb.getColorEcoli().getRGB());
            }
            for (int x = 0; x < getNumBact2(); x++) {
                emb.definirColorStiphy();
                typhi = new SalmonellaTyphimurium();
                typhi.definirTamaño(3);
                typhi.dibujarBacteria(buffer, emb.getColorStiphy().getRGB());
            }
        }

        if (medio.equals("Verde Brillante") && bacteria.contains("E. coli") && bacteria.contains("S. typhimurium")) {
            VerdeBrillante verdeBrillante = new VerdeBrillante();
            EscherichiaColi ecoli;
            SalmonellaTyphimurium typhi;

            for (int x = 0; x < buffer.getWidth(); x++) {
                for (int y = 0; y < buffer.getHeight(); y++) {
                    buffer.setRGB(x, y, verdeBrillante.getColorMedio().getRGB());
                }
            }

            for (int x = 0; x < getNumBact1(); x++) {
                verdeBrillante.definirColorEcoli();
                ecoli = new EscherichiaColi();
                ecoli.definirTamaño(3);
                ecoli.dibujarBacteria(buffer, verdeBrillante.getColorEcoli().getRGB());
            }
            for (int x = 0; x < getNumBact2(); x++) {
                verdeBrillante.definirColorStiphy();
                typhi = new SalmonellaTyphimurium();
                typhi.definirTamaño(3);
                typhi.dibujarBacteria(buffer, verdeBrillante.getColorStiphy().getRGB());
            }
        }
        if (medio.equals("Salmonella Shigella") && bacteria.contains("E. coli") && bacteria.contains("S. typhimurium")) {
            SalmonellaShigella ss = new SalmonellaShigella();
            EscherichiaColi ecoli;
            SalmonellaTyphimurium tiphy;

            for (int x = 0; x < buffer.getWidth(); x++) {
                for (int y = 0; y < buffer.getHeight(); y++) {
                    buffer.setRGB(x, y, ss.getColorMedio().getRGB());
                }
            }
            for (int x = 0; x < getNumBact1(); x++) {
                ss.definirColorEcoli();
                ecoli = new EscherichiaColi();
                ecoli.definirTamaño(5);
                ecoli.dibujarBacteria(buffer, ss.getColorEcoli().getRGB());
            }
            for (int x = 0; x < getNumBact2(); x++) {
                ss.definirColorStiphy();
                tiphy = new SalmonellaTyphimurium();
                tiphy.definirTamaño(5);
                tiphy.dibujarBacteria(buffer, ss.getColorStiphy().getRGB());
            }
        }
    }

    public void generarBacteria(ArrayList<String> bacteria, String medio) {

        // EMB
        if (medio.equals("EMB") && bacteria.contains("E. coli")) {
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
                ecoli.definirTamaño(3);
                ecoli.dibujarBacteria(buffer, emb.getColorEcoli().getRGB());
            }
        }

        if (medio.equals("EMB") && bacteria.contains("S. typhimurium")) {
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
                stiphy.definirTamaño(3);
                stiphy.dibujarBacteria(buffer, emb.getColorStiphy().getRGB());
            }
        }

        // Salmonella-Shigella
        if (medio.equals("Salmonella Shigella") && bacteria.contains("E. coli")) {
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
                ecoli.definirTamaño(5);
                ecoli.dibujarBacteria(buffer, ss.getColorEcoli().getRGB());
            }
        }

        if (medio.equals("Salmonella Shigella") && bacteria.contains("S. typhimurium")) {
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
                stiphy.definirTamaño(5);
                stiphy.dibujarBacteria(buffer, ss.getColorStiphy().getRGB());
            }
        }

        //Verde Brillante
        if (medio.equals("Verde Brillante") && bacteria.contains("E. coli")) {
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
                ecoli.definirTamaño(3);
                ecoli.dibujarBacteria(buffer, vb.getColorEcoli().getRGB());
            }
        }
        if (medio.equals("Verde Brillante") && bacteria.contains("S. typhimurium")) {
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
                stiphy.definirTamaño(3);

                stiphy.dibujarBacteria(buffer, vb.getColorStiphy().getRGB());
            }
        }

        //Baird Parker
        if (medio.equals("Baird Parker") && bacteria.contains("S. aureus")) {
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
                stiphy.definirTamaño(2);
                stiphy.dibujarBacteria(buffer, bp.getColorStiphy().getRGB());
            }
        }

        //Yema de huevo
        if (medio.equals("Yema de Huevo") && bacteria.contains("B. cereus")) {
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
                bcereus.definirTamaño(15);
                bcereus.dibujarBacteria(buffer, yh.getColorBcereus().getRGB());
            }
        }
    }

    /**
     * @return the numBact1
     */
    public int getNumBact1() {
        return numBact1;
    }

    /**
     * @return the numBact2
     */
    public int getNumBact2() {
        return numBact2;
    }
}