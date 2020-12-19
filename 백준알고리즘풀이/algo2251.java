package algo;
import java.util.*;
import java.io.*;

public class algo2251 {
	static int A,B,C;
	static boolean map[]=new boolean[201];
	static int bol[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		A=Integer.parseInt(in[0]);
		B=Integer.parseInt(in[1]);
		C=Integer.parseInt(in[2]);
		
		bol=new int[3];
		
		bol[0]=A;bol[1]=B;bol[2]=C;
		
		find();
		
		
		
		for(int i=0;i<=200;i++) {
			if(map[i])System.out.printf("%d ",i);
		}
		
		
		
		
	}
	static void find() {
		
		
		
		
			if(bol[0]==0) {
				map[bol[2]]=true;
			}
			int[] tb=bol;

			for(int i=0;i<=2;i++) {
				for(int j=0;j<=2;j++) {
					pour(i,j);
					find();
					bol=tb;
				}
			}
			
			
		
		
		
		
		
		
		
	}
	
	static void pour(int l1,int l2) {
		int t1=0;
		int t2=0;
		
		if(l1==0) {
			t1=A;
		}else if(l1==1) {
			t1=B;
		}else {
			t1=C;
		}
		if(l2==0) {
			t2=A;
		}else if(l2==1) {
			t2=B;
		}else {
			t2=C;
		}
		
		int temp=t2-bol[l2];
		
		if(bol[l1]>=temp) {
			bol[l1]-=temp;
			bol[l2]+=temp;
		}else {
			bol[l2]+=bol[l1];
			bol[l1]=0;
		}
		
	}
		
		
		
		
		
				
		
		
		
	
	
	

}
