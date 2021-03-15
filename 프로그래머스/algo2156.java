package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int[] dp = new int[n];
        int[] cost = new int[n];
        for (int i=0;i<n;i++)cost[i]=Integer.parseInt(br.readLine());

        if (n<=1){
            System.out.println(cost[0]);
            return;
        }else if (n<=2){
            System.out.println(cost[0]+cost[1]);
            return;
        }else if (n<=3){
            System.out.println(Math.max(cost[0]+cost[2],Math.max(cost[0]+cost[1],cost[1]+cost[2])));
            return;
        }
        dp[0]=cost[0];
        dp[1]=cost[0]+cost[1];
        dp[2]=Math.max(cost[0]+cost[2],Math.max(cost[0]+cost[1],cost[1]+cost[2]));

        for (int i=3;i<n;i++){
            dp[i]=Math.max(dp[i-2]+cost[i],Math.max(dp[i-3]+cost[i-1]+cost[i],dp[i-1]));
        }
        System.out.println(dp[n-1]);
    }
}
