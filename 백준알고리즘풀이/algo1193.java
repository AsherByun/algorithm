package algo;
import java.util.*;
public class algo1193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scan =  new Scanner(System.in);
		int n= scan.nextInt();
		int k=1;
		int r=0,l = 0;
		int sum;
		Boolean t=true;
		while(t) {
			
			r=k*(k+1)/2;
			l=(k*(k-1))/2+1 ;
			
			if((l <= n) &&( n <= r)) {
				break;
				
			}
			k++;
			
			
		}
		n=n-l+1;
		
		
		if((k%2)==1) {
			System.out.println((k+1-n)+"/"+n);
			
			
			
		}
		else {
			
			System.out.println(n+"/"+(k+1-n));
			
			
		}
		

	}

}
