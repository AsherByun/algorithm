package algo;
import java.util.*;
import java.io.*;
public class algo10026_1 {
	
	static char map[][];
	
	static int n,m;
	static boolean v1[][];
	
	
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split("");
		
		n=Integer.parseInt(in[0]);
		
		map=new char[101][101];
		
		
		for(int i=1;i<=n;i++) {
			String ain=br.readLine();
			for(int j=1;j<=n;j++) {
				map[i][j]=ain.charAt(j-1);
				
			}
		}
		
		
		
		
		v1=new boolean[101][101];
		
		int n1=0;
		int n2=0;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(!v1[i][j]) {
					n1++;
					point p=new point(i,j);
					find1(p,map[i][j]);
				}
				
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j]=='R') {
					map[i][j]='G';
				}
			}
		}
		v1=new boolean[101][101];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(!v1[i][j]) {
					n2++;
					point p=new point(i,j);
					find1(p,map[i][j]);
				}
				
			}
		}
		
		
		
		System.out.println(n1+" "+n2);
		
		
		
		
	}
	static void find1(point p,char w) {
		v1[p.x][p.y]=true;
		for(int i=0;i<4;i++) {
			
			int x=dx[i]+p.x;
			int y=dy[i]+p.y;
			
			if(x>0&&y>0&&x<=n&&y<=n) {
				if(!v1[x][y]&&map[x][y]==w) {
					point pt=new point(x,y);
					
					find1(pt,w);
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

