package algo;
import java.util.*;
import java.io.*;
public class algo4179 {
	static int n,m;
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static char map[][];
	static int fmap[][];
	static int man[][];
	static int min=Integer.MAX_VALUE-1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[0]);
		Stack fs=new Stack();
		map=new char[n+1][m+1];
		fmap=new int[n+1][m+1];
		Stack ms=new Stack();
		man=new int[n+1][m+1];
		for(int i=0;i<=n;i++)Arrays.fill(fmap[i], -1);
		for(int i=0;i<=n;i++)Arrays.fill(man[i], -1);
		for(int i=1;i<=n;i++) {
			String inn=br.readLine();
			for(int j=1;j<=m;j++) {
				map[i][j]=inn.charAt(j-1);
				if(map[i][j]=='F') {
					fs.add(new point(i,j));
					fmap[i][j]=0;
					
				}else if(map[i][j]=='#') {
					fmap[i][j]=-2;
					man[i][j]=-2;
				}else if(map[i][j]=='J') {
					ms.add(new point(i,j));
					man[i][j]=0;
				}
			}
		}
		
		fireup(1,fs);
		manup(1,ms);
		
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=m;j++) {
//				System.out.printf("%d ", fmap[i][j]);
//			}System.out.println("");
//		}
//		System.out.println("---------------------");
//		for(int i=1;i<=n;i++) {
//		for(int j=1;j<=m;j++) {
//			System.out.printf("%d ", man[i][j]);
//		}System.out.println("");
//	}
		if(min==Integer.MAX_VALUE-1) {
			System.out.println("IMPOSSIBLE");
		}else
		System.out.println(min+1);
		
		
	}
	
	static void manup(int day,Stack s) {
		Stack ts=new Stack();
		
		while(!s.isEmpty()) {
			
			point p=(point)s.pop();
			int x=p.x;int y=p.y;
			
			for(int i=0;i<4;i++) {
				int nx=dx[i]+x;
				int ny=dy[i]+y;
				if(nx>=1&&ny>=1&&nx<=n&&ny<=m) {
					if((man[nx][ny]==-1&&fmap[nx][ny]>day)||(man[nx][ny]==-1&&fmap[nx][ny]==-1)) {
						man[nx][ny]=day;
						if(nx==1||ny==1||nx==n||ny==m) {
							min=Math.min(day, min);
						}
							ts.add(new point(nx,ny));
					}
				}
				
			}
		}
		
		if(ts.size()>0) {
//			System.out.println(ts.size());
			manup(day+1,ts);
		}
		
	}
	
	
	
	static void fireup(int day,Stack s) {
		Stack ts=new Stack();
		while(!s.isEmpty()) {
			point p=(point)s.pop();
			int x=p.x;int y=p.y;
			
			for(int i=0;i<4;i++) {
				int nx=dx[i]+x;
				int ny=dy[i]+y;
				
				if(nx>=1&&ny>=1&&nx<=n&&ny<=m) {
					if(fmap[nx][ny]==-1) {
						fmap[nx][ny]=day;
						ts.add(new point(nx,ny));
					}
				}
				
			}
			
		}
		if(ts.size()>0) {
			fireup(day+1,ts);
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