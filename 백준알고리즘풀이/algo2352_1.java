package algo;
import java.util.*;
public class algo2352_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int len=1;
		int map[]=new int[n];
		
		
		
		for(int i=0;i<n;i++) {
			map[i]=scan.nextInt();
		}
		
		int dp[]=new int[n];
		int temp=0;
		dp[0]=map[0];
		for(int i=1;i<n;i++) {
			
			if(map[i]>dp[len-1]) {
				dp[len++]=map[i];
			}else if(map[i]<dp[0]) {
				dp[0]=map[i];
			}else {
				temp=Arrays.binarySearch(dp, 0, len-1, map[i]);
				dp[temp<0?-temp-1:temp]=map[i];
			}
			
		}
		System.out.println(len);
		
	}

}
