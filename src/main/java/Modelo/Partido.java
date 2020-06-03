/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Pablo
 */
public class Partido{
    
    Equipo equipo1;
    Equipo equipo2;
    
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

 