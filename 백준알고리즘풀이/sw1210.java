/* bfs 사용
 * x 부터 시작해서 위로 올라감
 * 좌우로 가는 것에 우선순위를 줌
 * 지나간길은 check해서 다시 안지나감
 */

package samsong;
import java.util.*;
import java.awt.*;
import java.io.*;
public class sw1210 {
	static int map[][];
	static int dx[]= {0,0,-1};
	static int dy[]= {-1,1,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList a=new ArrayList();
		for(int tc=1;tc<=10;tc++) {
			int num=Integer.parseInt(br.readLine());
			map=new int[100][100];
			Point startp=new Point(0,0);
			
			for(int i=0;i<100;i++) {
				String ins[]=br.readLine().split(" ");
				for(int j=0;j<100;j++) {
					map[i][j]=Integer.parseInt(ins[j]);
					//끝나는 지점 2의 위치를 저장 ==> BFS시작부분
					if(map[i][j]==2)startp=new Point(i,j);
				}
			}
			int res=find(startp);
			a.add(res);
		}
		
		for(int i=0;i<a.size();i++) {
			int tarx=(int)a.get(i);
			System.out.println("#"+(i+1)+" "+tarx);
		}
		
		
	}
	static int find(Point pt) { //2의 위치에서 부터 BFS 시작
		Queue q=new LinkedList();
		q.add(pt);
		int ty=0;
		boolean tmap[][]=new boolean[100][100];
		while(!q.isEmpty()) {
			Point p=(Point)q.poll();
			int x=p.x; int y=p.y;
			tmap[x][y]=true;
			for(int i=0;i<3;i++) {
				int nx=dx[i]+x;
				int ny=dy[i]+y;
				
				if(nx>=0&&ny>=0&&nx<100&&ny<100&&map[nx][ny]==1&&!tmap[nx][ny]) {
					if(nx==0) {
						ty=ny;
						break;
					}else {
					q.add(new Point(nx,ny));
					break;
					}
				}
			}
		}
		return ty;
	}
}
