package juegoDeLaVida;

public class Main {

	public static void main(String[] args) {
        // Creamos una matriz de 0 y 1 para representar las celucas vivas(1) y las muertas (0).
		int[][] tabla = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		
		// Creamos una matriz con la longitud de la primera matriz en la que guardaremos el resultado de cada celda.
        int[][] aux = new int[tabla.length][tabla.length];
        
        // Mostramos la tabla inicial, para poder el estado inicial de las celulas.
        System.out.println("Salida inicial");
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                //Cambiamos los 0 por . y los 1 con * para poder verlos mejor en la consola.
            	if (tabla[i][j] == 0)
                    System.out.print(". ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        
        // En este primer for(), indicamos cuantas veces queremos repetir el codigo que esta debajo. En este caso es 10.
        for (int repeticion = 0; repeticion < 10; repeticion++) {
        	//Hacemos 2 for() para movernos por cada una de las celdas de la matriz.
            for (int fila = 0; fila < tabla.length; fila++) {
                for (int columna = 0; columna < tabla.length; columna++) {
                    
                	//Creamos una variable que sera la suma de los vecinos de cada matriz por la que avance.
                	int suma = 0;
                	
                	//Creamos 2 for para movernos alrededor de las celdas de la celda activa. Al tener que alrededor de la celda actual,
                	//los for() tendran 3 movimientos por fila y columna, se mueven entre el -1/0/1.
                    for (int filaI = -1; filaI <= 1; filaI++) {
                        for (int columnaJ = -1; columnaJ <= 1; columnaJ++) {
                        	//Solucion al problema de que nos salgamos de la matriz, ya que la matriz no acepta numeros negativos.
                        	//Si el if() sale false, ignora la celda no existente y continua. Si el valor es true, se suma a la variable
                        	//suma el valor de la celda y lo acumula, dandondos el total de vecinos que tiene la celda activa.
                            if ((fila + filaI >= 0 && fila + filaI < tabla.length) && (columna + columnaJ >= 0 && columna + columnaJ < tabla.length))
                                suma += tabla[fila + filaI][columna + columnaJ];
                        }
                    }
                    //Como hemos sumado todas las celdas, incluida la celda activa, tenemos que restarle a la variable suma, 
                    //el contenido de la celda activa
                    suma -= tabla[fila][columna];
                    
                    //Los siguiente son las reglas del juego. Dependiendo si la celta esta viva o muerta, tiene diferentes reglas.
                    //Usamos un switch para darle las reglas a los 2 tipos de casos.
                    switch (tabla[fila][columna]) {
                    	//En el caso de que la celda este viva, hay 2 opciones. Si tiene menos de 2 o mas de 3 celdas activas, la celula muere.
                    	//Si tiene 2 o 3 celulas vivas alrededor la celula sigue viva.
                    	case 1:
                    		if (suma < 2 || suma > 3) {
        					aux[fila][columna] = 0; 
                    		}else if(suma == 2 || suma == 3) {
        					aux[fila][columna] = 1;
                    		}
                    	//En el caso de la celula muerta, solo puede vivir si tiene 3 celulas vivas alrededor.
                    	case 0:
                    		if (suma == 3) {
        					aux[fila][columna] = 1;
        				}
        		}
                }
            }
            
            //Creamos un espacio entre la matriz que hemos mostrado y la siguiente matriz
            System.out.println();
            //Creacion de las generaciones. Mostramos como quedan las siguientes matrices
            System.out.println("Generacion " + (repeticion+1));
            for (int i = 0; i < aux.length; i++) {
                for (int j = 0; j < aux.length; j++) {
                    if (aux[i][j] == 0)
                        System.out.print(". ");
                    else
                        System.out.print("* ");
                }
                System.out.println();
            }
            //Copiamos al final el estado de la matriz aux a la matriz tabla, para que en la repeticion del codigo quede reflejado en la matriz
            //tabla el estado actualizado del resultado y asi en la siguiente repeticion del codigo no repetira el estado de la tabla inicial,
            //si no de la generacion que hemos conseguido.
            for (int k = 0; k < tabla.length; k++) {
                for (int l = 0; l < tabla.length; l++) {
                    tabla[k][l] = aux[k][l];
                }
            }
        }
    }
}
