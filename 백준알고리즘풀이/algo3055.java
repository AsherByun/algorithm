package algo;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class algo3055 {
	static char map[][];
	static int n;
	static int m;
	static int dx[]={0,-1,0,1};
	static int dy[]={-1,0,1,0};
	static int count = 999999;
	static boolean finish=false;
	//static boolean visit[][];
	static boolean v[][];
	static ArrayList wx = new ArrayList();
	static ArrayList wy = new ArrayList();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n=Integer.parseInt(str[0]);
		m=Integer.parseInt(str[1]);
		v=new boolean[n+1][m+1];
		map=new char[n+1][m+1];
		//visit=new boolean[n+1][m+1];
		int sx=0;int sy=0;
		
		for(int i=1;i<=n;i++) {
			str=br.readLine().split("");
			for(int j=1;j<=m;j++) {
				map[i][j]=str[j-1].charAt(0);
				if(map[i][j]=='S') {
					sx=i;sy=j;
				}else if(map[i][j]=='*') {
					wx.add(i);wy.add(j);
				}
			}
		}
		int c=0;
		v[sx][sy]=true;
		water();
		find(c,sx,sy);
		
		if(finish) {
		System.out.println(count);
		}else {
			System.out.println("KAKTUS");
		}
	
		
	}
	
	static void find(int c,int x,int y) {
		c++;
		
		
		
		for(int i=0;i<4;i++) {
			int tx=x+dx[i];
			int ty=y+dy[i];
			if(tx>0&&ty>0&&tx<=n&&ty<=m) {
				if(map[tx][ty]=='D') {
					finish=true;
					if(c<count) {count=c;}
				}else if(map[tx][ty]=='.'&&!v[tx][ty]) {
					water();
					map[tx][ty]='S';
					v[tx][ty]=true;
					find(c,tx,ty);
					map[tx][ty]='.';
					v[tx][ty]=false;
				}
				
			}
			
		}
		
		
		
		
	}
	static void water() {
		int size=wx.size();
		for(int i=0;i<size;i++) {
			int x=(int)wx.get(i);
			int y=(int)wy.get(i);
			
			for(int k=0;k<4;k++) {
				int tx=x+dx[k];
				int ty=y+dy[k];
				if(tx>0&&ty>0&&tx<=n&&ty<=m) {
				if(map[tx][ty]=='.') {
					map[tx][ty]='*';
					wx.add(tx);wy.add(ty);
				}
			}
			
		}
			
		}
		
		
	}
	
	
	
	
}
	/*static void water() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]=='*'&&!visit[i][j]) {
					visit[i][j]=true;
					for(int k=0;k<4;k++) {
						int tx=i+dx[k];
						int ty=j+dy[k];
						if(tx>0&&ty>0&&tx<=n&&ty<=m) {
						if(map[tx][ty]=='.') {
							map[tx][ty]='*';
							visit[tx][ty]=true;
						}
					}
					
				}
			}
		}
	}
		//for(int i=1;i<=n;i++) {
			//for(int j=1;j<=m;j++) {
				//visit[i][j]=false;
			//}
		//}
	}*/
	
	
	/*static void water() {
		Stack xs = new Stack();
		Stack ys = new Stack();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]=='*') {
					xs.push(i);
					ys.push(j);
				}
			}
		}
		
		while(!ys.isEmpty()) {
			int x=(int)xs.pop();
			int y=(int)ys.pop();
		for(int i=0;i<4;i++) {
			int tx=x+dx[i];
			int ty=y+dy[i];
			if(tx>0&&ty>0&&tx<=n&&ty<=m) {
			if(map[tx][ty]=='.') {
				map[tx][ty]='*';
			}
		}
			
		}
		}
		
	}*/
	
