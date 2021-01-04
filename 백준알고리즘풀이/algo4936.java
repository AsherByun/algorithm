package algo;
import java.util.*;
public class algo4936 {
	
	static int map[][];
	static int n;
	static int m;
	static int dx[]= {0,-1,-1,-1,0,1,1,1};
	static int dy[]= {-1,-1,0,1,1,1,0,-1};
	static boolean visit[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		ArrayList res=new ArrayList();
		while(true) {
			m=scan.nextInt();
			n=scan.nextInt();
			if(n==0&&m==0) {
				break;
			}
			else {
				map=new int[n+1][m+1];
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=m;j++) {
						map[i][j]=scan.nextInt();
					}
					
				}
				int count=0;
				visit=new boolean[n+1][m+1];
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=m;j++) {
						if(map[i][j]==1&&!visit[i][j]) {
							count++;
							visit[i][j]=true;
							
							point p=new point(i,j);
							find(p);
						}
					}
				}
				
				res.add(count);
					
			}
			
		}
		
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}

	}
	
	static void find(point p) {
		
		
		for(int i=0;i<8;i++) {
			int nx=p.x+dx[i];
			int ny=p.y+dy[i];
			if(nx>0&&nx<=n&&ny>0&&ny<=m) {
			if(map[nx][ny]==1&&!visit[nx][ny]) {
				point pt = new point(nx,ny);
				visit[nx][ny]=true;
				
				find(pt);
			}
			}
			
			
		}
		
		
		
	}
	
	

}
class point{
	int x;
	int y;
	
	point(int x,int y){
		this.x=x;
		this.y=y;
	}
}