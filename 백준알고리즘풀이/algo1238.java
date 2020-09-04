package algo;
import java.util.*;
import java.io.*;
public class algo1238 {

	static int n,m,x;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] in=br.readLine().split(" ");
		
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		x=Integer.parseInt(in[2]);
		
		map=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
		Arrays.fill(map[i], 99999);
		}
		for(int i=0;i<m;i++) {
			
			in=br.readLine().split(" ");
			
			int s=Integer.parseInt(in[0]);
			int e=Integer.parseInt(in[1]);
			int w=Integer.parseInt(in[2]);
			map[s][e]=w;
			
		}
		
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {if(i==k)continue;
				for(int j=1;j<=n;j++) {if(k==j||i==j)continue;
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		int max=0;
		for(int i=1;i<=n;i++) {
			if(i!=x) {
			int temp=map[i][x]+map[x][i];
			if(temp>max) {max=temp;}
			}
		}
		
		System.out.println(max);
		
		
		
		
		
		
	}

}
