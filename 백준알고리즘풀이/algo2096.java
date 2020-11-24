package algo;
import java.util.*;
public class algo2096 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		
		int map[][]=new int[n][3];
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
				map[i][j]=scan.nextInt();
			}
		}
		
		
		int dp[][]=new int[n][3];
		dp[0][0]=map[0][0];dp[0][1]=map[0][1];dp[0][2]=map[0][2];
		int mdp[][]=new int[n][3];
		mdp[0][0]=map[0][0];mdp[0][1]=map[0][1];mdp[0][2]=map[0][2];
		for(int i=1;i<n;i++) {
			mdp[i][0]=Math.min(mdp[i-1][0]+map[i][0], mdp[i-1][1]+map[i][0]);
			mdp[i][1]=Math.min(mdp[i-1][0]+map[i][1], Math.min(mdp[i-1][1]+map[i][1], mdp[i-1][2]+map[i][1]));
			mdp[i][2]=Math.min(mdp[i-1][1]+map[i][2], mdp[i-1][2]+map[i][2]);
					
			dp[i][0]=Math.max(dp[i-1][0]+map[i][0], dp[i-1][1]+map[i][0]);
			dp[i][1]=Math.max(dp[i-1][0]+map[i][1], Math.max(dp[i-1][1]+map[i][1], dp[i-1][2]+map[i][1]));
			dp[i][2]=Math.max(dp[i-1][1]+map[i][2], dp[i-1][2]+map[i][2]);
		}
		int totm=Math.min(mdp[n-1][0], Math.min(mdp[n-1][2], mdp[n-1][1]));
		int tot=Math.max(dp[n-1][0], Math.max(dp[n-1][2], dp[n-1][1]));
		System.out.println(tot+" "+totm);
	}

}
