package algo;
import java.util.*;
public class algo2217_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		
		int dp[]=new int[10001];
		boolean dpt[]=new boolean[10001];
		int max=0;
		for(int i=1;i<=n;i++) {
			
			int temp=scan.nextInt();
			dpt[temp]=true;
			for(int j=1;j<=temp;j++) {
				dp[j]++;
				if(dpt[j]) {
					int t=dp[j]*j;
					if(t>max) {max=t;}
				}
				
			}
			
			
			
		}
		
		System.out.println(max);
		
	}

}
