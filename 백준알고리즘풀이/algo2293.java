package algo;
import java.util.*;
public class algo2293 {
	static int n,k;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		n=scan.nextInt();
		k=scan.nextInt();
		int arr[] = new int[n+1];
		int dp[]=new int[k+101];
		for(int i=1;i<=n;i++) {
			arr[i]=scan.nextInt();
		}
		dp[0]=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				if(j>=arr[i]) {
					dp[j]=dp[j]+dp[j-arr[i]];
				}
			}
		}
		System.out.println(dp[k]);
		
		
	}

}
