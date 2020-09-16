package algo;
import java.util.*;
import java.io.*;
public class algo1520 {
	static int map[][];
	static int n,m;
	static int tmin;
	static int visit[][];
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		map=new int[n+1][m+1];
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		for(int i=1;i<=n;i++) {
			in=br.readLine().split(" ");
			for(int j=1;j<=m;j++) {
				map[i][j]=Integer.parseInt(in[j-1]);
			}
		}
		tmin=Integer.MAX_VALUE-1;
		visit=new int[n+1][m+1];
		for(int i=1;i<=n;i++)Arrays.fill(visit[i], Integer.MAX_VALUE-1);
		
		dfs(1,1);
		
		
		
		
	}
	static int dfs(int x,int y) {
		
		if(x==n&&y==m) {
			return map[x][y];
		}
		
		
		for(int i=0;i<4;i++) {
			int nx=dx[i]+x;
			int ny=dy[i]+y;
			
			if(nx>=1&&ny>=1&&nx<=n&&ny<=m) {
				if(visit[nx][ny]==Integer.MAX_VALUE-1)
				
			}
		}
		
		
		
		
	}

}
