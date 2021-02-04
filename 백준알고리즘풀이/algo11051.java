package algo;
import java.util.*;
public class algo11051 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int k=scan.nextInt();
		
		int dp[][]=new int[n+1][n+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=i;j++) {
				if(i==j||j==0) {
					dp[i][j]=1;
				}else {
					dp[i][j]=(dp[i-1][j]+dp[i-1][j-1])%10007;
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}

}
