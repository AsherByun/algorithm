package algo;
import java.util.*;
import java.io.*;
public class algo1941_1 {
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static char[][] map;
	static int r=0;
	static boolean can;
	static int tot=0;
	static boolean visit[][];
	static ArrayList a;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		map=new char[5][5];
		
		for(int i=0;i<5;i++) {
			char[] in=br.readLine().toCharArray();
			for(int j=0;j<5;j++) {
				map[i][j]=in[j];
			}
		}
		for(int i=0;i<25;i++) {
			a=new ArrayList();
			can=false;
			a.add(i);
			int x=i/5;
			int y=i%5;
			visit=new boolean[5][5];
			visit[x][y]=true;
			if(map[x][y]=='S') {
			conv(i,1,1,0);
			}
			else {
			conv(i,1,0,1);
			}
			
			
			
		}
		System.out.println(tot);
		
		
	}
	static void conv(int v,int n,int s,int y) {
		
		if(n==7) {
			
			if(s>=4) {
				can=true;
				boolean tv[][]=new boolean[5][5];
				for(int i=0;i<5;i++)tv[i]=visit[i].clone();
				int t=(int)a.get(0);
				int nx=t/5;
				int ny=t%5;
				check(nx,ny,tv);
				boolean ka=false;
				
				for(int i=0;i<5;i++) {
					for(int j=0;j<5;j++) {
						if(tv[i][j])ka=true;
					}
				}
				
				if(!ka)tot++;
				
				
			}else {
				return;
			}
		}
		
		for(int i=v+1;i<25;i++) {
			a.add(i);
			int nx=i/5;
			int ny=i%5;
			visit[nx][ny]=true;
			if(map[nx][ny]=='S') {
			conv(i,n+1,s+1,y);
			}
			else {
			conv(i,n+1,s,y+1);
			}
			visit[nx][ny]=false;
			a.remove((Integer)i);
		}
		
	}
	static void check(int x,int y,boolean tmap[][]) {
		tmap[x][y]=false;
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx>=0&&ny>=0&&ny<=4&&nx<=4) {
				if(tmap[nx][ny]) {
					check(nx,ny,tmap);
				}
			}
			
			
		}
		
	}
	
}
