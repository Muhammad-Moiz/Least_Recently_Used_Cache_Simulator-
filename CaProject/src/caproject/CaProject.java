/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caproject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xone-pc
 */
public class CaProject {

    /**
     * 2@param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scan;
        try {
            scan = new Scanner(new File("input.txt"));
            
            

            
            
            cache c= new cache();
            for(int i=0;scan.hasNextInt();i++){
           //     System.out.println("iteration "+i);
            c.lookup(scan.nextInt());
                   
        for(int j=0;j<10; j++){
           System.out.print(c.cache_lines[j].offset + " ");
       }
//                System.out.print("          Prdge : " + c.perguratory[0].offset + " " + c.perguratory[1].offset);
            System.out.println("");
            }
            
            
            System.out.println("over here");
            
       for(int i=0; i<10; i++){
           System.out.print(c.cache_lines[i].offset + " ");
       }
            System.out.println("");
       for(int i=0; i<10; i++){
           System.out.print(c.index_array[i] + " ");
       }
            System.out.println("");
            System.out.println("miss: " + c.misses);
            System.out.println("hit: " + c.hits);
            double missrate;
            missrate=c.misses/(c.misses+c.hits);
            System.out.println("miss rate "+ missrate);
            double hitrate=c.hits/(c.misses+c.hits);
            System.out.println("hit rate "+ hitrate);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaProject.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
        
    }
}
