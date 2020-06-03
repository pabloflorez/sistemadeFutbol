package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * esta es la clase principal, la cual le muestra 
 * al usuario las opciones que tiene habilitadas
 * y le permite escoger alguna a realizar
 * 04/05/2020
 * @author Juan y Jenny
 */

import java.util.Scanner;

public class Sistema {
    public static void main (String arg[]){
    
    Scanner tc = new Scanner(System.in);
    int respuesta;
    
    Torneo torneo = new Torneo();
    
    do {
    
        System.out.println("*************Bienvenido al Sistema de Fútbol*************");
        System.out.println("De acuerdo a su necesidad, seleccione que desea realizar:");
        System.out.println("1.Crear un nuevo torneo");
        System.out.println("2.Crear un nuevo equipo");
        System.out.println("3.Eliminar un jugador de un equipo");
        System.out.println("4.Iniciar fase de grupos");
        System.out.println("5.Registrar los resultados de un partido");
        System.out.println(".Generar las llaves de la siguiente fase");
        System.out.println(".Registrar resultados de una llave");
        System.out.println(".Ver información de un jugador");
        System.out.println(".Generar informe por torneo");
        System.out.println(".Salir");
        System.out.println("**********************************************************");
        respuesta = tc.nextInt();
        
        switch(respuesta){
        
            case 1:
                torneo.crearUnNuevoTorneo();
                break;
                
            case 2:
                torneo.crearEquipos();
                break;
                
            case 3:
                torneo.eliminarJugador();
                break;
                
            case 4:
                torneo.iniciarFaseDeGrupos();
                break;
                
            case 5:
                torneo.crearPartidos();
                torneo.registrarGoles();
                break;

            case 6:
                
                break;
            
            case 7:
                
                break;
                
            case 8:
                
                break;
                           
            }
        } while (respuesta<9);    
    }
}
