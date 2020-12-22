package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo1744 {
    static int n;
    static int[] map;
    static int[] dp;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n];
        dp = new int[n];
        for (int i=0;i<n;i++)map[i]=Integer.parseInt(br.readLine());
        max =Integer.MIN_VALUE;
        Arrays.sort(map);
        dp[0]=map[0];
        if (n>1)dp[1]=Math.max(map[0]+map[1],map[0]*map[1]);

        for (int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-2]+map[i-1]*map[i],dp[i-1]+map[i]);
        }

        System.out.println(dp[n-1]);
    }

}
