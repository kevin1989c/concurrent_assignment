package efficientMul;


import java.util.Date;

public class Matrix {
	public static int[][] A11 ;
	public static int[][] A12 ;
	public static int[][] A21 ;
	public static int[][] A22 ;
	public static int[][] B11 ;
	public static int[][] B12 ;
	public static int[][] B21 ;
	public static int[][] B22 ;
	public static int[][] M1 ;
	public static int[][] M2 ;
	public static int[][] M3 ;
	public static int[][] M4 ;
	public static int[][] M5 ;
	public static int[][] M6 ;
	public static int[][] M7 ;
	public static int[][] C11 ;
	public static int[][] C12 ;
	public static int[][] C21 ;
	public static int[][] C22 ;
	

	public static int[][] fill(int a, int b) {
		int[][] s = new int[a][b];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {

				s[i][j] = (int) (Math.random() *100);
			}
		}
		return s;
	}

	public static void main(String[] args) throws Exception{
		long st = new Date().getTime();
		int m = 1400;
		int k = 1400;
		int n = 1400;
		int[][] matrix1 = new int[m][k];
		int[][] matrix2 = new int[k][n];

		matrix1 = fill(m, k);
		matrix2 = fill(k, n);

		
		mulThread t1 = new mulThread(matrix1,matrix2);
		t1.start();
		
		try{
			t1.join();
			
	      }catch(InterruptedException e){}



			long ft = new Date().getTime();
			System.out.println(st+"->start   "+ "\n"   +ft+"->finish" + "\n"   +(ft-st)+"ms->time-consuming");
			 
			
	/**		for(int i=0;i < m;i++)
			  {
			    for(int j=0;j<n;j++)
			    {
	           
			      System.out.print( t1.C[i][j]+"   ");
			    }
			    System.out.println("*");
			  }  */
	}


}


