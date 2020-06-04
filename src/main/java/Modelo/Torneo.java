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

	// atributos de la clase

	String nombreTorneo;
	Equipo equipos[];
	Grupo grupos[];
	int numGrupos;
	int cantidadDeEquipos;
	int i = 0;
	Fase fases[];

	// este método crea un nuevo torneo, con sus equipos y jugadores

	public void crearUnNuevoTorneo(String nombreTorneo) {
		this.nombreTorneo = nombreTorneo;

		System.out.println("El torneo " + nombreTorneo + " ha sido creado con éxito");

	}

	// este método crea los equipos

	public boolean crearEquipos() {

		System.out.println("Ingrese la cantidad de equipos a participar en el torneo, si desea salir ingrese 0: \n");
		cantidadDeEquipos = tc.nextInt();
		if (cantidadDeEquipos == 0) {
			System.exit(0);
		} else if (cantidadDeEquipos % 4 != 0 || cantidadDeEquipos < 0) {
			System.out.println("Error, el número de equipos debe ser multiplo de 4 y mayor a cero");
			return false;
		}

		equipos = new Equipo[cantidadDeEquipos];

		while (i < cantidadDeEquipos) {
			Equipo unEquipo = new Equipo();
			unEquipo.crearEquipo();
			equipos[i] = unEquipo;
			i = i + 1;
		}
		return true;
	}

	// este método elimina un jugador de un equipo

	public void eliminarJugador() {
		int equipoSeleccionado;
		int jugadorSeleccionado;
		boolean encontrado = false;
		Equipo buscar = new Equipo();

		for (int i = 0; i < equipos.length; i++) {
			System.out.println((i + 1 + ".") + equipos[i].nombreEquipo);
		}

		System.out.println("Seleccione el equipo: ");
		equipoSeleccionado = tc.nextInt();

		System.out.println("Usted ha seleccionado el equipo " + equipoSeleccionado);

		for (int i = 0; i < equipos[equipoSeleccionado - 1].jugadores.length; i++) {
			if (equipos[equipoSeleccionado - 1].jugadores[i].numAsignado != -1) {
				System.out.println(equipos[equipoSeleccionado - 1].jugadores[i].numAsignado + "."
						+ equipos[equipoSeleccionado - 1].jugadores[i].nombreJugador);
			}
		}

		System.out.println("Seleccione el jugador: ");
		jugadorSeleccionado = tc.nextInt();

		for (int i = 0; i < equipos[jugadorSeleccionado - 1].jugadores.length; i++) {
			if (equipos[equipoSeleccionado - 1].jugadores[i].numAsignado == jugadorSeleccionado) {
				equipos[equipoSeleccionado - 1].jugadores[jugadorSeleccionado - 1].numAsignado = -1;
				encontrado = true;
				System.out.println("Jugador eliminado exitosamente.");
				break;
			}
		}
		if (encontrado == false) {
			System.out.println("El jugador seleccionado no existe.");
		}

	}

	// este método asigna aleatoriamente los equipos a un grupo

	public void iniciarFaseDeGrupos() {

		String nombreGrupo;
		int aux = 0;
		numGrupos = equipos.length / 4;
		grupos = new Grupo[numGrupos];
		boolean generados[] = new boolean[cantidadDeEquipos];
		Random obj = new Random();
		for (int i = 0; i < numGrupos; i++) {

			System.out.println("Ingrese el nombre del grupo, recuerde que solo debe ser una letra del alfabeto.");
			nombreGrupo = tc.next();
			grupos[i] = new Grupo(nombreGrupo);

			int j = 0;

			while (j < 4) {

				aux = obj.nextInt(cantidadDeEquipos);
				// Se usa para verificar si el equipo no está asignado ya a un grupo
				if (generados[aux] == false) {
					generados[aux] = true;
					grupos[i].agregarEquipo(equipos[aux], j);
					j++;
				}

			}

		}

		for (int i = 0; i < grupos.length; i++) {

			System.out.println();
			String equipos = "";
			for (int j = 0; j < grupos[i].equipos.length; j++) {
				equipos += grupos[i].equipos[j].nombreEquipo + " - ";

			}
			System.out.println("Nombre del grupo: " + grupos[i].nombreGrupo + " Y sus equipos " + equipos);
		}

	}

	// asigna resultados por cada partido

	public void crearPartidos() {

		for (Grupo g : grupos) {
			// se crea partidos de todos con todos en el grupo
			g.crearPartidos();
			for (int j = 0; j < g.partidos.size(); j++) {
				System.out.println("Grupo " + g.nombreGrupo + "\nEquipos a enfrentarse "
						+ g.partidos.get(j).getEquipo1().nombreEquipo + " "
						+ g.partidos.get(j).getEquipo2().nombreEquipo + "\n");
			}
		}

	}

	// este método asigna los goles de cada partido

	public void registrarGoles() {

		int golesMarcados, asistencias, tarjetasAmarillas, tarjetasRojas, resp;

		for (Grupo g : grupos) {
			for (int j = 0; j < g.partidos.size(); j++) {
				String nombreEqu1 = g.partidos.get(j).getEquipo1().nombreEquipo;
				String nombreEqu2 = g.partidos.get(j).getEquipo2().nombreEquipo;
				System.out
						.println("Grupo " + g.nombreGrupo + "\nPartido entre " + nombreEqu1 + " " + nombreEqu2 + "\n");
				Jugador jugadoresEq1[] = g.partidos.get(j).getEquipo1().jugadores;
				System.out.println("Ingrese por favor los resultado del equipo " + nombreEqu1 + " por cada jugador");

				int golesTotalesEquipo1 = 0;
				int golesTotalesEquipo2 = 0;
				for (int i = 0; i < jugadoresEq1.length; i++) {
					System.out.println("El jugador " + jugadoresEq1[i].nombreJugador + " jugó?\n1.Si\n2.No");
					resp = tc.nextInt();

					if (resp == 1) {

						System.out.println("Ingrese la cantidad de goles marcados:");
						golesMarcados = tc.nextInt();
						golesTotalesEquipo1 += golesMarcados;

						System.out.println("Ingrese la cantidad de asistencias:");
						asistencias = tc.nextInt();

						System.out.println("Ingrese la cantidad de tarjetas amarillas recibidas:");
						tarjetasAmarillas = tc.nextInt();

						System.out.println("Ingrese la cantidad de tarjetas rojas recibidas:");
						tarjetasRojas = tc.nextInt();

						jugadoresEq1[i].registroResultados(golesMarcados, asistencias, tarjetasAmarillas,
								tarjetasRojas);

					} else {
						jugadoresEq1[i].registroResultados(0, 0, 0, 0);
					}
				}

				System.out.println("Ingrese por favor los resultado del equipo " + nombreEqu2 + " por cada jugador");

				Jugador jugadoresEq2[] = g.partidos.get(j).getEquipo2().jugadores;
				for (int i = 0; i < jugadoresEq2.length; i++) {
					System.out.println("El jugador " + jugadoresEq2[i].nombreJugador + " jugó?\n1.Si\n2.No");
					resp = tc.nextInt();

					if (resp == 1) {

						System.out.println("Ingrese la cantidad de goles marcados:");
						golesMarcados = tc.nextInt();
						golesTotalesEquipo1 += golesMarcados;

						System.out.println("Ingrese la cantidad de asistencias:");
						asistencias = tc.nextInt();

						System.out.println("Ingrese la cantidad de tarjetas amarillas recibidas:");
						tarjetasAmarillas = tc.nextInt();

						System.out.println("Ingrese la cantidad de tarjetas rojas recibidas:");
						tarjetasRojas = tc.nextInt();

						jugadoresEq1[i].registroResultados(golesMarcados, asistencias, tarjetasAmarillas,
								tarjetasRojas);

					} else {
						jugadoresEq1[i].registroResultados(0, 0, 0, 0);
					}
				}
				// goles anotados y recibidos equipo 1
				g.partidos.get(j).getEquipo1().numDeGolesAnotados = golesTotalesEquipo1;
				g.partidos.get(j).getEquipo1().numDeGolesRecibidos = golesTotalesEquipo2;
				// goles anotados y recibidos equipo 2
				g.partidos.get(j).getEquipo2().numDeGolesAnotados = golesTotalesEquipo2;
				g.partidos.get(j).getEquipo2().numDeGolesRecibidos = golesTotalesEquipo1;

			}
		}
	}

	public void estadisticas() {

		int cantidadTotalJugadores = 0;
		for (Equipo equipo : equipos) {
			cantidadTotalJugadores += equipo.cantidadJugadores;
		}

		System.out.println("cantidad total jugadores "+ cantidadTotalJugadores);
		
		Jugador[] jugadores = new Jugador[cantidadTotalJugadores];
		int i = 0;
		int equipoMenosGolesRecibidos, equipoMasGolesAnotados;
		String equipoMenosRecibidos, nEquipoMasGolesAnotados;
		equipoMenosGolesRecibidos = equipos[0].numDeGolesRecibidos;
		equipoMenosRecibidos = equipos[0].nombreEquipo;

		equipoMasGolesAnotados = equipos[0].numDeGolesAnotados;
		nEquipoMasGolesAnotados = equipos[0].nombreEquipo;
		for (int j = 0; j < equipos.length; j++) {
			if (equipoMasGolesAnotados < equipos[i].numDeGolesAnotados) {
				equipoMasGolesAnotados = equipos[i].numDeGolesAnotados;
				nEquipoMasGolesAnotados = equipos[i].nombreEquipo;
			}
			if (equipoMenosGolesRecibidos > equipos[i].numDeGolesRecibidos) {
				equipoMenosGolesRecibidos = equipos[i].numDeGolesRecibidos;
				equipoMenosRecibidos = equipos[i].nombreEquipo;
			}

			// Creando un vector con todos los jugadores
			for (Jugador jug : equipos[j].jugadores) {
				jugadores[i] = jug;
				i++;
			}
		}
		
		for (int j = 0; j < jugadores.length; j++) {
			System.out.println("Jugadores "+ jugadores[j]);
		}

		int mayorGoles, menosAmarillas, masAsistencias;
		String jugadorMasGoles, jugadorMenosAmarillas, jugadorMasAsistencias;
		mayorGoles = jugadores[0].golesMarcados;
		jugadorMasGoles = jugadores[0].nombreJugador;
		menosAmarillas = jugadores[0].tarjetasAmarillas;
		jugadorMenosAmarillas = jugadores[0].nombreJugador;
		masAsistencias = jugadores[0].numAsistencias;
		jugadorMasAsistencias = jugadores[0].nombreJugador;
		for (int j = 1; j < jugadores.length; j++) {
			System.out.println("I "+ j);
			System.out.println("I "+ jugadores[j]);
			if (mayorGoles < jugadores[i].golesMarcados) {
				mayorGoles = jugadores[i].golesMarcados;
				jugadorMasGoles = jugadores[i].nombreJugador;
			}

			if (menosAmarillas > jugadores[i].tarjetasAmarillas) {
				mayorGoles = jugadores[i].golesMarcados;
				jugadorMenosAmarillas = jugadores[i].nombreJugador;
			}

			if (masAsistencias < jugadores[i].tarjetasAmarillas) {
				mayorGoles = jugadores[i].golesMarcados;
				jugadorMasAsistencias = jugadores[i].nombreJugador;
			}
		}

		System.out.println(" Equipo con más goles anotados " + nEquipoMasGolesAnotados + "\n");
		System.out.println(" Equipo con menos goles recibidos " + equipoMenosRecibidos + "\n");

		System.out.println(" Jugador con más goles " + jugadorMasGoles + "\n");
		System.out.println(" Jugador con menos amarillas " + jugadorMenosAmarillas + "\n");
		System.out.println(" Jugador con más asistencias " + jugadorMasAsistencias + "\n");

	}

}
