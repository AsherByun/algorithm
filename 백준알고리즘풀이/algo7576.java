package algo;
import java.util.*;
public class algo7576 {

	static int[][] map;
	static int n,m;
	static int count=0;
	static int[] dx = new int[] {0,-1,0,1};
	static int[] dy = new int[] {-1,0,1,0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Stack s=new Stack();
		m = scan.nextInt();
		n = scan.nextInt();
		boolean first=false;
		boolean last=false;
		map=new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				map[i][j]=scan.nextInt();
				if(map[i][j]==0) {first=true;}
				if(map[i][j]==1) {
					point p = new point(i,j);
					s.push(p);
					
				}
			}
		}
		
			find(0,s);
			
			
			
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]==0) {last=true;}
			}
		}
			
			
		if(!first) {
			System.out.println(0);
		}else if(last) {
			System.out.println(-1);
		}else {
			System.out.println(count);
		}
		
		
	}
	static void find(int c,Stack sk) {
		
		Stack temp = new Stack();
		while(!sk.isEmpty()) {
		point p = (point)sk.pop();
		
		for(int i=0;i<4;i++) {
			int nx = p.x + dx[i];
			int ny = p.y + dy[i];
			
			if(nx<=n&&ny<=m&&nx>0&&ny>0) {
				if(map[nx][ny]==0) {
					map[nx][ny]=1;
					point pt = new point(nx,ny);
					
					temp.push(pt);
				}
				}
			}
		}
		if(!temp.isEmpty()) {
		int k=c+1;
		if(k>count) {count=k;}
		find(k,temp);
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
