package 백준;

import java.util.Scanner;

public class algo2225 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int[][] dp = new int[k+1][n+1];

        for (int i=0;i<=k;i++){
            dp[i][0] = 1;
        }

        for (int i=1;i<=k;i++){
            for (int j=1;j<=n;j++){
               dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000;
            }
        }
        System.out.print(dp[k][n]);
    }
}
/*
    dp[k][n] = dp[k][n-1] + dp[k-1][n] 테이블 형식생각
 */