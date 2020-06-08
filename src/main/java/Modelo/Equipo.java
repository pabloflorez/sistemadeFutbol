package Modelo;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * esta clase se encarga de hacer varias funcionalidades
 * sobre los equipos
 * 03/05/2020
 * @author Juan y Jenny
 */

public class Equipo implements Comparable<Equipo>{

	Scanner tc = new Scanner(System.in);

	// atributos de la clase

	String nombreEquipo;
	String nombreTecnico;
	int cantidadJugadores = 0;
	int MAX_JUGADORES = 17;
	Jugador jugadores[];
	int estadisticas[][] = new int[MAX_JUGADORES][4];
	int numPartidosGanadosPorEquipo;
	int puntos;
	int numDeGolesAnotados;
	int numDeGolesRecibidos;

	// este metodo ingresa la información de un equipo
	public void crearEquipo() {

		int numAsignado;
		String nombreJugador;

		System.out.print("\nIngrese el nombre del equipo: ");
		nombreEquipo = tc.nextLine();

		System.out.print("Ingrese el nombre del tecnico del equipo: ");
		nombreTecnico = tc.nextLine();

		System.out.print("¿Cuántos jugadores desea registrar?, recuerde que son máximo 17: ");
		cantidadJugadores = tc.nextInt();
		if(cantidadJugadores > 0 && cantidadJugadores <= MAX_JUGADORES) {
			jugadores = new Jugador[cantidadJugadores];
		}else {
			cantidadJugadores = 1;
			jugadores = new Jugador[cantidadJugadores];
		}

		for (int i = 0; i < cantidadJugadores; i++) {

			System.out.print("Ingrese el nombre del jugador: ");
			nombreJugador = tc.next();

			System.out.print("Ingrese el número del jugador: ");
			numAsignado = tc.nextInt();

			Jugador unJugador = new Jugador(nombreJugador, numAsignado);

			jugadores[i] = unJugador;

			System.out.println(
					"El jugador " + nombreJugador + " con número " + numAsignado + " ha sido creado con éxito.");

		}

		System.out.println("El equipo " + nombreEquipo + " con técnico " + nombreTecnico + " ha sido creado con éxito.");

	}

	// este método genera las estadisticas por equipo

	public void estadisticasJugador() {

		int resp;
		int acum = 0;
		int acum2 = 0;
		int golesMarcados;
		int tarjetasAmarillas;
		int tarjetasRojas;
		int numAsistencias;

		System.out.println("Ingrese las estadisticas de los jugadores");

		for (int i = 0; i < estadisticas.length; i++)

			for (int j = 0; j < estadisticas.length; j++) {

				System.out.println("El jugador " + jugadores[i].nombreJugador + " jugó?\n1.Si\n2.No");
				resp = tc.nextInt();

				if (resp == 1) {

					System.out.println("Ingrese la cantidad de goles marcados:");
					golesMarcados = tc.nextInt();

					System.out.println("Ingrese la cantidad de asistencias:");
					numAsistencias = tc.nextInt();

					System.out.println("Ingrese la cantidad de tarjetas amarillas recibidas:");
					tarjetasAmarillas = tc.nextInt();

					System.out.println("Ingrese la cantidad de tarjetas rojas recibidas:");
					tarjetasRojas = tc.nextInt();

					Jugador resultados = new Jugador();
					resultados.Estadisticas(golesMarcados, numAsistencias, tarjetasAmarillas, tarjetasRojas);

				} else {
					System.out.println("");
				}

			}

		acum2 += acum;
	}

	@Override
	public int compareTo(Equipo o) {
		if (this.puntos < o.puntos) {
            return 1;
        }
        if (this.puntos > o.puntos) {
            return -1;
        }
        return 0;
	}

}
