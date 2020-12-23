package algo;
import java.util.*;
import java.io.*;
import java.awt.*;
public class algo2412_1 {
	static int n,h;
	static int min=Integer.MAX_VALUE-1;
	static ArrayList harr=new ArrayList();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		bfs();
		hom hhp=new hom(1,2);
		System.out.println((min==Integer.MAX_VALUE-1)?-1:min);
	}
	static void bfs() {
		Queue hq=new LinkedList();
		hq.add(new hom(0,0));
		
		while(!hq.isEmpty()) {
			hom nowh=(hom)hq.poll();
			if(nowh.y==h) {
				min=Math.min(min, nowh.d);
				continue;
			}
			
			for(int i=-2;i<=2;i++) {
				for(int j=-2;j<=2;j++) {
					if(i<=0&&j<=0)continue;

				}
			}
		}
		
	}
	
	static void input() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		n=Integer.parseInt(str[0]);h=Integer.parseInt(str[1]);
		for(int i=0;i<n;i++) {
			str=br.readLine().split(" ");
			int x=Integer.parseInt(str[0]);int y=Integer.parseInt(str[1]);
			hom tmph=new hom(x,y);
			tmph.d=Integer.MAX_VALUE-1;
			harr.add(tmph);
		}
	}
}
class hom extends Point implements Comparable<hom>{
	int x,y;
	int d=0;
	hom(int x,int y){
		this.x=x;this.y=y;
	}
	@Override
	public int compareTo(hom o) {
		if(this.y>o.y)return 1;
		else if(this.y<o.y)return -1;
		else {
			if(this.x>o.x)return 1;
			else if(this.x<o.x)return -1;
			else return 0;
		}
	}
	
}


//for(int i=0;i<harr.size();i++) {
//	hom h=(hom)harr.get(i);
//	System.out.println(h.x+"  "+h.y);
//}