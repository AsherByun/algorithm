package algo;
import java.util.*;
public class algo9461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int tc=scan.nextInt();
		
		long dp[]=new long[101];
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;
		dp[6]=3;
		ArrayList res=new ArrayList();
		
		for(int i=0;i<tc;i++) {
			
			int n=scan.nextInt();
			
			if(n>=7) {
				for(int j=7;j<=n;j++) {
					
					dp[j]=dp[j-3]+dp[j-2];
					
				}
			}
			
			
			res.add(dp[n]);
			
		}
		
		for(int i=0;i<res.size();i++)
			System.out.println(res.get(i));
		
	}

}
