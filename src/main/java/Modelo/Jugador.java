package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

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

public class Jugador {

	Scanner tc = new Scanner(System.in);

	// atributos de la clase

	String nombreJugador;
        int numAsignado;
        int Estadisticas[][];
	int golesMarcados;
        int numAsistencias;
	int tarjetasAmarillas;
	int tarjetasRojas;
	ArrayList<Integer> resultados = new ArrayList<>();

	public Jugador() {
	}
        
	/**
	 * este constructor crea un jugador con la información que se reciba de la clase
	 * equipo
	 * 
	 * @param n  nombre del jugador
	 * @param na numero asignado al jugador
	 */
        
	public Jugador(String n, int na) {
		this.nombreJugador = n;
		this.numAsignado = na;
	}
        
        /**
         * este método recibe las estadisticas de cada jugador por partido
         * 
         * @param gm goles marcados
         * @param na número de asistencias
         * @param ta tarjetas amarillas
         * @param tr tarjetas rojas
         */
        
	public void Estadisticas(int gm, int na, int ta, int tr) {

		this.golesMarcados = gm;
		this.numAsistencias = na;
		this.tarjetasAmarillas = ta;
		this.tarjetasRojas = tr;

		Estadisticas = new int[17][4];

		for (int i = 0; i < Estadisticas.length; i++) {

			Estadisticas[i][0] = gm;
			Estadisticas[i][1] = na;
			Estadisticas[i][2] = ta;
			Estadisticas[i][3] = tr;

		}

	}
        
        /**
         * este método recibe las estadisticas de cada jugador por partido cuando un jugador no juega
         * @param golesMarcados
         * @param asistencias
         * @param tarjetasAmarillas
         * @param tarjetasRojas 
         */
        
	public void registroResultados(int golesMarcados, int asistencias, int tarjetasAmarillas, int tarjetasRojas) {

		this.golesMarcados += golesMarcados;
		this.numAsistencias += asistencias;
		this.tarjetasAmarillas += tarjetasAmarillas;
		this.tarjetasRojas += tarjetasRojas;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nombreJugador + " Goles anotados: "+ this.golesMarcados
                        + " Asistencias: "+ this.numAsistencias
                        + " Tarjetas Amarillas: "+ this.tarjetasAmarillas
                        + " Tarjetas Rojas "+ this.tarjetasRojas;
	}
}
