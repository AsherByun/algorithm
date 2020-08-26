package algo;
import java.util.*;
public class algo1004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		ArrayList res=new ArrayList();
		int testc=scan.nextInt();
		
		for(int tc=0;tc<testc;tc++) {
			int sx=scan.nextInt();
			int sy=scan.nextInt();
			int ex=scan.nextInt();
			int ey=scan.nextInt();
			int n=scan.nextInt();
			
			ArrayList p=new ArrayList();
			for(int i=0;i<n;i++) {
				int t1=scan.nextInt();
				int t2=scan.nextInt();
				int t3=scan.nextInt();
				
				p.add(new round(t1,t2,t3));				
			}
			
			boolean visit[]=new boolean[n];
			ArrayList sa=new ArrayList();
			
			for(int i=0;i<p.size();i++) {
				round r=(round)p.get(i);
				if(Math.sqrt(Math.pow(sx-r.x, 2)+Math.pow(sy-r.y, 2))<r.r) {
					visit[i]=true;sa.add(i);
				}
			}
			int tot=0;
			for(int i=0;i<p.size();i++) {
				round r=(round)p.get(i);
				if(Math.sqrt(Math.pow(ex-r.x, 2)+Math.pow(ey-r.y, 2))<r.r) {
					if(visit[i]) {
						sa.remove((Integer)i);
					}else {
						tot++;
					}
				}
				
			}
			
			tot+=sa.size();
			
			res.add(tot);
		}
		for(int i=0;i<res.size();i++)System.out.println(res.get(i));
		
		
	}

}
class round{
	int x;
	int y;
	int r;
	round(int x,int y,int r){
		this.x=x;
		this.y=y;
		this.r=r;
	}
	
	
	
	
}