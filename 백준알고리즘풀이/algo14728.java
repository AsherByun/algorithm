package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo14728 {
    static int n,k;
    static int[][] dp;
    static int[] score;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] str=br.readLine().split(" ");
        n=Integer.parseInt(str[0]);
        k=Integer.parseInt(str[1]);

        score=new int[n+1];
        time=new int[n+1];

        for (int i=1;i<=n;i++){
            str=br.readLine().split(" ");
            time[i]=Integer.parseInt(str[0]);
            score[i]=Integer.parseInt(str[1]);
        }

        dp=new int[n+1][k+1];

        for(int i=1;i<=n;i++){
            for (int j=0;j<=k;j++){
                if (j-time[i]<0)dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-time[i]]+score[i]);
            }
        }
        System.out.println(dp[n][k]);
    }
}
