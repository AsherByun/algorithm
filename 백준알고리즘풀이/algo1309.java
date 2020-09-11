package algo;
import java.util.*;
public class algo1309 {
	static int map[][];
	static int dp[][];
	static int n;
	static int tot=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		
	
		dp=new int[n+1][3];
		dp[1][0]=1;dp[1][1]=1;dp[1][2]=1;
		for(int i=2;i<=n;i++) {
			dp[i][2]=dp[i-1][2]+dp[i-1][0]+dp[i-1][1];
			dp[i][1]=dp[i-1][0]+dp[i-1][2];
			dp[i][0]=dp[i-1][1]+dp[i-1][2];
			dp[i][2]%=9901;dp[i][1]%=9901;dp[i][0]%=9901;
		}
		
		System.out.println((dp[n][0]+dp[n][1]+dp[n][2])%9901);
	}

}