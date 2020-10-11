package algo;
import java.util.*;
public class algo1965 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan =new Scanner(System.in);
		
		
		int n=scan.nextInt();
		
		int map[]=new int[n+1];
		int dp[]=new int[n+1];
		int max=0;
		for(int i=1;i<=n;i++) {
			map[i]=scan.nextInt();
		}
		dp[1]=1;
		for(int i=1;i<=n;i++) {
			dp[i]=1;
			for(int j=1;j<i;j++) {
				
				if(map[i]>map[j]&&dp[j]+1>dp[i]) {
					dp[i]=dp[j]+1;
				}
				
			}
			if(max<dp[i]) {max=dp[i];}
		}
		
		System.out.println(max);
	}

}
