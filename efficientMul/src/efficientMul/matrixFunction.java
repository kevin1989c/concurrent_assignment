package efficientMul;

public class matrixFunction {
	public static int[][] matrixPlus(int[][] matr1, int[][] matr2) {
		int[][] C = new int[matr1.length][matr2[0].length];
		for (int i = 0; i < matr1.length; i++) {
			for (int j = 0; j < matr1[0].length; j++) {

				C[i][j] = matr1[i][j] + matr2[i][j];

			}
		}
		return C;
	}

	
	
	public static int[][] matrixMinus(int[][]matr1,int[][]matr2){
		int [][]C = new int[matr1.length][matr1[0].length];
		for(int i=0;i<matr1.length;i++){
			for(int j=0;j<matr1[0].length;j++){
				C[i][j]=0;
				C[i][j]=matr1[i][j]-matr2[i][j];
			}
		}
		return C;
	}

/**	public static int[][] matrixMul(int[][] matr1,int[][] matr2){
		int[][] C = new int[matr1.length][matr2[0].length];
		for(int i=0;i<matr1.length;i++){
			for(int j=0;j<matr2[0].length;j++){
				C[i][j]=0;
				for (int k=0;k<matr1[0].length;k++){
					C[i][j]+=matr1[i][k]+matr2[k][j];
				}
			}
		}
		return C;
	}    */
	
	public static int[][] defSubMatrix(int[][] matr, int x, int y) {
		int[][] C = new int[matr.length/2][matr[0].length/2]; // initialize C[][]
		if (x == 1 && y == 1) {
			for (int i = 0; i < matr.length / 2; i++) {
				for (int j = 0; j < matr[0].length / 2; j++) {
					C[i][j] = 0;
					C[i][j] = matr[i][j];
				}
			}
		}
		if (x == 1 && y == 2) {
			for (int i = 0; i < matr.length / 2; i++) {
				for (int j = matr[0].length / 2; j < matr[0].length; j++) {
					C[i][j-matr[0].length/2] = 0;
					C[i][j-matr[0].length/2] = matr[i][j];
				}
			}
		}
		if (x == 2 && y == 1) {
			for (int i = matr.length / 2; i < matr.length; i++) {
				for (int j = 0; j < matr[0].length / 2; j++) {
					C[i-matr.length/2][j] = 0;
					C[i-matr.length/2][j] = matr[i][j];
				}
			}
		}
		if (x == 2 && y == 2) {
			for (int i = matr.length / 2; i < matr.length; i++) {
				for (int j = matr[0].length / 2; j < matr[0].length; j++) {
					C[i-matr.length/2][j-matr[0].length/2] = 0;
					C[i-matr.length/2][j-matr[0].length/2] = matr[i][j];
				}
			}
		}
		return C;
	}

}
