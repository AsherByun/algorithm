package algo;
import java.util.*;
public class algo2616 {
	static int map[];
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		map=new int[n+1];
		int dp[][]=new int[n+1][4];
		for(int i=1;i<=n;i++) {
			map[i]=scan.nextInt();
		}
		int k=scan.nextInt();
		int tot=0;
		int m1=0;int m2=0;int m3=0;
		for(int i=1;i<k;i++)tot+=map[i];
		
		
		
		for(int i=k;i<=n;i++) {
			tot+=map[i]-map[i-k];
			//1
			dp[i][1]=tot;
			
			//2
			if(dp[i-k][1]!=0)
			dp[i][2]=Math.max(dp[i-k][1]+dp[i][1], m2);
			
			//3
			if(dp[i-k][2]!=0)
			dp[i][3]=dp[i-k][2]+dp[i][1];
			
			if(dp[i][2]>m2)m2=dp[i][2];
			if(m3<dp[i][3])m3=dp[i][3];
			System.out.println(dp[i][1]+"   "+dp[i][2]+"   "+dp[i][3]);
		}
		
		System.out.println(m3);
		
		
		
	}

}
