import java.util.*;
import java.io.*;
import java.awt.*;
public class brand_2 {
	static int map[][];
	static int n;
	static boolean visit[][];
	static int cmap[][];
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static boolean can=true;
	static int max=0;
	static ArrayList<Point> cb=new ArrayList();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		map=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			String tstr[]=br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				map[i][j]=Integer.parseInt(tstr[j-1]);
			}
		}
		cmap=new int[n+1][n+1];
		
		/////////////가능점 구하기
		Queue water = new LinkedList();
		Queue man = new LinkedList();
		water.add(new Point(1,1));
		man.add(new Point(n,n));
		visit=new boolean[n+1][n+1];
		visit[n][n]=true;
		visit[1][1]=true;
		while(can) {
			can=true;
			water=waterbfs(water);
			man=manbfs(man);
		}
		/////////////////벽세우고 돌리기
		for(int j=1;j<=n;j++)cmap[j]=map[j].clone();
		cmap[1][1]=1;
		wbfs();
		counting();
		for(int i=0;i<cb.size();i++) {
			for(int j=1;j<=n;j++)cmap[j]=map[j].clone();
			Point p=cb.get(i);
			cmap[p.x][p.y]=1;
			cmap[1][1]=1;
			wbfs();
			counting();
		}
		System.out.println(max);
		
	}
	static void counting() {
		int sum=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(cmap[i][j]==0)sum++;
			}
		}
		max=Math.max(max,sum);
	}
	static void wbfs() {
		Queue q=new LinkedList();
		q.add(new Point(1,1));
		while(!q.isEmpty()) {
			Point p=(Point)q.poll();
			int x=p.x;int y=p.y;
			for(int i=0;i<4;i++) {
				int nx=x+dx[i]; int ny=y+dy[i];
				if(nx>0&&ny>0&&nx<=n&&ny<=n) {
					if(cmap[nx][ny]==0) {
						cmap[nx][ny]=1;
						q.add(new Point(nx,ny));
					}
				}
			}
			
		}
	}
	
	
	static Queue waterbfs(Queue water) {
		Queue tempq=new LinkedList();
		while(!water.isEmpty()) {
			Point p=(Point)water.poll();
			int x=p.x;int y=p.y;
			for(int i=0;i<4;i++) {
				int nx=x+dx[i]; int ny=y+dy[i];
				if(nx>0&&ny>0&&nx<=n&&ny<=n) {
					if(!visit[nx][ny]&&map[nx][ny]==0) {
						visit[nx][ny]=true;
						tempq.add(new Point(nx,ny));
					}
				}
			}
			
		}
		
		return tempq;
	}
	
	static Queue manbfs(Queue man) {
		Queue tempq=new LinkedList();
		boolean one=false;
		while(!man.isEmpty()) {
			Point p=(Point)man.poll();
			int x=p.x;int y=p.y;
			for(int i=0;i<4;i++) {
				int nx=x+dx[i]; int ny=y+dy[i];
				if(nx>0&&ny>0&&nx<=n&&ny<=n) {
					if(!visit[nx][ny]&&map[nx][ny]==0) {
						visit[nx][ny]=true;
						cb.add(new Point(nx,ny));
						tempq.add(new Point(nx,ny));
						one=true;
					}
				}
			}
			
		}
		if(!one)can=false;
		return tempq;
	}
}
