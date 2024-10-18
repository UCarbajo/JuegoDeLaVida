package pruebaJuego;

import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el numero de filas");
		int filas = entrada.nextInt();
		System.out.println("Introduce el numero de columnas");
		int columnas = entrada.nextInt();
		System.out.println("Introduce el numero de repeticiones");
		int repeticiones = entrada.nextInt();
		
		int[][] tabla = new int[filas][columnas];
		int[][] aux = new int[tabla.length][tabla[0].length];

		tablaAleatoria(tabla);
		
		System.out.println("Salida inicial");
		mostrarCelulasVivas(tabla);
		mostrarTabla(tabla);

		for (int repeticion = 0; repeticion <= repeticiones; repeticion++) {

			for (int fila = 0; fila < tabla.length; fila++) {
				for (int columna = 0; columna < tabla[fila].length; columna++) {

					int suma = 0;

					for (int filaI = -1; filaI <= 1; filaI++) {
						for (int columnaJ = -1; columnaJ <= 1; columnaJ++) {

							if ((fila + filaI >= 0 && fila + filaI < tabla.length)
									&& (columna + columnaJ >= 0 && columna + columnaJ < tabla[fila].length))
								suma += tabla[fila + filaI][columna + columnaJ];
						}
					}

					suma -= tabla[fila][columna];

					switch (tabla[fila][columna]) {

					case 1:
						if (suma < 2 || suma > 3) {
							aux[fila][columna] = 0;
						} else if (suma == 2 || suma == 3) {
							aux[fila][columna] = 1;
						}
						break;
					case 0:
						if (suma == 3) {
							aux[fila][columna] = 1;
						}else {
							aux[fila][columna] = 0;
						}
						break;
					}
				}
			}

			System.out.println();

			System.out.println("Generacion " + (repeticion + 1));
			mostrarCelulasVivas(aux);
			mostrarTabla(aux);
		
		for (int k = 0; k < tabla.length; k++) {
			for (int l = 0; l < tabla[k].length; l++) {
				tabla[k][l] = aux[k][l];
				}
			}
		}
	}

	// METODO mostrarTabla
	static void mostrarTabla(int[][] miTabla) {
		for (int i = 0; i < miTabla.length; i++) {
			for (int j = 0; j < miTabla[i].length; j++) {
				if (miTabla[i][j] == 0)
					System.out.print("- ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
	}

	// METODO mostrarCelulasVivas
	static void mostrarCelulasVivas(int[][] miTabla) {
		int totalVivas = 0;
		for (int i = 0; i < miTabla.length; i++) {
			for (int j = 0; j < miTabla[i].length; j++) {
				if (miTabla[i][j] == 1)
					totalVivas++;
			}
		}
		System.out.println("El total de celulas vivas es de " + totalVivas);
	}
	// METODO tablaAleatoria
	static void tablaAleatoria(int[][] miTabla) {
		for (int i = 0; i < miTabla.length; i++) {
			for (int j = 0; j < miTabla[i].length; j++) {
				miTabla[i][j] = (int) (Math.random()*2);
				}
			}
	}
}