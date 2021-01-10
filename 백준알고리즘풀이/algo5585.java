package algo;
import java.util.*;
public class algo5585 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		int cost=1000-t;
		int count=0;
		

			if(cost>=500) {
				int k=cost/500;
				cost-=k*500;
				count+=k;
			}if(cost>=100) {
				int k=cost/100;
				cost-=k*100;
				count+=k;
			}if(cost>=50) {
				int k=cost/50;
				cost-=k*50;
				count+=k;
			}if(cost>=10) {
				int k=cost/10;
				cost-=k*10;
				count+=k;
			}if(cost>=5) {
				int k=cost/5;
				cost-=k*5;
				count+=k;
			}if(cost>=1) {
				int k=cost/1;
				cost-=k*1;
				count+=k;
			}
			
			
			System.out.println(count);
			
		
		
		
		
	}

}
