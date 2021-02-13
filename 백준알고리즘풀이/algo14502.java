package algo;
import java.util.*;
import java.io.*;
public class algo14502 {
	
	static int map[][];
	static int n,m;
	static boolean visit[][];
	static int k=0;
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static boolean can=false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		map=new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			in=br.readLine().split(" ");
			for(int j=1;j<=m;j++) {
				map[i][j]=Integer.parseInt(in[j-1]);
			}
		}
		/*for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				System.out.printf("%d ", map[i][j]);
			}System.out.println("");
		}*/
		while(true) {
			
			int c=check();
			
			if(c==0)break;
			spread();
			
		}
		
		int sum=0;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]==0)sum++;
			}
		}
		System.out.println(sum);
		
	}
	
	static void spread() {
		Stack s=new Stack();
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				
				if(map[i][j]==2) {
					point p=new point(i,j);
					s.push(p);
				}
				
			}
			
		}
		spreaddo(s);
		}
	static void spreaddo(Stack s) {
		
		while(!s.isEmpty()) {
			point p=(point)s.pop();
			
			for(int i=0;i<4;i++) {
			int x=p.x+dx[i];
			int y=p.y+dy[i];		
			
			if(x>0&&y>0&&x<=n&&y<=m) {
			if(map[x][y]!=1) {
				map[x][y]=2;
			}
			
			
			}
			}
			
		}
		
	}
	
	static int check() {
		Stack s=new Stack();
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				
				if(map[i][j]==2) {
					point p=new point(i,j);
					s.push(p);
					
				}
				
				
				
			}
			
		}
		int c=checkdo(s);
		
		return c;
		
	}
	
	static int checkdo(Stack s) {
		boolean dd=false;
		
		int tot=3;
		visit=new boolean[n+1][m+1];
		while(!s.isEmpty()) {
			point p=(point)s.pop();
			int t=0;
			for(int i=0;i<4;i++) {
			int x=p.x+dx[i];
			int y=p.y+dy[i];		
			if(x>0&&y>0&&x<=n&&y<=m) {
			if(map[x][y]==0&&!visit[x][y]) {
				t++;
			}
			}
			}
			tot-=t;
		}
		
		
		
		return tot;
		
		
	}
	
	
	

}

class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
}


