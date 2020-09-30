package algo;
import java.util.*;
public class algo1912 {
	//Áß¿ä!
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan =new Scanner(System.in);
		int n=scan.nextInt();
		int arr[]=new int[n+1];
		int dp[]=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i]=scan.nextInt();
		}
		int max=-99999;
		for(int i=1;i<=n;i++) {
			if(dp[i-1]+arr[i]>arr[i]) {
				dp[i]=dp[i-1]+arr[i];
			}else {
				dp[i]=arr[i];
			}
			if(dp[i]>max) {
				max=dp[i];
			}
		}
		
		System.out.println(max);
		

	}

}
