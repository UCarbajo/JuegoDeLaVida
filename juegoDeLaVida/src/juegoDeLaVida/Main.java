package juegoDeLaVida;

public class Main {

	public static void main(String[] args) {
		int[][] tabla = { { 0, 0, 0, 0, 0, 0 }, 
					      { 0, 1, 1, 0, 0, 0, }, 
					      { 0, 0, 1, 1, 0, 0 }, 
					      { 0, 0, 1, 0, 0, 0 },
					      { 0, 0, 0, 0, 0, 0 }, 
					      { 0, 0, 0, 0, 0, 0 } };

		int[][] aux = new int[3][3];
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				if (tabla[i][j] == 0)
					System.out.print(". ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				int suma = 0;
				System.out.println(aux);
				for (int k = -1; k <= 1; k++) {
					for (int l = -1; l <= 1; l++) {
						if ((i+k>=0 && i+k<6) && (j+l>=0 && j+l<6))
	                        suma += tabla[i + k][j + l];

					}
					suma -= tabla[i][j];
				}
				if (suma < 2 && suma > 3) {
					tabla[i][j] = 0;
				} else if (suma == 2 || suma <= 3) {
					tabla[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				if (tabla[i][j] == 0)
					System.out.print(". ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
