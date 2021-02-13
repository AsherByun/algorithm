package algo;
import java.util.*;
public class algo14503 {
	
	static int map[][];
	static int n,m;
	static boolean visit[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		n=scan.nextInt();
		m=scan.nextInt();
		
		map=new int[n][m];
		visit=new boolean[n][m];
		
		int x=scan.nextInt();
		int y=scan.nextInt();
		int d=scan.nextInt();
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=scan.nextInt();
			}
		}
		
		int tot=0;
		
		while(true) {
			
			
			if(!visit[x][y]) {
				tot++;
				visit[x][y]=true;
			}
			boolean can=false;
			for(int i=0;i<4;i++) {
				if(d==0) {
					d=3;
					int dx=x;
					int dy=y-1;
					
					if(dx<n&&dy<m&&dx>=0&&dy>=0)
					if(!visit[dx][dy]&&map[dx][dy]!=1) {
						x=dx;y=dy;
						can=true;
						break;
					}
				}else if(d==1) {
					d=0;
					int dx=x-1;
					int dy=y;
					
					if(dx<n&&dy<m&&dx>=0&&dy>=0)
					if(!visit[dx][dy]&&map[dx][dy]!=1) {
						x=dx;y=dy;
						can=true;
						break;
					}
				}else if(d==2) {
					d=1;
					int dx=x;
					int dy=y+1;
					
					if(dx<n&&dy<m&&dx>=0&&dy>=0)
					if(!visit[dx][dy]&&map[dx][dy]!=1) {
						x=dx;y=dy;
						can=true;
						break;
					}
				}else if(d==3) {
					d=2;
					int dx=x+1;
					int dy=y;
					
					if(dx<n&&dy<m&&dx>=0&&dy>=0)
					if(!visit[dx][dy]&&map[dx][dy]!=1) {
						x=dx;y=dy;
						can=true;
						break;
					}
				}	
			}
			if(!can) {
				
					if(d==0) {
						x=x+1;
					}else if(d==1) {
						y=y-1;
					}else if(d==2) {
						x=x-1;
					}else if(d==3) {
						y=y+1;
					}
					
					if(map[x][y]==1) {
						break;
					}
			}	
			
		}
		System.out.println(tot);
	}

}

class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
}

