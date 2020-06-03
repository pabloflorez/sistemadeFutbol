package Archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pablo
 */
public class EscribirArchivo {
    
    public static void main(String[] args) {
        String fileName = "temp.txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Soy Pablo");
            bufferedWriter.write(" here is some text.");
            bufferedWriter.newLine();
            bufferedWriter.write("We are writing");
            bufferedWriter.write(" the text to the file.");

            bufferedWriter.close();
            
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
        }///con esto lee y escribe sobre un archivo, interesante, lo que tiene que ponerse a ver es como hacer para que no se
        //sobre escriba la info del archivo
        //es decirr hoy guardo todos los equipos y mañana cuando lo abra cargo lo que hay en el archivo y debo escribir 
        //mas abajo o buscar por clave de equipo o algo así 
    }
    
    
    public void guardarEquipo(String nombreEquipo, String nombreTecnico, int cantJugadores){
        String fileName = "equipos.txt";

        File file = new File(fileName);

        
        
        try {
            
            Scanner sc = new Scanner(file);
            String aux = "";
            while(sc.hasNext()){
                aux += sc.nextLine() +"\n";
            }
            
            FileWriter fileWriter = new FileWriter(fileName);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //bufferedWriter.newLine();
            bufferedWriter.write(aux);
            bufferedWriter.write(nombreEquipo + ","+ nombreTecnico + ","+ cantJugadores);
            
            bufferedWriter.close();
            
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }
    
    
}
