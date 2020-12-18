package algo;
import java.util.*;
//bfs + dp
public class algo2178 {
	
	
	static int[][] map;
	
	static int n,m;
	static int[][] visit;
	static int[] dx = new int[] {0,-1,0,1};
	static int[] dy = new int[] {-1,0,1,0};
	static Queue q =new LinkedList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		n=scan.nextInt();
		m=scan.nextInt();
		map=new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			String in = scan.next();
			for(int j=1;j<=m;j++) {
				map[i][j]=in.charAt(j-1) - '0';
			}
		}
		
		
		
		point p = new point(1,1);
		q.add(p);
		visit=new int[n+1][m+1];
		find();
		
		System.out.println(map[n][m]);
		
		
	}
	
	
	static void find() {
		
		
		
		
		while(!q.isEmpty()) {
		point p = (point)q.poll();
		for(int i=0;i<4;i++) {
			int nx = p.x + dx[i];
			int ny = p.y + dy[i];

			if(nx<=n&&ny<=m&&nx>0&&ny>0) {
				if(visit[nx][ny]==1) {}
				else if(map[nx][ny]==1) {
					point pt = new point(nx,ny);
					q.add(pt);
					map[nx][ny]=map[p.x][p.y]+1;
					visit[nx][ny]=1;
					
					
				}
				
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
	
}
