package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);

        int[][] map = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        for (int i=1;i<=n;i++){
            str = br.readLine().split("");
            for(int j=1;j<=m;j++){
                map[i][j] = Integer.parseInt(str[j-1]);
            }
        }

        int max = 0;

        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){

                if (map[i][j]==1) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j])+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
//        for (int i=0;i<=n;i++){
//            for (int j=0;j<=m;j++){
//                System.out.print(dp[i][j]+" ");
//            }System.out.println();
//        }

        System.out.print(max*max);

    }
}
/*
    대각, 위, 옆중에 가장 작은값에서 +1
    만약 0이있으면 1또는 0 이되면서 올바른 값을 뽑아낼수있다.

 */