package algo;
import java.util.*;
public class algo1568 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		
		int s=1;
		int c=0;
		while(true) {
			
			if(n>=s) {
				n-=s;
				
			}
			else {
				s=1;
				n-=1;
			}
			c++;
			s++;
			if(n==0)break;
			
		}
		
		System.out.println(c);
	}

}
