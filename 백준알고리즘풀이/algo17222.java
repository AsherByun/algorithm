package algo;
import java.util.*;
public class algo17222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		
		int map[]=new int[n];
		
		for(int i=0;i<n;i++) {
			map[i]=scan.nextInt();
		}
		
		
		int dp[]=new int[n];
		int max=0;
		dp[0]=1;
		for(int i=1;i<n;i++) {
			
			dp[i]=1;
			
			for(int j=0;j<i;j++) {
				
				if(map[j]>map[i]&&dp[i]<=dp[j]) {
					dp[i]=dp[j]+1;
				}else if(map[j]==map[i]) {
					dp[i]=dp[j];
				}
				
			}
			
			
		}
		for(int i=0;i<n;i++)
			max=Math.max(max, dp[i]);
		
		
		System.out.println(max);
	}

}
