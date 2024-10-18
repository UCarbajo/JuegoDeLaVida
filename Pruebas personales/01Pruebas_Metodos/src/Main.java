import java.util.Scanner;

public class Main {
    static void mostrarTabla(int[][] miTabla) {
    	for (int i = 0; i < miTabla.length; i++) {
    		for (int j = 0; j < miTabla[i].length; j++) {
    			System.out.print(miTabla[i][j]);
        	}
    		System.out.println();
    	}
    }
	
	public static void main(String[] args) {
    	Scanner entrada = new Scanner(System.in);
    	
    	System.out.println("Introduce el numero de filas deseada");
    	int numeroFilas = entrada.nextInt();
    	System.out.println("Introduce el numero de columnas deseada");
    	int numeroColumnas = entrada.nextInt();
    	
    	int[][] tabla = new int[numeroFilas][numeroColumnas];
    	
    	mostrarTabla(tabla);
    }
}
