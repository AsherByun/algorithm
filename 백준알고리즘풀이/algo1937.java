package algo;
import java.util.*;
import java.io.*;
public class algo1937 {
	static int map[][];
	static int save[][];
	static int visit[][];
	static int n;static int r=0;
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		map=new int[n+1][n+1];
		save=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			String in[]=br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				map[i][j]=Integer.parseInt(in[j-1]);
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(save[i][j]==0) {
					for(int k=0;k<4;k++) {
						int x=i+dx[k];
						int y=j+dy[k];
						if(x>=1&&y>=1&&x<=n&&y<=n) {
							if(map[x][y]>map[i][j]) {
								Stack s=new Stack();
								s.push(new point(i,j));
								find(s,new point(x,y));
							}
						}
					}
				}
			}
		}
		
		int tot=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(save[i][j]>tot) {
					tot=save[i][j];
				}
			}
		}
		System.out.println(r);
		System.out.println(tot);
		
	}
	static void find(Stack s,point p) {
		boolean chan=false;
		boolean next=false;
		s.push(new point(p.x,p.y));
		for(int i=0;i<4;i++) {
			int x=dx[i]+p.x;
			int y=dy[i]+p.y;
			
			if(x>=1&&y>=1&&x<=n&&y<=n) {
				if(map[p.x][p.y]<map[x][y]) {
					chan=true;
					find(s,new point(x,y));
				}
			}	
		}
		
		if(!chan) {
			Stack ts=(Stack)s.clone();
			pp(ts);
		}
		s.pop();
		
	}
	static void pp(Stack s) {
		int c=0;
		while(!s.isEmpty()) {
			c++;
			point p=(point)s.pop();
			int x=p.x;int y=p.y;
			if(save[x][y]<c) {
				save[x][y]=c;
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
