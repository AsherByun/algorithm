package algo;
import java.util.*;
public class algo1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		
		
		int a[][]=new int[n+1][3];     // 0R  1G  2B
		int dp[][]=new int[n+1][3];
		
		for(int i=1;i<=n;i++) {
			int r=scan.nextInt();int g=scan.nextInt();int b=scan.nextInt();
			a[i][0]=r;a[i][1]=g;a[i][2]=b;
			
			if(i==1) {
				dp[1][0]=a[1][0];dp[1][1]=a[1][1];dp[1][2]=a[1][2];
			}
			
			else{
				
				dp[i][0]=a[i][0]+Math.min(dp[i-1][1], dp[i-1][2]);
				dp[i][1]=a[i][1]+Math.min(dp[i-1][0], dp[i-1][2]);
				dp[i][2]=a[i][2]+Math.min(dp[i-1][1], dp[i-1][0]);
				
			}
			
			
			
			
		}
		System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]),dp[n][2]));
	
		
		
		
		
		
	}

}
