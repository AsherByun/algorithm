package algo;
import java.util.*;
public class algo1010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		
		int tc=scan.nextInt();
		
		ArrayList res=new ArrayList();
		long dp[][]=new long[31][31];
		
		for(int i=1;i<=30;i++) {
			dp[1][i]=i;
			dp[i][i]=1;
		}
		for(int i=2;i<=30;i++) {
			
			for(int j=i;j<=30;j++) {
				
				dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
			}
			
			
		}
		
		
		
		
		
		for(int t=0;t<tc;t++) {
			
			int n=scan.nextInt();
			int m=scan.nextInt();
			
			
			res.add(dp[n][m]);
				
				
			}
			
			
			
			
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}
		
		
		
		
	}

}
