package algo;
import java.util.*;
public class algo1463 {
	static int dp[]=new int[1000001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		
		
		
		find(n);
		
		System.out.println(dp[n]);
		
		scan.close();
		
		
		
	}
	
	static int find(int in) {
		
		
		
		if(in==1) {
			return 0;
		}
		
		if(dp[in]>0) {
			return dp[in];
		}

		dp[in]=find(in-1)+1;
		
		if(in%3==0) {
			int temp=find(in/3)+1;
			if(temp<dp[in]) {
				dp[in]=temp;
			}
			
		}
		if(in%2==0) {
			int temp=find(in/2)+1;
			if(temp<dp[in]) {
				dp[in]=temp;
			}
			
		}
		
		return dp[in];
		
	}
	
	

}
