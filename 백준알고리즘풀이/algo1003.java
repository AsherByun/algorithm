package algo;
import java.util.*;
public class algo1003 {
	static int dp[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int tc=scan.nextInt();
		ArrayList res1=new ArrayList();
		ArrayList res0=new ArrayList();
		
		dp=new int[41][2];
		
		dp[0][0]=1;dp[0][1]=0;dp[1][0]=0;dp[1][1]=1;
		
		
		for(int i=1;i<=tc;i++) {
			
			int n=scan.nextInt();
			
			 if(n>=2) {
			dp[n][1]=find1(n-1)+find1(n-2);
			dp[n][0]=find0(n-1)+find0(n-2);
			}
			
			
			
			
			res1.add(dp[n][1]);
			res0.add(dp[n][0]);
			
			
		}
		for(int i=0;i<tc;i++)
		System.out.println(res0.get(i)+" "+res1.get(i));
		
		
		
	}
	
	
	static int find1(int t) {
		
		if(t==0) {
			return 0;
		}
		if(t==1) {
			return 1;
		}
		
		if(dp[t][1]==0) {
		dp[t][1]=find1(t-1)+find1(t-2);
		}
		
		return dp[t][1];
		
	}
	
static int find0(int t) {
		
		if(t==0) {
			return 1;
		}
		if(t==1) {
			return 0;
		}
		
		if(dp[t][0]==0) {
		dp[t][0]=find0(t-1)+find0(t-2);
		}
		
		return dp[t][0];
		
	}
	
	
	
	
	
	
	
}
