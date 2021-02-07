package algo;
import java.util.*;
public class algo11726 {
	static int n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		int dp[] = new int[1001];
		dp[1]=1;dp[2]=2;
		if(n>=3) {
		for(int i=3;i<=n;i++) {
			
			dp[i]=(dp[i-1]+dp[i-2])%10007;
			
		}
		
		
		}
		
		System.out.println(dp[n]);
	}

}
