package algo;
import java.util.*;
public class algo9465 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int tc=scan.nextInt();
		
		ArrayList res=new ArrayList();
		
		for(int t=0;t<tc;t++) {
			
			int n=scan.nextInt();
			
			int dp[][]=new int[3][n+1];
			int a[][]=new int[3][n+1];
			
			
			for(int i=1;i<=2;i++) {
				for(int j=1;j<=n;j++) {
					a[i][j]=scan.nextInt();
				}
			}
			
			if(n>=1) {
				dp[1][1]=a[1][1];
				dp[2][1]=a[2][1];
			}
			if(n>=2) {
				dp[1][2]=Math.max(a[2][1]+a[1][2], dp[1][1]);
				dp[2][2]=Math.max(a[1][1]+a[2][2], dp[2][1]);
			}
			
			for(int i=3;i<=n;i++) {
				
				dp[1][i]=Math.max(a[1][i]+dp[2][i-2], dp[2][i-1]+a[1][i]);
				dp[2][i]=Math.max(a[2][i]+dp[1][i-2], dp[1][i-1]+a[2][i]);
				
				
				
				
			}
			
			
			res.add(Math.max(dp[2][n], dp[1][n]));
			
		}
		for(int i=0;i<res.size();i++)
			System.out.println(res.get(i));
		
	}

}
