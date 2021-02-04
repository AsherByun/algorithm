package algo;
import java.util.*;
public class algo11048 {
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int m=scan.nextInt();
		
		int map[][]=new int[n+1][m+1];
		int dp[][]=new int[n+1][m+1];
		
		
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				map[i][j]=scan.nextInt();
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				int a=-100000;
				int b=-100000;
				int c=-100000;
				int d=-100000;
				if(j-2>=0) {
					a=dp[i][j-2]+map[i][j-1];
				}
				if(i-2>=0) {
					b=dp[i-2][j]+map[i-1][j];
				}
					c=dp[i-1][j-1]+map[i][j-1];
					d=dp[i-1][j-1]+map[i-1][j];
					
					dp[i][j]=map[i][j]+Math.max(Math.max(a, b),Math.max(c, d));
				
			}
		}
		
		
		
		
		System.out.println(dp[n][m]);
		
		
	}

}
