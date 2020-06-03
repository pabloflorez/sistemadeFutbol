package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * esta clase se encarga de crear un nuevo torneo, creando equipos,
 * agregando jugadores y eliminandolos
 * 04/05/2020
 * @author Juan y Jenny
 */

import java.util.Scanner;
import java.util.Random;

public class Torneo {
    
    Scanner tc = new Scanner(System.in);
    
    //atributos de la clase
    
    String nombreTorneo;
    Equipo equipos[];
    Grupo Grupos[];
    int numGrupos;
    int cantidadDeEquipos;
    int i=0;
    Fase fases[];
    
    //este método crea un nuevo torneo, con sus equipos y jugadores
    
    public void crearUnNuevoTorneo() {
		
	System.out.println("Ingrese el nombre del torneo a crear: ");
	nombreTorneo = tc.nextLine();
		
        System.out.println("El torneo "+nombreTorneo+" ha sido creado con éxito");   
    
    }
    
    //este método crea los equipos
    
    public void crearEquipos(){
        
        System.out.println("Ingrese la cantidad de equipos a participar en el torneo: ");
        cantidadDeEquipos = tc.nextInt();
        
        equipos  = new Equipo[cantidadDeEquipos];
                
        if (cantidadDeEquipos>=4 && cantidadDeEquipos % 4 == 0){
            while (i<cantidadDeEquipos){
		Equipo unEquipo = new Equipo();
		unEquipo.crearEquipo();
                equipos[i]= unEquipo;
                i=i+1;
            } 
	}
	else{
            System.out.println("Error, el número de equipos debe ser multiplo de 4.");
            }
        
    }
    
    //este método elimina un jugador de un equipo
    
    public void eliminarJugador(){
        int equipoSeleccionado;
        int jugadorSeleccionado;
        boolean encontrado = false;
        Equipo buscar = new Equipo();
        
        for(int i=0;i<equipos.length;i++){
    		System.out.println((i+1+".")+equipos[i].nombreEquipo);
    	}
        
        System.out.println("Seleccione el equipo: ");
        equipoSeleccionado = tc.nextInt();
        
        System.out.println("Usted ha seleccionado el equipo "+equipoSeleccionado);
                
        for (int i=0;i<equipos[equipoSeleccionado-1].jugadores.length;i++){
            if(equipos[equipoSeleccionado-1].jugadores[i].numAsignado != -1 ){
            System.out.println(equipos[equipoSeleccionado-1].jugadores[i].numAsignado+"."+equipos[equipoSeleccionado-1].jugadores[i].nombreJugador);
            }
        }
        
        
        System.out.println("Seleccione el jugador: ");
        jugadorSeleccionado = tc.nextInt();
        
        for(int i=0;i<equipos[jugadorSeleccionado-1].jugadores.length;i++){
            if(equipos[equipoSeleccionado-1].jugadores[i].numAsignado == jugadorSeleccionado){
                equipos[equipoSeleccionado-1].jugadores[jugadorSeleccionado-1].numAsignado = -1;
                encontrado = true;
                System.out.println("Jugador eliminado exitosamente.");
                break;
            }
        }
        if (encontrado == false){
            System.out.println("El jugador seleccionado no existe.");
        }
        
    } 
    
    //este método asigna aleatoriamente los equipos a un grupo
    
    public void iniciarFaseDeGrupos(){
      
        String nombreGrupo;
        int aux=0;
        numGrupos = equipos.length/4;
        Grupos = new Grupo[numGrupos]; 
        boolean generados[] = new boolean [cantidadDeEquipos];
        Random obj = new Random();
        for (int i=0;i<numGrupos;i++){
            
            System.out.println("Ingrese el nombre del grupo, recuerde que solo debe ser una letra del alfabeto.");
            nombreGrupo = tc.next();
            Grupos[i] = new Grupo(nombreGrupo);
           
            int j=0;
            
            while (j<4){
                
                aux=obj.nextInt(cantidadDeEquipos);

                if(generados[aux]== false){
                    generados[aux]=true;
                    Grupos[i].agregarEquipo(equipos[aux],j);
                    j++;
                }

            }
            
        }
        
        
        for(int i=0;i<Grupos.length;i++){
            
            System.out.println("Nombre del grupo: "+Grupos[i].nombreGrupo); 
            
            for(int j=0;j<Grupos[i].equipos.length;j++){
                System.out.println(Grupos[i].equipos[j].nombreEquipo);   
            }
        
        }    
        
    }
    
    
    //asigna resultados por cada partido
    
    public void crearPartidos(){
                
        for(Grupo g : Grupos){
            g.crearPartidos();
            for (int j = 0; j < g.partidos.size(); j++) {
                System.out.println("Grupo "+ g.nombreGrupo+ "\nEquipos a enfrentarse "+ g.partidos.get(j).getEquipo1().nombreEquipo + " "+ g.partidos.get(j).getEquipo2().nombreEquipo+ "\n");
            }
        }

    }
        
    //este método asigna los goles de cada partido


    public void registrarGoles() {
        String equipoSeleccionado;
                    
        for(int i=0;i<Grupos.length;i++){
            System.out.println("Ingrese las estadisticas del grupo "+Grupos[i].nombreGrupo);
            for (int j = 0; j < equipos.length; j++) {
               System.out.println(Grupos[i].equipos[j].nombreEquipo); 
            }
            
            System.out.println("Seleccione el equipo al que desea ingresar las estadisticas");
            equipoSeleccionado = tc.next();
            
            if(equipoSeleccionado.equalsIgnoreCase(Grupos[i].equipos[i].nombreEquipo) ){
                equipos[i].estadisticasJugador();
            }
        } 
    }
    
}

