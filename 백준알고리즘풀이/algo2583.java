//bfs
package algo;
import java.util.*;
public class algo2583 {
	static int n,m,k;
	static int map[][];
	static int count=0;
	static int size=0;
	static int[] dx= new int[]{-1, 0, 1, 0};
	static int[] dy= new int[]{0, 1, 0, -1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		
	
		ArrayList res =  new ArrayList();
		
		m=scan.nextInt();
		n=scan.nextInt();
		k=scan.nextInt();
		int x1[]=new int[k];
		int y1[]=new int[k];
		int x2[]=new int[k];
		int y2[]=new int[k];
		map = new int[m][n] ;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				map[i][j] = 0;
			}
		}
		
		
		for(int i=0;i<k;i++) {
			x1[i]=scan.nextInt();
			y1[i]=scan.nextInt();
			x2[i]=scan.nextInt();
			y2[i]=scan.nextInt();
			
			for(int a=x1[i];a<x2[i];a++) {
				for(int b=y1[i];b<y2[i];b++) {
					map[b][a]=1;
				}
			
			}
			
		}
		
		
		
		
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==0) {
					count =0;
					point p = new point(j,i);
					bfs(p);
					res.add(count);
					
				}
			}
		}
		Collections.sort(res);
		System.out.println(res.size());
		for(int i=0;i<res.size();i++) {
			System.out.printf("%d",res.get(i));
			if(i!=res.size()-1) {System.out.printf(" ");}
		}
		
		
		
		
		
	}

	static void bfs(point p) {
		
		map[p.y][p.x]=1;
		count++;
		
		for(int i=0;i<4;i++) {
			int nx = p.x + dx[i];
			int ny = p.y + dy[i];
			
			if(0 <= nx && nx < n && 0 <= ny && ny < m) {
				if(map[ny][nx]==0) {
					point pt = new point(nx,ny);
					bfs(pt);
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


