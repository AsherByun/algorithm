package algo;
import java.util.*;
import java.io.*;
public class algo2823_1 {

	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	
	static int[][] map;
	static int visit[][];
	static int n,m;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		map=new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			in=br.readLine().split("");
			for(int j=1;j<=m;j++) {
				if(in[j-1].equals("X")) {
					map[i][j]=1;
				}else {
					map[i][j]=0;
				}
			}
		}
		boolean tot=true;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]==0) {
					int can=0;
					
					for(int t=0;t<4;t++) {
						int nx=dx[t]+i;
						int ny=dy[t]+j;
						
						if(nx>0&&ny>0&&ny<=m&&nx<=n) {
							if(map[nx][ny]==0)can++;
						}		
					}
					if(can<2)tot=false;
				}
			}
		}
		if(tot) {
		System.out.println(0);
		}else {
			System.out.println(1);
		}
		
	}
	
	
	

}
