package algo;
import java.util.*;
public class algo2579 {

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
		if(n==3) {
			dp[n]=Math.max(a[1]+a[3],a[2]+a[3]);
		}
		
		else if(n>3) {
			dp[3]=Math.max(dp[2], a[1]+a[3]);
		}
		
		for(int i=4;i<n;i++) {
			dp[i]=Math.max(Math.max(dp[i-1], dp[i-2]+a[i]), Math.max(dp[i-3]+a[i-1]+a[i],dp[i-3]+a[i-1]));
		}
		if(n>3)dp[n]=Math.max(dp[n-2]+a[n], dp[n-3]+a[n-1]+a[n]);
		
		System.out.println(dp[n]);
	}

}
