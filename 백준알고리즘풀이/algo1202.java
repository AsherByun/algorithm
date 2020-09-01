package algo;
import java.util.*;
public class algo1202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int k=scan.nextInt();
		ArrayList a=new ArrayList();
		ArrayList kw=new ArrayList();
		for(int i=0;i<n;i++) {
			int tw=scan.nextInt();
			int tm=scan.nextInt();
			a.add(new dia(tw,tm));
		}
		
		for(int i=0;i<k;i++) {
			int temp=scan.nextInt();
			kw.add(temp);
		}
		int tot=0;
		Collections.sort(kw);
		Collections.sort(a);
		boolean visit[]=new boolean[10000000];
		for(int i=a.size()-1;i>=0;i--) {
			dia tempd=(dia)a.get(i);
			int w=tempd.w;int m=tempd.m;
			for(int j=0;j<kw.size();j++) {
				int we=(int)kw.get(j);
				if(we>w&&!visit[j]) {
					tot+=m;visit[j]=true;break;
				}
			}
		}
		System.out.println(tot);
		
	}

}
class dia implements Comparable<dia>{
	int w,m;
	dia(int w,int m){
		this.w=w;
		this.m=m;
	}
	@Override
	public int compareTo(dia o) {
		if(this.m>o.m) {
			return 1;
		}else if(this.m==o.m) {
			return 0;
		}else {
			return -1;
		}
	}
	
}