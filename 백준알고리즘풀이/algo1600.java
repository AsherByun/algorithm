package algo;
import java.util.*;
public class algo1600 {
	static int map[][];
	static boolean visit[][];
	static int n,m,k;
	static int dxx[]= {-1,-2,-2,-1,1,2,2,1};
	static int dyy[]= {-2,-1,1,2,2,1,-1,-2};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		k=scan.nextInt();
		n=scan.nextInt();
		m=scan.nextInt();
		visit=new boolean[n+1][m+1];
		map=new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				map[i][j]=scan.nextInt();
			}
		}
		
		point p=new point(1,1);
		find();
		
		
		
		
		
	}
	static void find(int c,int kc,point p) {
		
		
		
		
	}
}

class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
}
