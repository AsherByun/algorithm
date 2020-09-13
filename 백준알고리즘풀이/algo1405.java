package algo;
import java.util.*;
import java.io.*;
public class algo1405 {
	static int n,m;
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static double per[];
	static double r=0;
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		n=Integer.parseInt(in[0]);
		per=new double[4];
		
		per[0]=Integer.parseInt(in[1])/(double)100;//µ¿ ¼­ ³² ºÏ
		per[1]=Integer.parseInt(in[2])/(double)100;
		per[2]=Integer.parseInt(in[3])/(double)100;
		per[3]=Integer.parseInt(in[4])/(double)100;
	
		
		point p=new point(50,50);
		visit=new boolean[100][100];

		visit[50][50]=true;
		find(0,p,1);
		
		
		
		
		System.out.println(r);
		
	}
	
	static void find(int c,point p,double tot) {
		
		visit[p.x][p.y]=true;
		
		if(c==n) {
			visit[p.x][p.y]=true;
			r+=tot;
			return;
			
		}
		else {
		
		for(int i=0;i<4;i++) {
			
			int x=p.x+dx[i];
			int y=p.y+dy[i];

			if(!visit[x][y]) {
				find(c+1,new point(x,y),tot*per[i]);
				visit[x][y]=false;
			}
			
		}
		
		
		
	}
	
	}
}
class point{
	int x;
	int y;
	
	point(int x,int y){
		this.x=x;
		this.y=y;
	}
}