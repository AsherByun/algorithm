package algo;
import java.util.*;
import java.awt.*;
import java.io.*;
public class algo1249 {
	static int dp[][];
	static int map[][];
	static int n;
	static int testc;
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		testc=Integer.parseInt(br.readLine());
		ArrayList res=new ArrayList();
		
		for(int tc=0;tc<testc;tc++) {
			n=Integer.parseInt(br.readLine());
			map=new int[n+1][n+1];
			dp=new int[n+1][n+1];
			for(int i=1;i<=n;i++)
				Arrays.fill(dp[i], 99999999);
			
			for(int i=1;i<=n;i++) {
				String in=br.readLine();
				for(int j=1;j<=in.length();j++) {
					map[i][j]=in.charAt(j-1)-'0';
				}
			}
			find(new Point(2,1),map[1][1]+map[2][1]);
			find(new Point(1,2),map[1][1]+map[1][2]);
			
			res.add(dp[n][n]);
		}
		for(int i=0;i<res.size();i++) {
			System.out.println("#"+(i+1)+" "+res.get(i));
		}
	}
	static void find(Point p,int sum) {
		int x=p.x;int y=p.y;
		dp[x][y]=sum;
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>0&&ny>0&&nx<=n&&ny<=n) {
				int s=sum+map[nx][ny];
				if(dp[nx][ny]>s) {
					find(new Point(nx,ny),s);
				}
			}
			
		}
		
	}
}






//for(int i=1;i<=n;i++) {
//	System.out.println("");
//	for(int j=1;j<=n;j++) {
//		System.out.printf("%d", map[i][j]);
//	}
//}