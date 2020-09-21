package algo;
import java.util.*;
public class algo1699 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		
		
		int[] dp = new int[n+1];
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = i;
			for(int j = 1; j*j <= i; j++)
				dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
		}
		
		System.out.println(dp[n]);
		
	/*	long s=0;
		for(int i=1;i<=100000;i++) {
			dp[i]=(int)Math.sqrt(i);
		}*/
		
		
		
		
		
		
		//System.out.println(dp[100]);
	}

}
