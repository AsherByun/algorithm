package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class algo1103 {
	static int map[][];
	static int max=-1;
	static int inf=0;
	static int n,m;
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static int visit[][];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
		String in[]=br.readLine().split(" ");
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		map=new int[n+1][m+1];
		visit=new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			in=br.readLine().split("");
			for(int j=1;j<=m;j++) {
				if(in[j-1].equals("H")) {
					map[i][j]=0;
				}else {
					map[i][j]=Integer.parseInt(in[j-1]);
				}
			}
		}
		boolean v[][]=new boolean[n+1][m+1];
		dfs(1,1,0,v);
		
		
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=m;j++) {
//				System.out.printf("%d", map[i][j]);
//			}	System.out.println("");
//	}

		
		
		
		
	}
	
	static void dfs(int x,int y,int c,boolean v[][]) {
		
		if(v[x][y]) {
			max=-1;
			return;
		}
		v[x][y]=true;
		if(map[x][y]==0||x>n||x<=0||y>m||y<=0) {
			if(c>max)max=c;
			return;
		}
		
		if(visit[x][y]<c) {
			visit[x][y]=c;
		}else {
			return;
		}
		
		for(int i=0;i<4;i++) {
			
			
			
			
		}
		
		
		
		
	}
	
	
	
	
	
}