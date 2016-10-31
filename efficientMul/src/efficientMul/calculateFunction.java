package efficientMul;



public class calculateFunction {
	int[][]matrix1;
	int[][]matrix2;
	int[][]matrix3;

	public calculateFunction(int[][] matrix1,int[][] matrix2){

		this.matrix1=matrix1;
		this.matrix2=matrix2;		
		this.matrix3=new int[matrix1.length][matrix2[0].length];
		}
	public void multiple(){
		
		matrixThread a11 = new matrixThread(matrix1, 1, 1);
		a11.start();
	//	A11=a11.X;
		matrixThread a12 = new matrixThread(matrix1, 1, 2);
		a12.start();
	//	A12=a12.X;
		matrixThread a21 = new matrixThread(matrix1, 2, 1);
		a21.start();
	//	A21=a21.X;
		matrixThread a22 = new matrixThread(matrix1, 2, 2);
		a22.start();
	//	A22=a22.X;
		
		matrixThread b11 = new matrixThread(matrix2, 1, 1);
		b11.start();
	//	B11=b11.X;
		matrixThread b12 = new matrixThread(matrix2, 1, 2);
		b12.start();
	//	B12=b12.X;
		matrixThread b21 = new matrixThread(matrix2, 2, 1);
		b21.start();
	//	B21=b21.X;
		matrixThread b22 = new matrixThread(matrix2, 2, 2);
		b22.start();
	//	B22=b22.X;
		
    	try{
			a11.join();
			a12.join();
			a21.join();
			a22.join();
			b11.join();
			b12.join();
			b21.join();
			b22.join();
	      }catch(InterruptedException e){}   

		// M1=(a11+a22)(b11+b22)
		
		mulThread M1 = new mulThread(matrixFunction.matrixPlus(a11.X, a22.X), matrixFunction.matrixPlus(b11.X, b22.X));
		M1.start();
		
		
		// M2=(A21+A22)B11
		
		mulThread M2 = new mulThread(matrixFunction.matrixPlus(a21.X, a22.X), b11.X);
		M2.start();
		// M3=a11(b12-b22)
	
		mulThread M3 = new mulThread(a11.X, matrixFunction.matrixMinus(b12.X, b22.X));
		M3.start();
		// m4=a22(b21-b11)
		
		mulThread M4 = new mulThread(a22.X, matrixFunction.matrixMinus(b21.X, b11.X));
		M4.start();
		// m5=(a11+a12)b22

		mulThread M5 = new mulThread(matrixFunction.matrixPlus(a11.X, a12.X), b22.X);
		M5.start();
		// m6=(a21-a11)(b11+b12)
		
		mulThread M6 = new mulThread(matrixFunction.matrixMinus(a21.X, a11.X), matrixFunction.matrixPlus(b11.X, b12.X));
		M6.start();
		// m7=(a12-a22)(b21+b22)
	
		mulThread M7 = new mulThread(matrixFunction.matrixMinus(a12.X, a22.X), matrixFunction.matrixPlus(b21.X, b22.X));
		M7.start();
		
		try{
			M1.join();
			M2.join();
			M3.join();
			M4.join();
			M5.join();
			M6.join();
			M7.join();
		
	      }catch(InterruptedException e){}  

		

		// C11=M1+M4-M5+M7
		int[][] C11 = new int[M1.C.length][M1.C[0].length];
		C11 = matrixFunction.matrixPlus(matrixFunction.matrixMinus(matrixFunction.matrixPlus(M1.C, M4.C), M5.C), M7.C);
		// C12=M3+M5
		int[][] C12 = new int[M3.C.length][M5.C[0].length];
		C12 = matrixFunction.matrixPlus(M3.C, M5.C);
		// C21=M2+M4
		int[][] C21 = new int[M3.C.length][M5.C[0].length];
		C21 = matrixFunction.matrixPlus(M2.C, M4.C);
		// C22=M1-M2+M3+M6
		int[][] C22 = new int[M1.C.length][M1.C[0].length];
		C22 = matrixFunction.matrixPlus(matrixFunction.matrixPlus(matrixFunction.matrixMinus(M1.C, M2.C), M3.C), M6.C);

		for (int i = 0; i < matrix1.length / 2; i++) {
			for (int j = 0; j < matrix2[0].length / 2; j++) {
				matrix3[i][j] = C11[i][j];
				matrix3[i][j + matrix2[0].length / 2] = C12[i][j];
				matrix3[i + matrix1.length / 2][j] = C21[i][j];
				matrix3[i + matrix1.length / 2][j + matrix2[0].length / 2] = C22[i][j];
			}
		}
		/**
		matrixThread a11 = new matrixThread(matrix1, 1, 1);
		a11.start();
		A11=a11.X;
		matrixThread a12 = new matrixThread(matrix1, 1, 2);
		a12.start();
		A12=a12.X;
		matrixThread a21 = new matrixThread(matrix1, 2, 1);
		a21.start();
		A21=a21.X;
		matrixThread a22 = new matrixThread(matrix1, 2, 2);
		a22.start();
		A22=a22.X;
		
		matrixThread b11 = new matrixThread(matrix2, 1, 1);
		b11.start();
		B11=b11.X;
		matrixThread b12 = new matrixThread(matrix2, 1, 2);
		b12.start();
		B12=b12.X;
		matrixThread b21 = new matrixThread(matrix2, 2, 1);
		b21.start();
		B21=b21.X;
		matrixThread b22 = new matrixThread(matrix2, 2, 2);
		b22.start();
		B22=b22.X;
		
		try{
			a11.join();
			a12.join();
			a21.join();
			a22.join();
			b11.join();
			b12.join();
			b21.join();
			b22.join();
	      }catch(InterruptedException e){}

		// M1=(a11+a22)(b11+b22)
		//int[][] M1 = new int[A11.length][B11[0].length];
		mulThread M1 = new mulThread(matrixFunction.matrixPlus(A11, A22), matrixFunction.matrixPlus(B11, B22));
		M1.start();
		//M1 = matrixFunction.matrixMul(matrixFunction.matrixPlus(A11, A22), matrixFunction.matrixPlus(B11, B22));
		
		// M2=(A21+A22)B11
		//int[][] M2 = new int[A21.length][B11[0].length];
		mulThread M2 = new mulThread(matrixFunction.matrixPlus(A21, A22), B11);
		M2.start();
		// M3=a11(b12-b22)
		//int[][] M3 = new int[A11.length][B12[0].length];
		mulThread M3 = new mulThread(A11, matrixFunction.matrixMinus(B12, B22));
		M3.start();
		// m4=a22(b21-b11)
		//int[][] M4 = new int[A22.length][B22[0].length];
		mulThread M4 = new mulThread(A22, matrixFunction.matrixMinus(B21, B11));
		M4.start();
		// m5=(a11+a12)b22
		//int[][] M5 = new int[A11.length][B22[0].length];
		mulThread M5 = new mulThread(matrixFunction.matrixPlus(A11, A12), B22);
		M5.start();
		// m6=(a21-a11)(b11+b12)
		//int[][] M6 = new int[A21.length][B11[0].length];
		mulThread M6 = new mulThread(matrixFunction.matrixMinus(A21, A11), matrixFunction.matrixPlus(B11, B12));
		M6.start();
		// m7=(a12-a22)(b21+b22)
		//int[][] M7 = new int[A12.length][B21[0].length];
		mulThread M7 = new mulThread(matrixFunction.matrixMinus(A12, A22), matrixFunction.matrixPlus(B21, B22));
		M7.start();
		
		try{
			M1.join();
			M2.join();
			M3.join();
			M4.join();
			M5.join();
			M6.join();
			M7.join();
		
	      }catch(InterruptedException e){}

		

		// C11=M1+M4-M5+M7
		int[][] C11 = new int[M1.C.length][M1.C[0].length];
		C11 = matrixFunction.matrixPlus(matrixFunction.matrixMinus(matrixFunction.matrixPlus(M1.C, M4.C), M5.C), M7.C);
		// C12=M3+M5
		int[][] C12 = new int[M3.C.length][M5.C[0].length];
		C12 = matrixFunction.matrixPlus(M3.C, M5.C);
		// C21=M2+M4
		int[][] C21 = new int[M3.C.length][M5.C[0].length];
		C21 = matrixFunction.matrixPlus(M2.C, M4.C);
		// C22=M1-M2+M3+M6
		int[][] C22 = new int[M1.C.length][M1.C[0].length];
		C22 = matrixFunction.matrixPlus(matrixFunction.matrixPlus(matrixFunction.matrixMinus(M1.C, M2.C), M3.C), M6.C);

		for (int i = 0; i < matrix1.length / 2; i++) {
			for (int j = 0; j < matrix2[0].length / 2; j++) {
				matrix3[i][j] = C11[i][j];
				matrix3[i][j + matrix2[0].length / 2] = C12[i][j];
				matrix3[i + matrix1.length / 2][j] = C21[i][j];
				matrix3[i + matrix1.length / 2][j + matrix2[0].length / 2] = C22[i][j];
			}
		}     */
		
	}	
		
	}


