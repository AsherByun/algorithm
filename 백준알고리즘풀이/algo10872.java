package algo;
import java.util.*;


public class algo10872 {
	static int mul=0;
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		int n;
		int result=0;
		n=scan.nextInt();
		mul=n;
		
		result=go(n);
		System.out.println(result);
		
		
		
		

	}
	
	
	public static int go(int k) {
		

		
		if(k<=1) {return 1;}
		else {
			mul=k*go(k-1);
				return mul;
			}
			
		
		
		
	
	}

}
