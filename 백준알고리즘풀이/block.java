package algo;
import java.util.*;
public class block {
	static int[][] board= {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
	static int map[][];
	static int n;
	static boolean visit[][][][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		map=new int[board.length+1][board[0].length+1];
		for(int i=1;i<=board.length;i++) {
			for(int j=1;j<=board[0].length;j++) {
				map[i][j]=board[i-1][j-1];
			}
		}
		visit=new boolean[n+1][n+1][n+1][n+1];
		n=board.length;
//		for(int i=1;i<=board.length;i++) {
//			for(int j=1;j<=board[0].length;j++) {
//				System.out.printf("%d ", map[i][j]);
//			}System.out.println("");
//		}
		
		dfs(new wit(new point(1,1),new point(1,2)));
		
		
		
		
		
	}
	static void dfs(wit nw) {
		
		point p1=new point(nw.p1.x,nw.p1.y);
		point p2=new point(nw.p2.x,nw.p2.y);
		wit tw=new wit(p1,p2);
		int x1=nw.p1.x;int y1=nw.p1.y;
		int x2=nw.p2.x;int y2=nw.p2.y;
		visit[x1][y1][x2][y2]=true;
		
		if(x1+1<=n&&x2+1<=n&&!visit[x1+1][y1][x2+1][y2]) {
			md(tw);
			dfs(tw);
		}
		
		p1=new point(nw.p1.x,nw.p1.y);
		p2=new point(nw.p2.x,nw.p2.y);
		tw=new wit(p1,p2);
	
		if(x1-1>=1&&x2-1>=1&&!visit[x1-1][y1][x2-1][y2]) {
			mu(tw);
			dfs(tw);
		}
		
		p1=new point(nw.p1.x,nw.p1.y);
		p2=new point(nw.p2.x,nw.p2.y);
		tw=new wit(p1,p2);
		
		if(y1+1<=n&&y2+1<=n&&!visit[x1][y1+1][x2][y2+1]) {
			mr(tw);
			dfs(tw);
		}
		
		p1=new point(nw.p1.x,nw.p1.y);
		p2=new point(nw.p2.x,nw.p2.y);
		tw=new wit(p1,p2);
		if(y1-1>=1&&y2-1>=1&&!visit[x1][y1-1][x2][y2-1]) {
			ml(tw);
			dfs(tw);
		}
		p1=new point(nw.p1.x,nw.p1.y);
		p2=new point(nw.p2.x,nw.p2.y);
		tw=new wit(p1,p2);
		
		if(x1==x2) {
			if(!visit[x1][y1][x2][y2]&&map[x2-1][y2]!=1) {
				k1(tw,p2);dfs(tw);
			}
			p1=new point(nw.p1.x,nw.p1.y);
			p2=new point(nw.p2.x,nw.p2.y);
			tw=new wit(p1,p2);
			if(!visit[x1][y1][x2][y2]&&map[x1-1][y1]!=1) {
				k2(tw,p1);dfs(tw);
			}
			p1=new point(nw.p1.x,nw.p1.y);
			p2=new point(nw.p2.x,nw.p2.y);
			tw=new wit(p1,p2);
			if(!visit[x1][y1][x2][y2]&&map[x2+1][y2]!=1) {
				c1(tw,p2);dfs(tw);
			}
			p1=new point(nw.p1.x,nw.p1.y);
			p2=new point(nw.p2.x,nw.p2.y);
			tw=new wit(p1,p2);
			if(!visit[x1][y1][x2][y2]&&map[x1+1][y1]!=1) {
				c2(tw,p1);dfs(tw);
			}
			
		}
		p1=new point(nw.p1.x,nw.p1.y);
		p2=new point(nw.p2.x,nw.p2.y);
		tw=new wit(p1,p2);
		
		if(x1!=x1) {
			if(!visit[x1][y1][x2][y2]&&map[x2-1][y2]!=1) {
				k3(tw,p2);dfs(tw);
			}
			p1=new point(nw.p1.x,nw.p1.y);
			p2=new point(nw.p2.x,nw.p2.y);
			tw=new wit(p1,p2);
			if(!visit[x1][y1][x2][y2]&&map[x1-1][y1]!=1) {
				k4(tw,p1);dfs(tw);
			}
			p1=new point(nw.p1.x,nw.p1.y);
			p2=new point(nw.p2.x,nw.p2.y);
			tw=new wit(p1,p2);
			if(!visit[x1][y1][x2][y2]&&map[x2+1][y2]!=1) {
				c1(tw,p2);dfs(tw);
			}
			p1=new point(nw.p1.x,nw.p1.y);
			p2=new point(nw.p2.x,nw.p2.y);
			tw=new wit(p1,p2);
			if(!visit[x1][y1][x2][y2]&&map[x1+1][y1]!=1) {
				c2(tw,p1);dfs(tw);
			}
		}
		
		visit[x1][y1][x2][y2]=false;
		
		
	}
	static wit md(wit w) {
		
		point p1=w.p1;
		point p2=w.p2;
		
		p1.x++;p2.x++;
		
		
		return w;
	}
	static wit mr(wit w) {
		
		point p1=w.p1;
		point p2=w.p2;
		
		p1.y++;p2.y++;
		
		
		return w;
	}
	static wit ml(wit w) {
		
		point p1=w.p1;
		point p2=w.p2;
		
		p1.y--;p2.y--;
		
		
		return w;
	}
	static wit mu(wit w) {
		
		point p1=w.p1;
		point p2=w.p2;
		
		p1.x++;p2.x++;
		
		
		return w;
	}
	static wit c1(wit w,point p) {
		
		p.x++;p.y--;
		
		
		return w;
	}
	static wit c2(wit w,point p) {
		
		p.x++;p.y++;
		
		
		return w;
	}
	static wit c3(wit w,point p) {
		
		p.x--;p.y++;
		
		
		return w;
	}
	static wit c4(wit w,point p) {
		
		p.x++;p.y++;
		
		
		return w;
	}
	static wit k1(wit w,point p) {
		
		p.x--;p.y--;
		
		
		return w;
	}
	static wit k2(wit w,point p) {
		
		p.x--;p.y++;
		
		
		return w;
	}
	static wit k3(wit w,point p) {
		
		p.x--;p.y--;
		
		
		return w;
	}
	static wit k4(wit w,point p) {
		
		p.x++;p.y--;
		
		
		return w;
	}
}
class wit{
	point p1;point p2;
	wit(point p1,point p2){
		this.p1=p1;
		this.p2=p2;
	}
}

class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
}
