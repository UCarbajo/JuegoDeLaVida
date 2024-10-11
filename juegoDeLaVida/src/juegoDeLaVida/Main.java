package juegoDeLaVida;

public class Main {

	public static void main(String[] args) {
		int[][] tabla = { { 0, 0, 0, 0, 0, 0 }, 
					      { 0, 1, 1, 0, 0, 0,}, 
					      { 0, 0, 1, 1, 0, 0 }, 
					      { 0, 0, 1, 0, 0, 0 },
					      { 0, 0, 0, 0, 0, 0 }, 
					      { 0, 0, 0, 0, 0, 0 } };

		int[][] aux = new int[tabla.length][tabla.length];
		
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				System.out.print(tabla[i][j] + " ");
			}
			System.out.println();
		}
		
		for (int fila = 0; fila < tabla.length; fila++) {
			for (int columna = 0; columna < tabla.length; columna++) {
				int suma = 0;
				for (int filaI = -1; filaI <= 1; filaI++) {
					for (int columnaJ = -1; columnaJ <= 1; columnaJ++) {
						if ((fila+filaI>=0 && fila+filaI<6) && (columna+columnaJ>=0 && columna+columnaJ<6))
	                        suma += tabla[fila + filaI][columna + columnaJ];

					}
					suma -= tabla[fila][columna];
				}
				if ((tabla[fila][columna] == 1 || tabla[fila][columna] == 0 ) && (suma < 2 || suma > 3)) {
					aux[fila][columna] = 0;
				}else if ((tabla[fila][columna] == 1) && (suma == 2 || suma == 3)) {
					aux[fila][columna] = 1;
				}else if (suma == 3)
					aux[fila][columna] = 1; {
					
				} 
				}
			}
		System.out.println();
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux.length; j++) {
				System.out.print(aux[i][j] + " ");
			}
			System.out.println();
		}
	}
}
