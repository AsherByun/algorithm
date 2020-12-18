package algo;
import java.util.*;
import java.io.*;
public class algo2206 {

	static int n,m;
	static int map[][];
	static int visit[][];
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static int cmap[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		ArrayList b=new ArrayList();
		map=new int[n+1][m+1];
		cmap=new int[n+1][m+1];
		
		for(int i=1;i<=n;i++)
			Arrays.fill(cmap[i], 999999);
		
		
		for(int i=1;i<=n;i++) {
			in=br.readLine().split("");
			for(int j=1;j<=m;j++) {
				map[i][j]=Integer.parseInt(in[j-1]);
				if(map[i][j]==1) {
					point p=new point(i,j);
					
					b.add(p);
				}
			}
		}
		
		boolean can=false;
		cmap[1][1]=1;
		
		for(int i=0;i<b.size();i++) {
			
			Stack s=new Stack();
			point brk=(point)b.get(i);
			map[brk.x][brk.y]=0;
			Queue q=new LinkedList();
			q.add(new point(1,1));
			boolean ct=false;
			while(!q.isEmpty()) {
				
				point p=(point)q.poll();
				
				
				for(int j=0;j<4;j++) {
					
					int x=p.x+dx[j];
					int y=p.y+dy[j];
					
					if(x==n&&y==m) {
						can=true;ct=true;
						if(cmap[x][y]>=cmap[p.x][p.y]+1) {
							cmap[x][y]=cmap[p.x][p.y]+1;
						}
					}else if(x<=n&&y<=m&&x>0&&y>0) {
					
					if(map[x][y]!=1&&cmap[p.x][p.y]+1<=cmap[x][y]) {
						cmap[x][y]=cmap[p.x][p.y]+1;
						q.add(new point(x,y));
						s.push(new point(x,y));
					}
					}
					
				}
			
				
				
				
			}
			if(!ct) {
				while(!s.isEmpty()) {
					point pt=(point)s.pop();
					cmap[pt.x][pt.y]=999999;	
				}
			}
				
			map[brk.x][brk.y]=1;
			
			
		}
		
	/*	for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				System.out.printf("%d ", cmap[i][j]);
			}System.out.println("");
		}*/
		
		
		
		if(can) {
			System.out.println(cmap[n][m]);
		}else {
			System.out.println(-1);
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