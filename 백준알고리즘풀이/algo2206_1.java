package algo;
import java.util.*;
import java.io.*;
public class algo2206_1 {

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
			}
		}
		
		boolean can=false;
		cmap[1][1]=0;
		
		int last=999999;
		//ArrayList res=new ArrayList();
		
			
			Queue q=new LinkedList();
			q.add(new pp(1,1,1,0));
			
			while(!q.isEmpty()) {
				
				pp p=(pp)q.poll();
				
				if(p.x==n&&p.y==m) {
						can=true;
						last=p.dis;
						break;
					
				}
				else {
				for(int j=0;j<4;j++) {
					
					int x=p.x+dx[j];
					int y=p.y+dy[j];
					
					
					if(x<=0||y<=0||x>n||y>m)continue;
					
					if(cmap[x][y]<=p.brk)continue;
					
					if(map[x][y]==0) {
						cmap[x][y]=p.brk;
						q.add(new pp(x,y,p.dis+1,p.brk));
					}
					else {
						if(p.brk==0) {
							cmap[x][y]=p.brk+1;
							q.add(new pp(x,y,p.dis+1,p.brk+1));
						}
						
					}
					
					
				}
			
				
				}
				
			
		
			
			
		}
		
		if(can) {
			System.out.println(last);
		}else {
			System.out.println(-1);
	}
		
		
	}

}

class pp {
	int x,y;
	int dis;
	int brk;
	
	pp(int x, int y,int dis,int brk){
		this.x=x;
		this.y=y;
		this.brk=brk;
		this.dis=dis;
	}
	
}