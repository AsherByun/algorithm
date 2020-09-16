package algo;
import java.util.*;
import java.io.*;
public class algo1504_2 {
	static int n,m;
	static int min;
	static int p1,p2;
	static int bad;
	static int map[][];
	static int inf=99999;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		map=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
		Arrays.fill(map[i], inf);
		
		for(int i=0;i<m;i++) {
			in=br.readLine().split(" ");
			
			int s=Integer.parseInt(in[0]);
			int e=Integer.parseInt(in[1]);
			int w=Integer.parseInt(in[2]);
			
			if(map[s][e]>w) {
				map[s][e]=w;
				map[e][s]=w;
			}
			
		}
		in=br.readLine().split(" ");
		 p1=Integer.parseInt(in[0]);
		 p2=Integer.parseInt(in[1]);
		
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {if(k==i)continue;
				for(int j=1;j<=n;j++) {if(k==j&&i==j)continue;
					map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
				}
			}
		}
		int b1=0;
		
		if(p1==1) {
			map[1][1]=0;
		}else if(p1==n) {
			map[n][n]=0;
		}
		
		if(p2==1) {
			map[1][1]=0;
		}else if(p2==n) {
			map[n][n]=0;
		}
	
		
		
		if(map[1][n]==inf||map[1][p1]==inf||map[1][p2]==inf) {
			System.out.println(-1);
		}
		else {
			int a1=map[1][p1]+map[p1][p2]+map[p2][n];
			int a2=map[1][p2]+map[p2][p1]+map[p1][n];
			
			if((p1==1&&p2==n)||(p1==n&&p2==1)) {
				b1=map[1][n];
				System.out.println(b1);
			}
			else if(p1==1) {
				b1=map[1][p2]+map[p2][n];
				System.out.println(b1);
			}else if(p1==n) {
				b1=map[1][p2]+map[p2][n];
				System.out.println(b1);
			}else if(p2==1) {
				b1=map[1][p1]+map[p1][n];
				System.out.println(b1);
			}else if(p2==n) {
				b1=map[1][p1]+map[p1][n];
				System.out.println(b1);
			}
			
			
			
			else if(a1>=a2) {
				System.out.println(a2);
			}else {
				System.out.println(a1);
			}
			
			
		}
		
		
		
		
		
	}
	
	
	

}
