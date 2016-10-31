package naive;

public class matrix {
	public int[][] matrix1;
	public int[][] matrix2;
	
	public  matrix(int m,int k,int n){

     matrix1 = new int[m][k];
     matrix2 = new int[k][n];

      

     fill(matrix1);
     fill(matrix2);
	
	

	}
	
public static void fill(int[][] s)
	    {
	        for (int i=0; i<s.length; i++)
	        {
	            for(int j=0; j<s[i].length; j++)
	            {
	            
	                s[i][j] = (int) (Math.random() * 100);
	            }
	        }
	    }

	

}
