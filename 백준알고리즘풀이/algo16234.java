package algo;
import java.util.*;
import java.io.*;
public class algo16234 {
	static int n,l,r;
	static int map[][];
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static ArrayList uni;
	static boolean visit[][];
	static ArrayList a;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		n=Integer.parseInt(in[0]);
		l=Integer.parseInt(in[1]);
		r=Integer.parseInt(in[2]);
		
		map=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			String ine[]=br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				map[i][j]=Integer.parseInt(ine[j-1]);
			}
			
		}
		
		
		int day=0;
		while(true) {
			boolean can=true;
			visit=new boolean[n+1][n+1];
			uni=new ArrayList();
			
			int same=map[1][1];
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(map[i][j]!=same)can=false;
				}
			}
			if(can)break;
			
			boolean can2=true;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
				if(!visit[i][j]) {
					a=new ArrayList();
					point p=new point(i,j);
					a.add(p);
					union(p);
					uni.add(a);
					if(a.size()>1)can2=false;
					
				}
				}
			}
			if(can2)break;
			
			
			for(int i=0;i<uni.size();i++) {
				ArrayList ma=(ArrayList)uni.get(i);
				if(ma.size()>0) {
					int tot=0;
					
					for(int j=0;j<ma.size();j++) {
						point tp=(point)ma.get(j);
						tot+=map[tp.x][tp.y];
					}
					tot=tot/ma.size();
					for(int j=0;j<ma.size();j++) {
						point tp=(point)ma.get(j);
						map[tp.x][tp.y]=tot;
					}
					
				}
				
				
			}
			
			day++;	
		
		}
		
		System.out.println(day);
		
		
	}
	
	static void union(point p) {
		
		int x=p.x;int y=p.y;
		visit[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int nx=dx[i]+x;
			int ny=dy[i]+y;
			
			if(nx>0&&ny>0&&nx<=n&&ny<=n) {
				if(Math.abs(map[x][y]-map[nx][ny])>=l&&Math.abs(map[x][y]-map[nx][ny])<=r&&!visit[nx][ny]) {
					point pt=new point(nx,ny);
					a.add(pt);
					union(pt);
					
				}
				
			}
			
			
			
		}
		
		
		
	}
	
	
}

class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
//	point(point p){
//		this.x=p.x;
//		this.y=p.y;
//	}
	
}