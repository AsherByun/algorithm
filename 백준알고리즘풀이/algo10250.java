package algo;
import java.util.*;


public class algo10250 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int h,w,n;
		int testcase=scan.nextInt();
		int f,l,rn;

		ArrayList res = new ArrayList();
		for(int i=0;i<testcase;i++) {
			
			h=scan.nextInt();
			w=scan.nextInt();
			n=scan.nextInt();
			if(n%h==0) {
				f=(n/h);
				l=h;
				rn=h*100+f;
				res.add(rn);
			}
			else{	
			f=(n/h)+1;
			l=n%h;
			rn=l*100+f;
			res.add(rn);
			}
			
			
		}
		
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}
		
		
		
		
		
		
	}

}
