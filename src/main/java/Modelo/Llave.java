package Modelo;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * esta clase se encarga de crear las fases de eliminación
 * 10/05/2020
 * @author Juan y Jenny
 */

public class Llave {
    
    Scanner tc = new Scanner(System.in);
    
    int cantidadEquiposClasificados;
    String nombreEquipos;
    String nombreDeLaFase;
    Equipo mapaLlaves[];
    int puntuacionEquipos;
    String ganador;
    
    //este método ingresa los resultados de la clase grupo para crear el mapa de llaves
    
    public void ingresarResultados(int cec, String ne){
    
       // Torneo restantes = new Torneo();
        
        /*for(int i=0;i<restantes.equipos.length;i++){
            System.out.println((i+1.)+restantes.equipos.length);
        }*/
        
        System.out.println("Ingrese cuántos equipos clasificaron: ");
        cantidadEquiposClasificados = tc.nextInt();
        
        if(cantidadEquiposClasificados % 2 == 0){
            if(cantidadEquiposClasificados==32){
                nombreDeLaFase="Dieciseisavos de final.";
            }
            else{
                if(cantidadEquiposClasificados==16){
                   nombreDeLaFase="Octavos de final."; 
                }
                else {
                    if(cantidadEquiposClasificados==8){
                         nombreDeLaFase="Cuartos de final.";
                    }
                    else{
                        if (cantidadEquiposClasificados==4){
                            nombreDeLaFase="Semifinal.";
                        }
                        else{
                            if(cantidadEquiposClasificados==2){
                                nombreDeLaFase="Final.";
                            }
                        }
                    }
                }
            }
        }
        else{
            System.out.println("Error, la cantidad de equipos debe ser par.");
        }
        
        mapaLlaves = new Equipo[cantidadEquiposClasificados];
        
        for (int i=0;i<mapaLlaves.length;i++){
            
        }
    }

    
    //este método genera los ganadores de las llaves
    
    public String generarGanador(int pe, String ne){
    
    return "";
        
    }
    
}
