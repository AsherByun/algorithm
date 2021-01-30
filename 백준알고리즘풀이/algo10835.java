package algo;
import java.util.*;
public class algo10835 {
	static int n;
	static int[][] dp;
	static int[] l;static int[] r; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		n=scan.nextInt();
		l=new int[n];
		r=new int[n];
		dp=new int[n][n];
		for(int i=0;i<n;i++)l[i]=scan.nextInt();
		for(int i=0;i<n;i++)r[i]=scan.nextInt();
		
		for(int i=0;i<n;i++)Arrays.fill(dp[i], -1);
		
		System.out.println(find(0,0));
		
		
	}
	static int find(int left,int right) {
		if(left==n||right==n)return 0;
		
		if(dp[left][right]!=-1) {
			return dp[left][right];
		}
		dp[left][right]=Math.max(find(left+1,right+1), find(left+1,right));
		
		if(l[left]>r[right]) {
			dp[left][right]=Math.max(dp[left][right], find(left,right+1)+r[right]);
		}
		return dp[left][right];
	}

}
