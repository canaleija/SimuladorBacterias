/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author CANALEIJA
 */
public class Mask {

  
    public enum Mascaras {TRESXTRES}
    
    private int mask[][];
    
    private int n;

    public Mask(int[][] mask) {
        this.mask = mask;
        this.n = mask[0].length;
    }

    public Mask(int n) {
        this.n = n;
        this.mask = new int[n][n];
                       
    }
    
    public Mask (Mascaras mascara){
         switch (mascara){
         
             case TRESXTRES:{
                 
                 construirMascara3x3();
                 break;
             
             }
             default:{
             this.mask = null;
             }
         
         }
    
    }

    /**
     * @return the mask
     */
    public int[][] getMask() {
 
        
        return mask;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }
      
      private void construirMascara3x3() {
        this.mask = new int[][]{{0,1,0},{1,1,1},{0,1,0}};
   
    }    
}