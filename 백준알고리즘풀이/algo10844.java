package algo;
import java.util.*;
public class algo10844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		
		long dp[][]=new long[n+1][10];
		
		for(int i=1;i<=9;i++)dp[1][i]=1;
		
		
		if(n>=2) {
			dp[2][0]=1;
			dp[2][1]=1;
			dp[2][9]=1;
			for(int i=2;i<=8;i++) {
				dp[2][i]=dp[1][i-1]+dp[1][i+1];
			}
		
		}
		
		
		if(n>=3) {
			
			for(int i=3;i<=n;i++) {
				dp[i][0]=dp[i-1][1];
				dp[i][9]=dp[i-1][8];
				
				
				for(int j=1;j<=8;j++) {
					dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1];
					dp[i][j]%=1000000000;
				}
				
				
				
			}
			
			
			
			
		}
		long sum=0;
		
		for(int i=0;i<=9;i++) {
			
			sum+=dp[n][i];
			sum%=1000000000;
			
		}
		System.out.println(sum%1000000000);
		
		
	}

}
