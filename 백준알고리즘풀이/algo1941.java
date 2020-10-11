package algo;
import java.util.*;
import java.io.*;
public class algo1941 {
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static char[][] map;
	static int r=0;
	static int tot=0;
	static boolean visit[][];
	static boolean mak[][]=new boolean[6][6];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		map=new char[6][6];
		visit=new boolean[6][6];
		
		for(int i=1;i<=5;i++) {
			char[] in=br.readLine().toCharArray();
			for(int j=1;j<=5;j++) {
				map[i][j]=in[j-1];
			}
		}
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				visit=new boolean[6][6];
				visit[i][j]=true;
					dfs(i,j,0,0);
				
			}
		}
		System.out.println(r);
		System.out.println(tot/2);
		
		
	}
	static void dfs(int a,int b,int s,int y) {
		r++;
		if(s+y==7) {
			if(s>=4) {
				tot++;;return;
			}else {
				return;
			}
		}
		
		if(y>=4)return;
		int nss=s;int nyy=y; 
		if(map[a][b]=='S') {
			nss++;
		}else {
			nyy++; 
		}
		
		for(int i=0;i<4;i++){
			int nx=a+dx[i];
			int ny=b+dy[i];
			
			if(nx>=1&&ny>=1&&nx<=5&&ny<=5) {
				if(!visit[nx][ny]) {
				visit[nx][ny]=true;
				dfs(nx,ny,nss,nyy);
				visit[nx][ny]=false;
				}
			}
			
			
		}
		
		
		
		
	}
	
	
}
