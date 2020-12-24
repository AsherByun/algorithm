package algo;
import java.util.*;
public class algo2579_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n=scan.nextInt();
		
		int a[]=new int[n+1];
		int dp[]=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			a[i]=scan.nextInt();
		}
		
		if(n>=1) {
			dp[1]=a[1];
		}
		if(n>=2) {
			dp[2]=a[1]+a[2];
		}
		
		
		for(int i=3;i<=n;i++) {
			dp[i]=Math.max(dp[i-2]+a[i],dp[i-3]+a[i-1]+a[i]);
		}
		
		
		System.out.println(dp[n]);
	}

}
