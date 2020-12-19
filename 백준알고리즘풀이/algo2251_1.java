package algo;
import java.util.*;
import java.io.*;

public class algo2251_1 {
	static int a,b,c;
	static boolean map[]=new boolean[201];
	static boolean v[][]=new boolean[201][201];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		a=Integer.parseInt(in[0]);
		b=Integer.parseInt(in[1]);
		c=Integer.parseInt(in[2]);

		int[][] bol=new int[3][2];
		
		bol[0][0]=a;bol[1][0]=b;bol[2][0]=c;
		bol[0][1]=0;bol[1][1]=0;bol[2][1]=c;
		
		for(int i=0;i<=1;i++) {
				v[bol[2][1]][bol[i][1]]=true;
				find(bol,2,i);
				v[bol[2][1]][bol[i][1]]=false;
		}
		
		for(int i=0;i<=200;i++) {
			if(map[i])System.out.printf("%d ",i);
		}
		
	}
	
	static void find(int[][] bt,int s,int e) {
		
		int temp=bt[e][0]-bt[e][1];
		
		if(bt[0][1]==0) {
			map[bt[2][1]]=true;
		}
		
		
		
		if(bt[s][1]>=temp) {
			bt[s][1]-=temp;
			bt[e][1]+=temp;
		}else {
			bt[e][1]+=bt[s][1];
			bt[s][1]=0;
		}
		
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=2;j++) {
				
				if(!v[bt[i][1]][bt[j][1]]) {
					v[bt[i][1]][bt[j][1]]=true;
					find(bt,i,j);
					v[bt[i][1]][bt[j][1]]=false;
				}
				
			}
		}
		
		
		
		
		
	}
	

}
