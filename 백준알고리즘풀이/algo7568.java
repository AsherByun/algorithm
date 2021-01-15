package algo;
import java.util.*;
public class algo7568 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		pn2 p[]=new pn2[n+1];
		for(int i=1;i<=n;i++) {
			int t1=scan.nextInt();
			int t2=scan.nextInt();
			p[i]=new pn2(t1,t2);
		}
		
		for(int i=1;i<=n;i++) {
			int up=0;
			for(int j=1;j<=n;j++) {
				if(i==j)continue;
				if((p[i].h<p[j].h)&&(p[i].w<p[j].w)) {
					up++;
				}
			}
			p[i].grade=up+1;
		}
		
		for(int i=1;i<=n;i++) {
			System.out.printf("%d ", p[i].grade);
		}
		
	}

}
class pn2{
	int w;
	int h;
	int grade=0;
	pn2(int w,int h){
		this.w=w;
		this.h=h;
	}
}