package naive;

import java.util.Arrays;
import java.util.Date;




public class Naive {



public static void main(String[] args){

	
	long st = new Date().getTime();
	int x=1400;    
	int y=1400; 
	int z=1400;
//	long[][]result=new long[x][z];
	matrix m = new matrix(x,y,z);   //size of matrix1 = x*y  matrix2 = y*z
	NaiveMul n = new NaiveMul (m.matrix1,m.matrix2,0,x/8);
	NaiveMul t = new NaiveMul (m.matrix1,m.matrix2,x/8,x/4);
	NaiveMul g = new NaiveMul (m.matrix1,m.matrix2,x/4,(x*3)/8);
	NaiveMul h = new NaiveMul (m.matrix1,m.matrix2,(x*3)/8,x/2);
	NaiveMul q = new NaiveMul (m.matrix1,m.matrix2,x/2,(x*5)/8);
	NaiveMul r = new NaiveMul (m.matrix1,m.matrix2,(x*5)/8,(x*6)/8);
	NaiveMul s = new NaiveMul (m.matrix1,m.matrix2,(x*6)/8,(x*7)/8);
	NaiveMul o = new NaiveMul (m.matrix1,m.matrix2,(x*7)/8,x);
	n.start();
	t.start();
	g.start();
	h.start();
	q.start();
	r.start();
	s.start();
	o.start();

	try{
		n.join();
		t.join();
		g.join();
		h.join();
		q.join();
		r.join();
		s.join();
		o.join();
      }catch(InterruptedException e){}
	long ft = new Date().getTime();
	System.out.println(st+"->start   "+ "\n"   +ft+"->finish" + "\n"   +(ft-st)+"ms->time-consuming");
	 
/**	for(int i=0;i < x;i++)
	  {
	    for(int j=0;j<z;j++)
	    {
	      result[i][j]=n.C[i][j]+t.C[i][j]+g.C[i][j]+h.C[i][j]+q.C[i][j]+r.C[i][j]+s.C[i][j]+o.C[i][j];             
	      System.out.print(result[i][j]+"   ");
	    }
	    System.out.println("*");
	  }   */
	

}}



	
	
