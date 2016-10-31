package efficientMul;

public class matrixThread extends Thread{
	int[][]matrix;
	int a;
	int b;
	int[][] X;

	
	
	public matrixThread(int[][]matrix,int a,int b){
		this.matrix=matrix;
		this.a= a;
		this.b=b;
		this.X= new int[matrix.length/2][matrix[0].length/2];
			
	}
	
	public void run(){
	this.X = matrixFunction.defSubMatrix(matrix, this.a, this.b);
	System.out.println(Thread.currentThread().getName()+" is running");
	}
	
	

}

