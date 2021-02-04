package algo;
import java.util.*;
public class algo11052 {
	
	static int n;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		n=scan.nextInt();
		int p[]=new int[n+1];
		int max=0;
		int dp[] = new int[n+1];
		for(int i=1;i<=n;i++) {
			p[i]=scan.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			dp[i]=p[i];
			max=p[i];
			/*for(int j=1;j<=Math.sqrt(i);j++) {
				max=Math.max(dp[i-j]+dp[j], max);
			}*/
			for(int j=1;j<i;j++) {
				max=Math.max(dp[i-j]+dp[j], max);
			}
			dp[i]=max;
		}
		
		System.out.println(max);

	}

}
