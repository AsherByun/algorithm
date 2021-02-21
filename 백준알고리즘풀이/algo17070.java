package algo;
import java.util.*;
public class algo17070 {
	
	static int map[][];
	static int n,m;
	static int c=0;
	static int mv1[][]= {{0,1},{1,2}};
	static int mv2[][]= {{2,0},{2,1}};
	static int mv3[][]= {{1,2},{2,1},{2,2}};
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		n=scan.nextInt();
		
		map=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j]=scan.nextInt();
			}
		}
		point now1=new point(1,1);
		point now2=new point(1,2);
		
		find(now1,now2);
		
		System.out.println(c);
		
		
	}
	
	static void find(point p1,point p2) {
		
		//System.out.println(p1.x+" "+p1.y+"    "+p2.x+" "+p2.y+" ");
		if(p2.x==n&p2.y==n) {
			c++;
		}
		else {
		if(p2.x-p1.x==0&&p2.y-p1.y==1) {
			if(p1.x<=n&&p1.y+2<=n) {
				if(map[p1.x][p1.y+2]==0) {
				find(new point(p2.x,p2.y),new point(p1.x,p1.y+2));
			}}
			if(p1.x+1<=n&&p1.y+2<=n) {
				if(map[p1.x+1][p1.y+2]==0&&map[p1.x][p1.y+2]==0&&map[p1.x+1][p1.y+1]==0) {
				find(new point(p2.x,p2.y),new point(p1.x+1,p1.y+2));
			}}
			
		}else if(p2.x-p1.x==1&&p2.y-p1.y==0) {
				if(p1.x+2<=n&&p1.y<=n) {
					if(map[p1.x+2][p1.y]==0) {
					find(new point(p2.x,p2.y),new point(p1.x+2,p1.y));
				}}
				if(p1.x+2<=n&&p1.y+1<=n) {
					if(map[p1.x+2][p1.y+1]==0&&map[p1.x+2][p1.y]==0&&map[p1.x+1][p1.y+1]==0) {
					find(new point(p2.x,p2.y),new point(p1.x+2,p1.y+1));
				}}
			
			
		}else if(p2.x-p1.x==1&&p2.y-p1.y==1) {
				if(p1.x+1<=n&&p1.y+2<=n) {
					if(map[p1.x+1][p1.y+2]==0) {
					find(new point(p2.x,p2.y),new point(p1.x+1,p1.y+2));
				}}
				if(p1.x+2<=n&&p1.y+1<=n) {
					if(map[p1.x+2][p1.y+1]==0) {
					find(new point(p2.x,p2.y),new point(p1.x+2,p1.y+1));
				}}
				if(p1.x+2<=n&&p1.y+2<=n) {
					if(map[p1.x+2][p1.y+2]==0&&map[p1.x+1][p1.y+2]==0&&map[p1.x+2][p1.y+1]==0) {
						find(new point(p2.x,p2.y),new point(p1.x+2,p1.y+2));
				}}
			
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

