package naive;

import java.util.Arrays;



class NaiveMul extends Thread  {
int[][]A;
int[][]B;
long[][]C;
int s;
int e;
	
	public NaiveMul(int[][]A, int[][]B, int s, int e){
	this.A = A;
	this.B = B;
	this.e = e;
	this.s = s;
	this.C = new long [A.length][B[0].length];

	}
	public void run(){
		  

	    long [][] c = new long [A.length][B[0].length];
	    
		
		   for (int i=s; i < e; i++){
			   System.out.println(Thread.currentThread().getName()+":calculate line-> "+(i+1));
				for (int j=0; j < B[0].length; j++){
					 c[i][j]=0;
					for(int g=0; g< A[0].length; g++ ){
						c[i][j]+=A[i][g]*B[g][j];
						this.C[i][j]=c[i][j];
						 
					}
					 
				}
				
		  }
		  // System.out.println(Arrays.deepToString(c));
		//return c;
		 
		   }
	
	}
		



    
 /**   public static void fillRandom(int[][] x)
	    {
	        for (int i=0; i<x.length; i++)
	        {
	            for(int j=0; j<x[i].length; j++)
	            {
	                //每个元素设置为0到99的随机自然数
	                x[i][j] = (int) (Math.random() * 100);
	            }
	        }
	    }
     public matrix(){}
     public matrix(int m,int k,int n){
         this.fillRandom(matrix1);
         this.fillRandom(matrix2);
    	 
     }
 
 */
 
 
 
/**
	public static int[][] MulRun2(int[][] a, int[][] b,int init_value,int init_length){

		  
			int [][] c = new int [a.length][b[0].length];
			for (int i=init_value; i < init_length; i++){
				for (int j=0; j < b[0].length; j++){
					 c[i][j]=0;
					for(int g=0; g< a[0].length; g++ ){
						c[i][j]+=a[i][g]*b[g][j];
					}
				}
			}
			return c;
			//System.out.println(Arrays.deepToString(c));
	}
}
	    */
		


