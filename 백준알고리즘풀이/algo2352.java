package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo2352 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());

		
		int dp[][]=new int[n+1][n+1];
		
		String s=br.readLine();
		String[] a=s.split(" ");
		int map[] =new int[a.length+1];
		for(int i=0;i<a.length;i++) {
			map[i+1]=Integer.parseInt(a[i]);
		}
		
		
		for(int i=1;i<=n;i++) {
			
			
			for(int j=1;j<=n;j++) {
				if(map[j]==i) {
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			
		}
		System.out.println(dp[n][n]);
		
		
		
		
	}

}
