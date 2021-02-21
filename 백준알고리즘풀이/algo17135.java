package algo;
import java.util.*;
public class algo17135 {

	static int map[][];
	static int n,m;
	static boolean visit[][];
	static int r;
	static ArrayList ena=new ArrayList();
	static int max=0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		n=scan.nextInt();
		m=scan.nextInt();
		r=scan.nextInt();
		
		map=new int[n+2][m+1];
		
	
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				map[i][j]=scan.nextInt();
				if(map[i][j]==1) {
					point p=new point(i,j);
					ena.add(p);
				}
			}
		}
		
		
		for(int i=1;i<=m;i++) {
			ArrayList a=new ArrayList();
			boolean v[]=new boolean[m+1];
			v[i]=true;
			a.add(i);
			maket(a,2,i,v);
			v[i]=false;
		}
		
		System.out.println(max);
		
		
	}
	
	
	static void maket(ArrayList a,int c,int w,boolean v[]) {
		
		if(c==0) {
			play(a);
		}else {
			for(int i=w+1;i<=m;i++) {
				if(!v[i]) {
					v[i]=true;
					a.add(i);
					maket(a,c-1,i,v);
					a.remove((Integer)i);
					v[i]=false;
				}
				
			}
			
			
		}
		
		
	}
	
	static void play(ArrayList a) {
		
		
		point p[]=new point[3];
		
		for(int i=0;i<a.size();i++) {
			
			int tn=(int)a.get(i);
			point tp=new point(n+1,tn);
			p[i]=new point(tp.x,tp.y);
		}
		
		ArrayList e=new ArrayList();

		for(int i=0;i<ena.size();i++) {
			point pt=(point) ena.get(i);
			e.add(new point(pt.x,pt.y));
		}
		
		
		int tot=0;
		
		if(e.size()>0) {
		while(true) {
			
			point t1=findt(e,p[0]);
			point t2=findt(e,p[1]);
			point t3=findt(e,p[2]);
			
			int tmc=e.size();
			
			
			e.remove((point)t1);
			e.remove((point)t2);
			e.remove((point)t3);
			
			
			int tt=tmc-e.size();
			tot+=tt;
			
			ArrayList at=new ArrayList();
			for(int i=0;i<e.size();i++) {
				point tmp=(point)e.get(i);
				tmp.x++;
				
				if(tmp.x>=n+1) {
					at.add(tmp);
				}
				
			}
			for(int i=0;i<at.size();i++) {
				e.remove((point)at.get(i));
			}
			
			
			
			if(e.size()==0) {
				break;
			}
			
		}
		}
	
		if(tot>max) {
			
			max=tot;
		}
		
		
	}
	
	static point findt(ArrayList e,point pt) {
		
		int tx=pt.x;int ty=pt.y;
		int min=9999999;
		point tar = null;
		int miny=9999999;
		for(int i=0;i<e.size();i++) {
			point pe=(point)e.get(i);
			
			int ga=Math.abs(tx-pe.x)+Math.abs(ty-pe.y);
			if(ga<=r) {
				if(min>ga) {
					min=ga;
					miny=pe.y;
					tar=pe;
				}else if(min==ga) {
					if(pe.y<miny)
						tar=pe;miny=pe.y;
				}
			}
			
			
		}
		
		return tar;
		
		
	}

}



class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
//	point(point p){
//		this.x=p.x;
//		this.y=p.y;
//	}
	
}
