package algo;
import java.util.*;
public class algo15683 {

	static int map[][];
	static int n,m;
	static boolean visit[][];
	static int min=Integer.MAX_VALUE-1;
	static int d[][];
	static ArrayList cctv=new ArrayList();
	static int len=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		n=scan.nextInt();
		m=scan.nextInt();
		
		map=new int[n+1][m+1];
		visit=new boolean[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				map[i][j]=scan.nextInt();
				if(map[i][j]!=0&&map[i][j]!=6) {
					cctv.add(new cc(i,j,map[i][j]));
				}
				
			}
		}

		len=cctv.size();
		if(len>0) {
		for(int i=0;i<4;i++) {
			
			cc temp=(cc)cctv.get(0);
			temp.d=i;
			dfs(len-1,1);
			
			
		}
		}
		if(min==Integer.MAX_VALUE-1)System.out.println(0);
		else System.out.println(min);
	}
	static void dfs(int c,int num) {
		
		if(c==0) {
			find();
			
		}
		else {
			cc temp=(cc)cctv.get(num);
			for(int i=0;i<4;i++) {
				temp.d=i;
				dfs(c-1,num+1);
			}		
		}
	}
	static void find() {
		
		int t=0;
		int tmap[][]=new int[n+1][m+1];

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				tmap[i][j]=map[i][j];
			}
		}
		
		for(int i=0;i<cctv.size();i++) {
			cc temp=(cc)cctv.get(i);
			int td=temp.d;
			int nm=temp.tp;
			
			if(nm==1) {
				tmap=one(td,tmap,temp);
			}else if(nm==2) {
				tmap=two(td,tmap,temp);
			}else if(nm==3) {
				tmap=thr(td,tmap,temp);
			}else if(nm==4) {
				tmap=four(td,tmap,temp);
			}else if(nm==5) {
				tmap=five(td,tmap,temp);
			}
			
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(tmap[i][j]==0)t++;
			}
		}
		if(t<min)min=t;
		
	}
static int[][] four(int di,int tmap[][],cc temp){
		
		int x=temp.x;
		int y=temp.y;
		
		if(di==0) {
			
			for(int i=x;i>=1;i--) {
				if(tmap[i][y]==0) {
					tmap[i][y]=7;
				}else if(tmap[i][y]==6){
					break;
				}
			}
			for(int i=y;i<=m;i++) {
				if(tmap[x][i]==0) {
					tmap[x][i]=7;
				}else if(tmap[x][i]==6){
					break;
				}
			}
			for(int i=y;i>=1;i--) {
				if(tmap[x][i]==0) {
					tmap[x][i]=7;
				}else if(tmap[x][i]==6){
					break;
				}
			}
		}else if(di==1) {
			
			for(int i=y;i<=m;i++) {
				if(tmap[x][i]==0) {
					tmap[x][i]=7;
				}else if(tmap[x][i]==6){
					break;
				}
			}
			for(int i=x;i<=n;i++) {
				if(tmap[i][y]==0) {
					tmap[i][y]=7;
				}else if(tmap[i][y]==6){
					break;
				}
			}for(int i=x;i>=1;i--) {
				if(tmap[i][y]==0) {
					tmap[i][y]=7;
				}else if(tmap[i][y]==6){
					break;
				}
			}
		}else if(di==2) {
			for(int i=x;i<=n;i++) {
				if(tmap[i][y]==0) {
					tmap[i][y]=7;
				}else if(tmap[i][y]==6){
					break;
				}
			}
			for(int i=y;i>=1;i--) {
				if(tmap[x][i]==0) {
					tmap[x][i]=7;
				}else if(tmap[x][i]==6){
					break;
				}
			}for(int i=y;i<=m;i++) {
				if(tmap[x][i]==0) {
					tmap[x][i]=7;
				}else if(tmap[x][i]==6){
					break;
				}
			}
		}else if(di==3) {
			
			for(int i=y;i>=1;i--) {
				if(tmap[x][i]==0) {
					tmap[x][i]=7;
				}else if(tmap[x][i]==6){
					break;
				}
			}
			for(int i=x;i>=1;i--) {
				if(tmap[i][y]==0) {
					tmap[i][y]=7;
				}else if(tmap[i][y]==6){
					break;
				}
			}for(int i=x;i<=n;i++) {
				if(tmap[i][y]==0) {
					tmap[i][y]=7;
				}else if(tmap[i][y]==6){
					break;
				}
			}
		}
		return tmap;		
}
	static int[][] thr(int di,int tmap[][],cc temp){
		
		int x=temp.x;
		int y=temp.y;
		
		if(di==0) {
			
			for(int i=x;i>=1;i--) {
				if(tmap[i][y]==0) {
					tmap[i][y]=7;
				}else if(tmap[i][y]==6){
					break;
				}
			}
			for(int i=y;i<=m;i++) {
				if(tmap[x][i]==0) {
					tmap[x][i]=7;
				}else if(tmap[x][i]==6){
					break;
				}
			}
				
		}else if(di==1) {
			
			for(int i=y;i<=m;i++) {
				if(tmap[x][i]==0) {
					tmap[x][i]=7;
				}else if(tmap[x][i]==6){
					break;
				}
			}
			for(int i=x;i<=n;i++) {
				if(tmap[i][y]==0) {
					tmap[i][y]=7;
				}else if(tmap[i][y]==6){
					break;
				}
			}
		}else if(di==2) {
			for(int i=x;i<=n;i++) {
				if(tmap[i][y]==0) {
					tmap[i][y]=7;
				}else if(tmap[i][y]==6){
					break;
				}
			}
			for(int i=y;i>=1;i--) {
				if(tmap[x][i]==0) {
					tmap[x][i]=7;
				}else if(tmap[x][i]==6){
					break;
				}
			}
		}else if(di==3) {
			
			for(int i=y;i>=1;i--) {
				if(tmap[x][i]==0) {
					tmap[x][i]=7;
				}else if(tmap[x][i]==6){
					break;
				}
			}
			for(int i=x;i>=1;i--) {
				if(tmap[i][y]==0) {
					tmap[i][y]=7;
				}else if(tmap[i][y]==6){
					break;
				}
			}
		}
		return tmap;
		
}
		
	static int[][] two(int di,int tmap[][],cc temp){
		
		int x=temp.x;
		int y=temp.y;
		
		if(di==0||di==2) {
			
			for(int i=x;i<=n;i++) {
				if(tmap[i][y]==0)tmap[i][y]=7;
				else if(tmap[i][y]==6)break;
			}
			for(int i=x;i>=1;i--) {
				
				if(tmap[i][y]==0)tmap[i][y]=7;
				else if(tmap[i][y]==6)break;
			}
			
		}else if(di==1||di==3) {
			
			for(int i=y;i<=m;i++) {
				if(tmap[x][i]==0)tmap[x][i]=7;
				else if(tmap[x][i]==6)break;
			}
			for(int i=y;i>=1;i--) {
				if(tmap[x][i]==0)tmap[x][i]=7;
				else if(tmap[x][i]==6)break;
			}	
		}
		return tmap;
	}
	static int[][] five(int di,int tmap[][],cc temp){
		int x=temp.x;
		int y=temp.y;
		
		for(int i=x;i>=1;i--) {
			if(tmap[i][y]==0) {
				tmap[i][y]=7;
			}else if(tmap[i][y]==6){
				break;
			}
		}

		for(int i=y;i<=m;i++) {
			if(tmap[x][i]==0) {
				tmap[x][i]=7;
			}else if(tmap[x][i]==6){
				break;
			}
		}
		for(int i=x;i<=n;i++) {
			if(tmap[i][y]==0) {
				tmap[i][y]=7;
			}else if(tmap[i][y]==6){
				break;
			}
		}
		for(int i=y;i>=1;i--) {
			if(tmap[x][i]==0) {
				tmap[x][i]=7;
			}else if(tmap[x][i]==6){
				break;
			}
		}
		
		return tmap;
	}
	static int[][] one(int di,int tmap[][],cc temp){
		int x=temp.x;
		int y=temp.y;
		
		if(di==0) {
			
			for(int i=x;i>=1;i--) {
				if(tmap[i][y]==0) {
					tmap[i][y]=7;
				}else if(tmap[i][y]==6){
					break;
				}
			}
				
		}else if(di==1) {
			
			for(int i=y;i<=m;i++) {
				if(tmap[x][i]==0) {
					tmap[x][i]=7;
				}else if(tmap[x][i]==6){
					break;
				}
			}
			
		}else if(di==2) {
			for(int i=x;i<=n;i++) {
				if(tmap[i][y]==0) {
					tmap[i][y]=7;
				}else if(tmap[i][y]==6){
					break;
				}
			}
			
		}else if(di==3) {
			
			for(int i=y;i>=1;i--) {
				if(tmap[x][i]==0) {
					tmap[x][i]=7;
				}else if(tmap[x][i]==6){
					break;
				}
			}
			
		}
		
		return tmap;
	}

}
class cc {
	int x,y;
	int d=0;
	int tp=0;
	
	cc(int x, int y,int tp){
		this.x=x;
		this.y=y;
		this.tp=tp;
	}
	
}
