package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo13398 {
    static int n;
    static int[][] dp;
    static int[] map;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map=new int[n+2];
        dp=new int[n+2][2];


        String str[]=br.readLine().split(" ");

        for (int i=1;i<=n;i++){
            map[i] = Integer.parseInt(str[i-1]);
        }
        max=map[1];
        leftgo(1);
        rightgo(n);
        for (int i=1;i<=n;i++){
            max = Math.max(max,dp[i-1][0]+dp[i+1][1]);
        }
        System.out.println(max);
    }
    static void leftgo(int idx){
        if (idx>n)return;
        dp[idx][0] = Math.max(dp[idx-1][0]+map[idx],map[idx]);
        max=Math.max(max,dp[idx][0]);
        leftgo(idx+1);
    }
    static void rightgo(int idx){
        if (idx<1)return;
        dp[idx][1] = Math.max(dp[idx+1][1]+map[idx],map[idx]);
        max=Math.max(dp[idx][1],max);
        rightgo(idx-1);
    }
}
