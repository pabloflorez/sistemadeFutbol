package Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pablo
 */
public class LeerArchivo {
    
    public static void main(String[] args) {
        String fileName = "temp.txt";

        try {
            
            File file = new File(fileName);

            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
    }
    
    
    
    
}
