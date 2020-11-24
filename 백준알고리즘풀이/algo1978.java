package algo;
import java.util.*;


public class algo1978 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int testnum=scan.nextInt();
		int res=0;
		int n;
		
		
		for(int i =0;i<testnum;i++) {
			n=scan.nextInt();
			if(n==1) {res++;continue;}
			for(int j=2;j<n;j++) {
				if(n%j==0) {
					res++;
					break;
				}
			}
			
			
			
		}
		res=testnum-res;
		System.out.println(res);
		
		
		
		
	}

}
