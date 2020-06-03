package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Esta clase asigna aleatoriamente los equipos en grupos de 4
 * @author Juan y Jenny
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Grupo {
       
    //atributos de la clase
    
    String nombreGrupo;
    Equipo equipos[]= new Equipo[4];
    ArrayList<Integer> goles = new ArrayList<>();
    ArrayList<Partido> partidos = new ArrayList<>();
    int FIL=4;
    int COL=6;
    int resultados[][] = new int [FIL][COL];
    
    Scanner tc = new Scanner(System.in);

    //
    
    public Grupo(String n) {
    
        this.nombreGrupo = n;
        
    }
    
    //
    
    public void agregarEquipo(Equipo e, int posicion){
      
        equipos[posicion]= e;
    
    }
    
    //este método crea los partidos entre los grupos
    
    public void crearPartidos(){
        
        for (int i = 0; i < equipos.length; i++) {
            for (int j = i+1; j < equipos.length; j++) {                          
                Partido p = new Partido(equipos[i], equipos[j]);
                partidos.add(p);
            }
        }
           
    }
    
    //este método ingresa las estadisticas de un partido
    
    public void ingresarInformacion(){

        for (int i = 0; i < partidos.size(); i++) {
            for (int j = i+1; j < partidos.size(); j++) {   
                
                
                
            }
        }
    	
       
    }
    
}
