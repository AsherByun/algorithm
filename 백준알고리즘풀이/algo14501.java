package algo;
import java.util.*;
public class algo14501 {
	static int n;
	static ArrayList all = new ArrayList();
	static int day[];
	static int pay[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		day=new int[30];
		pay=new int[30];
		
		for(int i=1;i<=n;i++) {
			day[i]=scan.nextInt();
			pay[i]=scan.nextInt();
		}
		int dp[]=new int[30];
		int max=0;
		for(int i=1;i<=n+1;i++) {
			dp[i]=Math.max(dp[i], max);
			
			dp[day[i]+i]=Math.max(dp[day[i]+i], pay[i]+dp[i]);
			max=Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	}

}


