package 프로그래머스;

import java.util.Arrays;

public class 합승택시요금 {
    static int dp[][];
    public static void main(String[] args) {
        int n=6;
        int s = 4;
        int a = 5;
        int b = 6;
        int fares[][] = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};

        dp=new int[n+1][n+1];
        for (int i=1;i<=n;i++) Arrays.fill(dp[i],100001);

        for (int i=0;i<fares.length;i++){
            dp[fares[i][0]][fares[i][1]]=fares[i][2];
            dp[fares[i][1]][fares[i][0]]=fares[i][2];
        }
        for (int k=1;k<=n;k++){
            for (int j=1;j<=n;j++){
                for (int i=1;i<=n;i++){
                    if (i!=j)
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }
        for (int i=1;i<=n;i++){
           dp[i][i] = 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i=1;i<=n;i++){
            int sum = dp[s][i];
            sum+=dp[i][a]+dp[i][b];
            min=Math.min(min,sum);
        }

    }
}
