/*
 * bfs 사용하여 모든 지점 다 검사함
 * 검사해서 가장 짧은 길이를 저장한후 전체 중에 가장긴거가 답
 */
package algo;
import java.util.*;
import java.awt.Point;
import java.io.*;
public class algo2589 {
	static int map[][];
	static int n,m;
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static int tmap[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String in[]=br.readLine().split(" ");
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		map=new int[n+1][m+1];
		//L == 1 로 mapping
		for(int i=1;i<=n;i++) {
			String ins=br.readLine();
			for(int j=1;j<=m;j++) {
				char k=ins.charAt(j-1);
				if(k=='L') {
					map[i][j]=1;
				}
			}
		}
		int max=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]==1) {
					tmap=new int[n+1][m+1];
					for(int c=1;c<=n;c++)Arrays.fill(tmap[c], Integer.MAX_VALUE-1);
					tmap[i][j]=0;
					int tmax=bfs(new Point(i,j));
					if(tmax>max) {
						max=tmax;
					}
				}
			}
		}
		System.out.println(max);
	}

	static int bfs(Point pt) {  //가장 짧은 최대값 BFS
		int max=0;
		Queue q=new LinkedList();
		q.add(pt);
		int it=0;
		while(!q.isEmpty()) {
			Point p=(Point)q.poll();
			int x=p.x;int y=p.y;
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>0&&ny>0&&nx<=n&&ny<=m&&map[nx][ny]==1) {
					if(tmap[nx][ny]>tmap[x][y]+1) {
						tmap[nx][ny]=tmap[x][y]+1;
						q.add(new Point(nx,ny));
						if(tmap[nx][ny]>max)max=tmap[nx][ny];
					}
				}
			}
		}
		return max;
	}
}







//for(int i=1;i<=n;i++) {
//	for(int j=1;j<=m;j++) {
//		System.out.printf("%d",map[i][j]);
//	}System.out.println("");
//}