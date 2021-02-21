package algo;
import java.util.*;
public class algo17136 {

	static int n,m;
	static int map[][]=new int[11][11];
	static boolean visit[][]=new boolean[11][11];
	static int dax[]= {0,1,1};
	static int day[]= {1,1,0};
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static ArrayList pu;
	static int tmap[][];
	static int c,count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				map[i][j]=scan.nextInt();
			}
		}
		
		
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				if(!visit[i][j]) {
					
				tmap=new int[11][11];
				pu=new ArrayList();
				visit[i][j]=true;
				tmap[i][j]=1;
				point pt=new point(i,j);
				pu.add(pt);
				find(pu,pt,tmap);
				visit[i][j]=false;
				
				gogo(pu,tmap);
				
				/*for(int k=0;k<pu.size();k++) {
					point tp=(point)pu.get(k);
					int tx=tp.x;int ty=tp.y;
					tmap[tx][ty]=1;
				}*/
				
				
				
				}
			}
		}
		
		
		
	}
	
	static void find(ArrayList ap,point p,int tmap[][]) {
		
		
		for(int i=0;i<4;i++) {
			
			int x=p.x+dx[i];
			int y=p.y+dy[i];
			
			if(x>0&&y>0&&x<=10&&y<=10) {
				if(!visit[x][y]) {
					visit[x][y]=true;
					tmap[x][y]=1;
					point pt=new point(x,y);
					ap.add(pt);
					find(ap,pt,tmap);
				}
				
				
			}
			
			
			
		}
		
		
		
	}
	
	
	
	static void gogo(ArrayList a,int ma[][]) {
		int max=0;
		c=0;count=0;
		for(int i=0;i<a.size();i++) {
			point tp=(point)a.get(i);
			int tx=tp.x;
			int ty=tp.y;
			
			
			
			
		
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

