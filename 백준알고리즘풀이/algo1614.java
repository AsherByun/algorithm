package algo;
import java.util.*;
public class algo1614 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		long n=scan.nextInt();
		long k=scan.nextInt();
		
		
		if(n==1&&k==0) {
			System.out.println(0);
			return;
		}
		long tot=0;
		if(n==1) {
			int up=8;
			tot=1;
			for(int i=1;i<=k;i++) {
				tot+=up;
			}
			System.out.println(tot-1);
		}else if(n==2) {
			long up[]= {6,2};
			
			tot=2;
			for(int i=0;i<k;i++) {
				tot+=up[i%2];
			}
			System.out.println(tot-1);
			
			
		}else if(n==3) {
			long up=4;
			
			tot=3;
			for(int i=0;i<k;i++) {
				tot+=up;
			}
			System.out.println(tot-1);
			
		}else if(n==4) {
			long up[]= {2,6};
			tot=4;
			for(int i=0;i<k;i++) {
				tot+=up[i%2];
			}
			System.out.println(tot-1);
			
		}else if(n==5) {
			long up=8;
			
			tot=5;
			for(int i=0;i<k;i++) {
				tot+=up;
			}
			System.out.println(tot-1);
			
		}
		
		
		
		
	}

}
