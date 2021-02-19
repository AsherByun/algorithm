package algo;
import java.util.*;
public class algo15685 {

	static int[][] map=new int[101][101];
	static int count=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int testc = scan.nextInt();
		
		for(int k=0;k<testc;k++) {
			int x=scan.nextInt();
			int y=scan.nextInt();
			int d=scan.nextInt();
			int g=scan.nextInt();
			
			ArrayList poi = new ArrayList();
			map[y][x]=1;
			point fi=new point(x,y);
			poi.add(fi);
			if(d==0) {
				point s=new point(x+1,y);
				map[y][x+1]=1;
				poi.add(s);	
			}else if(d==1) {
				point s=new point(x,y-1);
				map[y-1][x]=1;
				poi.add(s);
			}else if(d==2) {
				point s=new point(x-1,y);
				map[y][x-1]=1;
				poi.add(s);
			}else if(d==3) {
				point s=new point(x,y+1);
				map[y+1][x]=1;
				poi.add(s);
			}
			
			for(int i=1;i<=g;i++) {
					point temp = (point) poi.get(poi.size()-1);
					int sx=temp.x;int sy=temp.y;
					map[sy][sx]=1;
					int sizee=poi.size()-1;
				for(int j=sizee-1;j>-1;j--) {
					point p = (point) poi.get(j);
					int tx=sx-p.x;int ty =sy-p.y;
					int t=tx;
					tx=ty;
					ty=t*(-1);
					tx=tx+sx; ty=ty+sy;
					map[ty][tx]=1;
					point tt = new point(tx,ty);
					poi.add(tt);
					
					
				}
				
				
				
				
			}
			
			
		}
		
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]==1) {
				if(map[i+1][j]==1&&map[i][j+1]==1&&map[i+1][j+1]==1) {
					count++;
				}
			}
		}
	}
		
		System.out.println(count);
		
		
	}
	
	

}
class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
}