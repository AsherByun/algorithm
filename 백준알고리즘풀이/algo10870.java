package algo;
import java.util.*;
public class algo10870 {
	static int res = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int result=0;
		int n = scan.nextInt();
		
		result=go(n);
		System.out.println(result);
		
		
	}
	
	
	
	public static int go(int k) {
		
		if(k==1) {
			return 1;
		}
		if(k==0) {
			return 0;
		}
		
		else {
			res= go(k-1)+go(k-2);
			return res;
		}
		
	}
	
	

}
