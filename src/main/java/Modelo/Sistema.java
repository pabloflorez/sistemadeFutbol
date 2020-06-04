package Modelo;

import java.awt.event.KeyEvent;

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
	public static void main(String arg[]) {

		Scanner tc = new Scanner(System.in);
		int respuesta;
		boolean crearEquipos = false;
		Torneo torneo = new Torneo();

		System.out.println("*************Bienvenido al Sistema de Fútbol*************");

		System.out.println("Ingrese el nombre del torneo \n");
		String nombreTorneo = tc.next();
		torneo.crearUnNuevoTorneo(nombreTorneo);
		if(nombreTorneo!=null) {
			while(!crearEquipos) {
				crearEquipos = torneo.crearEquipos();
			}
		}

		do {
			System.out.println("\n De acuerdo a su necesidad, seleccione la opción desea realizar:");
			System.out.println("1.Eliminar un jugador de un equipo");
			System.out.println("2.Iniciar fase de grupos");
			System.out.println("3.Registrar los resultados de los partidos");
			System.out.println("4.Generar las llaves de la siguiente fase");
			System.out.println("5.Registrar resultados de una llave");
			System.out.println("6.Ver información de un jugador");
			System.out.println("7.Generar informe por torneo");
			System.out.println("8.Salir");
			System.out.println("**********************************************************");
			respuesta = tc.nextInt();
			
			
			switch (respuesta) {
			case 1:
				torneo.eliminarJugador();
				break;

			case 2:
				torneo.iniciarFaseDeGrupos();
				torneo.crearPartidos();
				break;

			case 3:
				torneo.registrarGoles();
				break;

			case 4:
				
				break;

			case 5:

				break;

			case 6:

				break;
			case 7:
				torneo.estadisticas();
				break;
			case 8:
				System.exit(0);
				break;

			}
		} while (respuesta < 8);
	}
}
