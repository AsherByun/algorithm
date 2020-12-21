package algo;
import java.util.*;
public class algo2292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scan = new Scanner(System.in);
		
		int n=scan.nextInt();
		Boolean t =true;
		int k=1,res=1;
		int f=1,l=1;
		while(t) {
			
		
			l=(int) (3*Math.pow(k-1,2))+3*(k-1) +1; 
			
			if((f<=n)&&(l>=n)) {
				break;
			}
			k++;
			f=l+1;
			
			
		}
		
		
		System.out.println(k);
		
	}

}
