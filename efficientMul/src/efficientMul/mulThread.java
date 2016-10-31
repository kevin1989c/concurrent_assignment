package efficientMul;

public class mulThread extends Thread {
	int [][]matr1;
	int [][]matr2;
	int [][]C;
	public mulThread(int[][] matr1,int[][] matr2){
		this.matr1=matr1;
		this.matr2=matr2;
	}
	public void run(){
		if (matr1.length<350){
		C = new int[matr1.length][matr2[0].length];
		for(int i=0;i<matr1.length;i++){
			System.out.println(Thread.currentThread().getName()+" is running");
			for(int j=0;j<matr2[0].length;j++){
				C[i][j]=0;
				for (int k=0;k<matr1[0].length;k++){
					C[i][j]+=matr1[i][k]+matr2[k][j];
				}
			}
		}}
		else{
			calculateFunction c= new calculateFunction(matr1, matr2);
			c.multiple();
			C=c.matrix3;
			
		}
		//return C;
	}

}
