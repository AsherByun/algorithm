package algo;
import java.util.*;
import java.io.*;
public class algo11559 {
	
	static char map[][];
	static int n,m;
	static boolean visit[][];
	static boolean cant;
	static int c=0;
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static ArrayList bk;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		map=new char[13][7];
		
		for(int i=1;i<=12;i++) {
			String in=br.readLine();
			for(int j=1;j<=6;j++) {
				map[i][j]=in.charAt(j-1);
			}
		}
		
		
		while(true) {
					
			visit=new boolean[13][7];
			boolean a=false;
			
			for(int i=1;i<=12;i++) {
				for(int j=1;j<=6;j++) {
					
					if(map[i][j]!='.'&&!visit[i][j]) {
						bk=new ArrayList();
						point p=new point(i,j);
						bk.add(p);
						visit[i][j]=true;
						
						find(map[i][j],p);
						
						if(bk.size()>=4) {
						cleaning();
						a=true;
						}
					}
					
				}
			}
			
			
			
			if(!a)break;
			
			
			c++;
			
			
			mapchange();
			
			
			
			
		}
		
		
		
		
		System.out.println(c);
		
		
	}
	
	static void mapchange() {
		
		Stack row=new Stack();
		
		
		for(int i=1;i<=6;i++) {
			for(int j=1;j<=12;j++) {
				if(map[j][i]!='.')row.push(map[j][i]);
				map[j][i]='.';
			}
			int t=12;
			while(!row.isEmpty())
			{
				char temp=(char)row.pop();
				map[t][i]=temp;
				t--;
			}
		
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	static void find (char k,point p) {
		
		
		for(int i=0;i<4;i++) {
			
			int x=dx[i]+p.x;
			int y=dy[i]+p.y;
			
			if(x>0&&y>0&&x<=12&&y<=6) {
			if(k==map[x][y]&&!visit[x][y]) {
				point pt=new point(x,y);
				visit[x][y]=true;
				bk.add(pt);
				find(k,pt);
			}
			
			}
		}
		
		
		
		
	}
	static void cleaning() {
		
		for(int i=0;i<bk.size();i++) {
			point p=(point)bk.get(i);
			map[p.x][p.y]='.';
			
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