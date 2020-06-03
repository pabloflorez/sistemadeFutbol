package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * esta clase se encarga de crear jugadores y añadir
 * información estadistica sobre alguno de ellos
 * 03/05/2020
 * @author Juan y Jenny
 */

import java.util.Scanner;

public class Jugador {
    
    Scanner tc = new Scanner(System.in);
    
    //atributos de la clase
    
    String nombreJugador;
    int golesMarcados;
    int tarjetasAmarillas;
    int tarjetasRojas;
    int numAsistencias;
    int numAsignado;    
    int Estadisticas[][];
    
    /**
     * este constructor crea un jugador con la información que se reciba de la clase equipo
     * @param n nombre del jugador
     * @param na numero asignado al jugador
     */

    public Jugador() {
    }

    public Jugador(String n, int na) {
        this.nombreJugador = n;
        this.numAsignado = na;
    }

    public void Estadisticas(int gm,int na, int ta,int tr){
        
        this.golesMarcados=gm;
        this.numAsistencias=na;
        this.tarjetasAmarillas=ta;
        this.tarjetasRojas=tr;
        
        
        Estadisticas = new int[17][4];
        
        for (int i = 0; i < Estadisticas.length; i++) {
                
                Estadisticas[i][0]=gm;
                Estadisticas[i][1]=na;
                Estadisticas[i][2]=ta;
                Estadisticas[i][3]=tr;

        }
        
    }
}
