package algo;
import java.util.*;
import java.io.*;
public class algo2823 {

	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	
	static int[][] map;
	static int visit[][];
	static int n,m;
	static boolean can;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		map=new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			in=br.readLine().split("");
			for(int j=1;j<=m;j++) {
				if(in[j-1].equals("X")) {
					map[i][j]=1;
				}else {
					map[i][j]=0;
				}
			}
		}
		boolean tot=true;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]==0) {
					can=false;
					visit=new int[n+1][m+1];
//					System.out.println("......................");
					find(new point(i,j),new point(i,j),5);
					if(!can)tot=false;
				}
			}
		}
		if(tot) {
		System.out.println(0);
		}else {
			System.out.println(1);
		}
		
	}
	
	static void find(point np,point stp,int d) {
		
		visit[np.x][np.y]++;
//		System.out.println(np.x+"   "+np.y);
		if(np.x==stp.x&&np.y==stp.y&&visit[stp.x][stp.y]>1) {
			can=true;return;
		}
		
		
		for(int i=0;i<4;i++) {
			
			int nx=dx[i]+np.x;
			int ny=dy[i]+np.y;
			
			if(i==0&&d==2) {
				continue;
			}if(i==1&&d==3) {
				continue;
			}if(i==2&&d==0) {
				continue;
			}if(i==3&&d==1) {
				continue;
			}
			if(nx>0&&ny>0&&nx<=n&&ny<=m) {
				if(map[nx][ny]==0&&visit[nx][ny]<2) {
					find(new point(nx,ny),stp,i);
				}	
			
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
