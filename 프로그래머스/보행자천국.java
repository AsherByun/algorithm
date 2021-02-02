package 프로그래머스;

import java.util.Arrays;

public class 보행자천국 {
    static int MOD = 20170805;
    static int n,m;
    static int[][][] dp;
    public static void main(String[] args) {
        m=3;n=6;
        int[][] city = {{0, 2, 0, 0, 0, 2},{0, 0, 2, 0, 1, 0},{1, 0, 0, 2, 2, 0}};

        dp = new int[m+1][n+1][2];
        dp[1][1][0] = dp[1][1][1] =1;

        for (int x=1;x<=m;x++){
            for (int y=1;y<=n;y++){
                if (city[x-1][y-1] == 0){
                    dp[x][y][0] += (dp[x-1][y][0] + dp[x][y-1][1]) % MOD;
                    dp[x][y][1] += (dp[x-1][y][0] + dp[x][y-1][1]) % MOD;
                }else if (city[x-1][y-1] == 1){

                }else{
                    dp[x][y][0] = dp[x-1][y][0];
                    dp[x][y][1] = dp[x][y-1][1];
                }
            }
        }
        System.out.println(dp[m][n][0]);
    }
}
