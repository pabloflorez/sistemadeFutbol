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
import java.util.ArrayList;
import java.util.Arrays;
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
		} else if ((cantidadDeEquipos != 4 && cantidadDeEquipos % 8 != 0) || cantidadDeEquipos < 0) {
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
				int golesMarcados, asistencias, tarjetasAmarillas, tarjetasRojas, resp;
				for (int equ1 = 0; equ1 < jugadoresEq1.length; equ1++) {
					System.out.println("El jugador " + jugadoresEq1[equ1].nombreJugador + " jugó?\n1.Si\n2.No");
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

						jugadoresEq1[equ1].registroResultados(golesMarcados, asistencias, tarjetasAmarillas,
								tarjetasRojas);

					} else {
						jugadoresEq1[equ1].registroResultados(0, 0, 0, 0);
					}
				}

				System.out.println("Ingrese por favor los resultado del equipo " + nombreEqu2 + " por cada jugador");
				int golesMarcadosEq1, asistenciasEq1, tarjetasAmarillasEq1, tarjetasRojasEq1, respEq1;

				Jugador jugadoresEq2[] = g.partidos.get(j).getEquipo2().jugadores;
				for (int equpo2 = 0; equpo2 < jugadoresEq2.length; equpo2++) {
					System.out.println("El jugador " + jugadoresEq2[equpo2].nombreJugador + " jugó?\n1.Si\n2.No");
					respEq1 = tc.nextInt();

					if (respEq1 == 1) {

						System.out.println("Ingrese la cantidad de goles marcados:");
						golesMarcadosEq1 = tc.nextInt();
						golesTotalesEquipo2 += golesMarcadosEq1;

						System.out.println("Ingrese la cantidad de asistencias:");
						asistenciasEq1 = tc.nextInt();

						System.out.println("Ingrese la cantidad de tarjetas amarillas recibidas:");
						tarjetasAmarillasEq1 = tc.nextInt();

						System.out.println("Ingrese la cantidad de tarjetas rojas recibidas:");
						tarjetasRojasEq1 = tc.nextInt();

						jugadoresEq2[equpo2].registroResultados(golesMarcadosEq1, asistenciasEq1, tarjetasAmarillasEq1,
								tarjetasRojasEq1);

					} else {
						jugadoresEq2[equpo2].registroResultados(0, 0, 0, 0);
					}
				}

				if (golesTotalesEquipo1 == golesTotalesEquipo2) {
					g.partidos.get(j).getEquipo1().puntos += 1;
					g.partidos.get(j).getEquipo2().puntos += 1;
				} else if (golesTotalesEquipo1 > golesTotalesEquipo2) {
					g.partidos.get(j).getEquipo1().puntos += 3;
					g.partidos.get(j).getEquipo2().puntos += 0;
				} else if (golesTotalesEquipo1 < golesTotalesEquipo2) {
					g.partidos.get(j).getEquipo1().puntos += 0;
					g.partidos.get(j).getEquipo2().puntos += 3;
				}

				// goles anotados y recibidos equipo 1
				g.partidos.get(j).getEquipo1().numDeGolesAnotados += golesTotalesEquipo1;
				g.partidos.get(j).getEquipo1().numDeGolesRecibidos += golesTotalesEquipo2;
				// goles anotados y recibidos equipo 2
				g.partidos.get(j).getEquipo2().numDeGolesAnotados += golesTotalesEquipo2;
				g.partidos.get(j).getEquipo2().numDeGolesRecibidos += golesTotalesEquipo1;

			}
		}
	}

	public void estadisticas() {

		int cantidadTotalJugadores = 0;
		for (Equipo equipo : equipos) {
			cantidadTotalJugadores += equipo.cantidadJugadores;
		}

		System.out.println("cantidad total jugadores " + cantidadTotalJugadores);

		Jugador[] jugadores = new Jugador[cantidadTotalJugadores];
		int cuentaJugadores = 0;
		int equipoMenosGolesRecibidos, equipoMasGolesAnotados;
		String equipoMenosRecibidos, nEquipoMasGolesAnotados;
		equipoMenosGolesRecibidos = equipos[0].numDeGolesRecibidos;
		equipoMenosRecibidos = equipos[0].nombreEquipo;

		equipoMasGolesAnotados = equipos[0].numDeGolesAnotados;
		nEquipoMasGolesAnotados = equipos[0].nombreEquipo;
		for (int j = 0; j < equipos.length; j++) {
			if (equipoMasGolesAnotados < equipos[j].numDeGolesAnotados) {
				equipoMasGolesAnotados = equipos[j].numDeGolesAnotados;
				nEquipoMasGolesAnotados = equipos[j].nombreEquipo;
			}
			if (equipoMenosGolesRecibidos > equipos[j].numDeGolesRecibidos) {
				equipoMenosGolesRecibidos = equipos[j].numDeGolesRecibidos;
				equipoMenosRecibidos = equipos[j].nombreEquipo;
			}

			// Creando un vector con todos los jugadores
			for (Jugador jug : equipos[j].jugadores) {
				jugadores[cuentaJugadores] = jug;
				cuentaJugadores++;
			}
		}

		for (int j = 0; j < jugadores.length; j++) {
			System.out.println("Jugadores " + jugadores[j].toString());
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
			if (mayorGoles < jugadores[j].golesMarcados) {
				mayorGoles = jugadores[j].golesMarcados;
				jugadorMasGoles = jugadores[j].nombreJugador;
			}

			if (menosAmarillas > jugadores[j].tarjetasAmarillas) {
				menosAmarillas = jugadores[j].tarjetasAmarillas;
				jugadorMenosAmarillas = jugadores[j].nombreJugador;
			}

			if (masAsistencias < jugadores[j].numAsistencias) {
				masAsistencias = jugadores[j].numAsistencias;
				jugadorMasAsistencias = jugadores[j].nombreJugador;
			}
		}

		System.out.println(" Equipo con más goles anotados " + nEquipoMasGolesAnotados + "\n");
		System.out.println(" Equipo con menos goles recibidos " + equipoMenosRecibidos + "\n");

		System.out.println(" Jugador con más goles " + jugadorMasGoles + "\n");
		System.out.println(" Jugador con menos amarillas " + jugadorMenosAmarillas + "\n");
		System.out.println(" Jugador con más asistencias " + jugadorMasAsistencias + "\n");

	}

	public void fases() {
		Arrays.sort(equipos);
		for (int i = 0; i < equipos.length; i++) {
			System.out.println(equipos[i].nombreEquipo);
			System.out.println(equipos[i].puntos);
		}

		ArrayList<Equipo> nuevosEquiposTorneo = new ArrayList<>();

		ArrayList<Equipo> equiposPrimerPuesto = new ArrayList<>();
		ArrayList<Equipo> equiposSegundoPuesto = new ArrayList<>();
		if (grupos.length > 0) {
			for (Grupo g : grupos) {
				Arrays.sort(g.equipos);
				for (int i = 0; i < (g.equipos.length) / 2; i += 2) {
					equiposPrimerPuesto.add(g.equipos[i]);
					nuevosEquiposTorneo.add(g.equipos[i]);
					if (g.equipos.length > 2) {
						equiposSegundoPuesto.add(g.equipos[i + 1]);
						nuevosEquiposTorneo.add(g.equipos[i + 1]);
					}
				}
			}

			int cantidadGrupos = (equiposPrimerPuesto.size()) / 2;
			Grupo[] gruposFase = new Grupo[equiposPrimerPuesto.size()];
			int indiceGrupos = 0;
			if (cantidadGrupos > 1) {
				for (int i = 0; i < cantidadGrupos; i += 2) {
					Grupo grupoFase = new Grupo("grupo" + indiceGrupos);
					Partido p = new Partido(equiposPrimerPuesto.get(i), equiposPrimerPuesto.get(i + 1));
					grupoFase.partidos.add(p);
					gruposFase[indiceGrupos] = grupoFase;
					indiceGrupos++;
					if (equiposSegundoPuesto.size() > 0) {
						Grupo grupoFaseE = new Grupo("grupo" + indiceGrupos);
						Partido part = new Partido(equiposSegundoPuesto.get(i), equiposSegundoPuesto.get(i + 1));
						grupoFaseE.partidos.add(part);
						gruposFase[indiceGrupos] = grupoFaseE;
						indiceGrupos++;
					}
				}
				grupos = gruposFase;

			} else {
				System.out.println("El ganador es " + equiposPrimerPuesto.get(0).nombreEquipo);
			}

			equipos = new Equipo[nuevosEquiposTorneo.size()];
		}else {
			System.out.println("Inicie fase inicial");
		}

	}

}
