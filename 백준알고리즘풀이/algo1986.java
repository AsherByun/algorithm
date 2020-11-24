package algo;
import java.util.*;
public class algo1986 {
	
	static int dx[]= {-1,-2,-2,-1,1,2,2,1};
	static int dy[]= {-2,-1,1,2,2,1,-1,-2};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int m=scan.nextInt();
		ArrayList qn=new ArrayList();
		ArrayList kn=new ArrayList();
		ArrayList pn=new ArrayList();
		
		int map[][]=new int[n+1][m+1];
		int tin=scan.nextInt();
		for(int i=0;i<tin;i++) {
			int x=scan.nextInt();int y=scan.nextInt();
			qn.add(new point(x,y));
			map[x][y]=1;
		}
		tin=scan.nextInt();
		for(int i=0;i<tin;i++) {
			int x=scan.nextInt();int y=scan.nextInt();
			kn.add(new point(x,y));
			map[x][y]=1;
		}
		tin=scan.nextInt();
		for(int i=0;i<tin;i++) {
			int x=scan.nextInt();int y=scan.nextInt();
			map[x][y]=1;
		}
		for(int i=0;i<qn.size();i++) {
			point pt=(point)qn.get(i);
			int x=pt.x;int y=pt.y;
			while(true) {
				x-=1;y-=1;
				if(x<=0||y<=0||x>n||y>m)break;
				if(map[x][y]==0||map[x][y]==2) {
					map[x][y]=2;
				}else {
					break;
				}
			}
			x=pt.x;y=pt.y;
			while(true) {
				x+=1;y-=1;
				if(x<=0||y<=0||x>n||y>m)break;
				if(map[x][y]==0||map[x][y]==2) {
					map[x][y]=2;
				}else {
					break;
				}
			}
			x=pt.x;y=pt.y;
			while(true) {
				x-=1;y+=1;
				if(x<=0||y<=0||x>n||y>m)break;
				if(map[x][y]==0||map[x][y]==2) {
					map[x][y]=2;
				}else {
					break;
				}
			}
			x=pt.x;y=pt.y;
			while(true) {
				x+=1;y+=1;
				if(x<=0||y<=0||x>n||y>m)break;
				if(map[x][y]==0||map[x][y]==2) {
					map[x][y]=2;
				}else {
					break;
				}
			}
			////////////////////////////////
			x=pt.x;y=pt.y;
			while(true) {
				x+=1;
				if(x<=0||y<=0||x>n||y>m)break;
				if(map[x][y]==0||map[x][y]==2) {
					map[x][y]=2;
				}else {
					break;
				}
			}
			x=pt.x;y=pt.y;
			while(true) {
				y+=1;
				if(x<=0||y<=0||x>n||y>m)break;
				if(map[x][y]==0||map[x][y]==2) {
					map[x][y]=2;
				}else {
					break;
				}
			}
			x=pt.x;y=pt.y;
			while(true) {
				x-=1;
				if(x<=0||y<=0||x>n||y>m)break;
				if(map[x][y]==0||map[x][y]==2) {
					map[x][y]=2;
				}else {
					break;
				}
			}
			x=pt.x;y=pt.y;
			while(true) {
				y-=1;
				if(x<=0||y<=0||x>n||y>m)break;
				if(map[x][y]==0||map[x][y]==2) {
					map[x][y]=2;
				}else {
					break;
				}
			}
		}
		
		for(int i=0;i<kn.size();i++) {
			point pt=(point)kn.get(i);
			for(int j=0;j<8;j++) {
				int x=pt.x+dx[j];
				int y=pt.y+dy[j];
//				System.out.println(x+"  "+y);
				if(x>0&&y>0&&x<=n&&y<=m) {
					if(map[x][y]==0) {
						map[x][y]=2;
					}
				}
			}
		}
		int tot=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]==0) {
					tot++;
				}
			}
		}
		
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=m;j++) {
//				System.out.printf("%d ", map[i][j]);
//			}System.out.println("");
//		}
//		
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