package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * esta clase se encarga de crear los partidos del torneo
 * 26/05/2020
 * @author Juan y Jeny
 */

public class Partido{
    
    Equipo equipo1;
    Equipo equipo2;
    
    /**
     * este constructor recibe de a 2 equipos para enfrentarlos en un partido
     * @param e1 es el equipo uno
     * @param e2 es el equipo dos
     */
    
    public Partido(Equipo e1, Equipo e2){
        equipo1 = e1;
        equipo2 = e2;        
    }
    
    public Equipo getEquipo1() {
        return equipo1;
    }


    public Equipo getEquipo2() {
        return equipo2;
    }
    
}

 
