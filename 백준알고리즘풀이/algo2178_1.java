/*
 * bfs 사용
 */
package algo;
import java.util.*;
import java.io.*;
import java.awt.*;
public class algo2178_1 {
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static int n,m;
	static int map[][];
	static int tmap[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String in[]=br.readLine().split(" ");
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		map=new int[n+1][m+1];
		tmap=new int[n+1][m+1];
		for(int i=1;i<=n;i++)Arrays.fill(tmap[i], Integer.MAX_VALUE-1);
		
		for(int i=1;i<=n;i++) {
			String ins[]=br.readLine().split("");
			for(int j=1;j<=m;j++) {
				map[i][j]=Integer.parseInt(ins[j-1]);
			}
		}
		tmap[1][1]=1;
		
		//(1,1) 지점부터 BFS 시작
		Queue q=new LinkedList();
		q.add(new Point(1,1));
		
		while(!q.isEmpty()) {
			Point p=(Point)q.poll();
			int x=p.x;int y=p.y;
			
			for(int i=0;i<4;i++) {
				int nx=dx[i]+x;
				int ny=dy[i]+y;
				
				if(nx>0&&ny>0&&nx<=n&&ny<=m&&map[nx][ny]==1) {
					if(tmap[nx][ny]>tmap[x][y]+1) {
						tmap[nx][ny]=tmap[x][y]+1;
						q.add(new Point(nx,ny));
					}
				}
				
			}
			
		}
		
		System.out.println(tmap[n][m]);
	}

}
