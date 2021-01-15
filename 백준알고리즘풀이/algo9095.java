package algo;
import java.util.*;
public class algo9095 {
	static int[] a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList res = new ArrayList();
		Scanner scan =new Scanner(System.in);
		
		int dp[]=new int[12];
		int tc=scan.nextInt();
		dp[1]=1;dp[2]=2;dp[3]=4;
		
		for(int i=4;i<=11;i++) {
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
		
		for(int i=0;i<tc;i++) {
			
			int n=scan.nextInt();
			
			res.add(dp[n]);
			
			
		}
		for(int i=0;i<res.size();i++)
		 System.out.println(res.get(i));
		
	}
	
	
	
	
	
	

}
