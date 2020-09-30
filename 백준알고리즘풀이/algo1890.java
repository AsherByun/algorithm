package algo;
import java.util.*;
import java.io.*;
public class algo1890 {
	static int map[][];
	static int n;
	static boolean visit[][];
	static long dp[][];
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		map=new int[n+1][n+1];
		dp=new long[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			String in[]=br.readLine().split(" ");
			for(int j=1;j<=n;j++){
				map[i][j]=Integer.parseInt(in[j-1]);
			}
		}
		
		long res=dfs(1,1);
		System.out.println(res);
		
		
	}
	static long dfs(int x,int y) {
		
		if(x==n&&y==n) {
			return 1;
		}
		if((x!=n||y!=n)&&map[x][y]==0) {
			return 0;
		}
		
		
		int nx=x+map[x][y];
		int ny=y+map[x][y];
		
		if(nx<=n) {
			if(dp[nx][y]!=0) {
				dp[x][y]+=dp[nx][y];
			}else {
				dp[x][y]+=dfs(nx,y);
			}
		}
		
		
		if(ny<=n) {
			if(dp[x][ny]!=0) {
				dp[x][y]+=dp[x][ny];
			}else {
				dp[x][y]+=dfs(x,ny);
			}
		}
		return dp[x][y];
		
	}
	

}
