package algo;
import java .util.*;
public class algo9663 {

	static int[][] map;
	static int n;
	static boolean[][] visit;
	static boolean[] x,y;
	static int count=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		n=scan.nextInt();
		
		map =new int[n][n];
		visit = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				point p=new point(i,j);
				int num=0;
				find(p,num);
				
			}
				
		}
		
		

	}
	static void find(point p,int num) {
		
		int x=p.x;
		int y=p.y;
		num++;
		for(int i=0;)
		
		
		
		if(num==n) {
			count++;
		}else {
			
			
			
			
		}
		
		
		
		
		
		
	}
	
	
	static void visiting(point p) {
		int x=p.x;
		int y=p.y;
		for(int i=0;i<n;i++) {
			visit[x][i]=true;
		}
		for(int i=0;i<n;i++) {
			visit[i][y]=true;
		}
		
		int dx,dy;
		dx=x;dy=y;
		while(dy<n) {
			dx--;dy++;
			visit[dx][dy]=true;
		}
		dx=x;dy=y;
		while(dx<n) {
			dx++;dy--;
			visit[dx][dy]=true;
		}
		dx=x;dy=y;
		if(x>=y) {
			while(dy>=0) {
				dx--;dy--;
				visit[dx][dy]=true;
			}
		}else {
		while(dy>=0) {
			dx--;dy--;
			visit[dx][dy]=true;
		}}
		dx=x;dy=y;
		while(dx<n&&dy<n) {
			dx--;dy++;
			visit[dx][dy]=true;
		}
		
		
		
	}
	static void dagak1(int x,int y) {
		if(x>=y) {
			while(x<n) {
				visit[x][y]=true;
				x++;y++;
			}
			
			
		}else {
			while(y<n) {
				visit[x][y]=true;
				x++;y++;
			}
		}
		
		
		
	}
	static void dagak2(int x,int y) {
		if(x>=y) {
			while(x<n) {
				visit[x][y]=true;
				x++;y++;
			}
			
			
		}else {
			while(y<n) {
				visit[x][y]=true;
				x++;y++;
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
