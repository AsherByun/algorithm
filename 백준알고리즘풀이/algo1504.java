package algo;
import java.util.*;
import java.io.*;
public class algo1504 {
	static int n,m;
	static int min;
	static int p1,p2;
	static int bad;
	static int map[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		map=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
		Arrays.fill(map[i], 99999);
		
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
		bad=map[1][p1]+map[p1][p2]+map[p2][n];
		min=bad;
		if(map[1][n]==99999||map[1][p1]==99999||map[1][p2]==99999) {
			System.out.println(-1);
		}
		else {
			
			boolean v[]=new boolean[n+1];
			find(0,1,v);
			
			System.out.println(min);
			
			
			
		}
		
		
		
		
		
	}
	
	static void find(int tot,int now,boolean[] v) {
		v[now]=true;
		if(tot>bad) {return;}
		else if(now==4&&v[0]&&v[p1]&&v[p2]&&v[n]) {
			if(tot<bad&&min>tot) {min=tot;}
			return;
		}
		
		else if(now==1) {
			
			find(tot+map[now][p1],p1,v);
			find(tot+map[now][p2],p2,v);
			find(tot+map[now][n],n,v);
		}else if(now==p1) {
			
			find(tot+map[now][1],1,v);
			find(tot+map[now][p2],p2,v);
			find(tot+map[now][n],n,v);
		}else if(now==p2) {
			
			find(tot+map[now][p1],p1,v);
			find(tot+map[now][1],1,v);
			find(tot+map[now][n],n,v);
		}
		
		
		
	}
	
	

}
