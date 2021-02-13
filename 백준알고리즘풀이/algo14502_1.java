package algo;
import java.util.*;
import java.io.*;
public class algo14502_1 {
	
	
	static int n,m;
	static boolean visit[][];
	static int k=0;
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static boolean can=false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		int map[][]=new int[n+1][m+1];
		ArrayList brkp=new ArrayList();
		
		for(int i=1;i<=n;i++) {
			in=br.readLine().split(" ");
			for(int j=1;j<=m;j++) {
				map[i][j]=Integer.parseInt(in[j-1]);
				
				if(map[i][j]==0)brkp.add(new point(i,j));
			}
		}
	
		int max=0;
		for(int i=0;i<brkp.size();i++) {
			for(int j=i+1;j<brkp.size();j++) {
				for(int k=j+1;k<brkp.size();k++) {
					point p1=(point)brkp.get(i);
					point p2=(point)brkp.get(j);
					point p3=(point)brkp.get(k);
					map[p1.x][p1.y]=1;map[p2.x][p2.y]=1;map[p3.x][p3.y]=1;
					visit=new boolean[n+1][m+1];
					int tot=spread(map);
					if(max<tot)max=tot;
					System.out.println("");
					map[p1.x][p1.y]=0;map[p2.x][p2.y]=0;map[p3.x][p3.y]=0;
				}
			}
		}
		
		
		
		System.out.println(max);
		
		
		
	}
	
	static int spread(int map[][]) {
		
		Queue q=new LinkedList();
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]==2) {
					q.add(new point(i,j));
					visit[i][j]=true;
				}
			
			}
		}
		
		
		while(!q.isEmpty()) {
			
			point p=(point)q.poll();
			map[p.x][p.y]=2;
			
			for(int i=0;i<4;i++) {
				
				int x=dx[i]+p.x;
				int y=dy[i]+p.y;
				if(x>0&&y>0&&x<=n&&y<=m) {
				if(!visit[x][y]&&map[x][y]==0) {
					visit[x][y]=true;
					q.add(new point(x,y));
				}
				}
			}
			
			
			
			
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				System.out.printf("%d ", map[i][j]);
			}System.out.println("");
		}
		
		
		
		return find(map);
		
	}
	static int find(int map[][]) {
		
		int t=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]==0)t++;
			}
		}
		System.out.println(t);
		return t;
		
	}
	
	
	
	

}

class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
}


