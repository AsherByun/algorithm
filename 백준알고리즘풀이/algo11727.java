package algo;
import java.util.*;
public class algo11727 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		
		long dp[]=new long[n+1];
		
		dp[1]=1;
		if(n>=2)dp[2]=2;
		
		if(n>=3) {
			for(int i=3;i<=n;i++) {
				dp[i]=dp[i-1]+dp[i-2];
				dp[i]%=10007;
			}
		}
		System.out.println(dp[n]);
		
	}

}
