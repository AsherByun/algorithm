package algo;
import java.util.*;
public class algo1012 {

	static int[] dx = new int[] {0,-1,0,1};
	static int[] dy = new int[] {-1,0,1,0};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase=scan.nextInt();
		ArrayList res = new ArrayList();
		for(int z=0;z<testcase;z++) {
			int count=0;
			int m = scan.nextInt();
			int n = scan.nextInt();
			int bug = scan.nextInt();
			int[][] map=new int[n][m];
			for(int i=0;i<bug;i++) {
				int a=scan.nextInt();
				int b=scan.nextInt();
				map[b][a]=1;
			}
			boolean[][] visit = new boolean[n][m];
			Stack s = new Stack();
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]==1&&!visit[i][j]) {
						count++;
						point pt = new point(i,j);
						s.push(pt);
						visit[i][j]=true;
						
						while(!s.isEmpty()) {
							point p = (point)s.pop(); 
							
							
							
							for(int t=0;t<4;t++) {
								int nx = p.x + dx[t];
								int ny = p.y + dy[t];
								
								if(nx<n&&ny<m&&nx>=0&&ny>=0) {
									if(map[nx][ny]==1&&!visit[nx][ny]) {
										visit[nx][ny]=true;
										point temp = new point(nx,ny);
										s.push(temp);
										
						}
						
					}
				}
			}
			
		}
				
	}

}
			res.add(count);
		}
		
		
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
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