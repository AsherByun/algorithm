package algo;
import java.util.*;
public class algo1660 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int tar=1;
		long tot=0;
		long hap=0;
		long dp[]=new long[300001];
		for(int i=1;i<=300000;i++) {
			tot+=i;
			hap+=tot;
			dp[i]=hap;
			if(hap>n) {
				tar=i-1;
				break;
			}
		}
		long c[]=new long[n+1];
		Arrays.fill(c, 999999);
		c[0]=0;
		for(int i=1;i<=tar;i++) {
			for(int j=(int) dp[i];j<=n;j++) {
				c[j]=Math.min(c[j],c[(int) (j-dp[i])]+1);
			}
		}
		System.out.println(c[n]);
	}

}
