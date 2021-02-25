package 프로그래머스;

import java.util.Arrays;

public class 거스름돈 {
    public static void main(String[] args) {
        int n=5;
        int[] money = {1,2,5};

        int[] dp =new int[100001];
        dp[0]=1;

        for (int m:money){
            for (int j=m;j<=n;j++){
                dp[j] += dp[j-m];
                dp[j] %= 1000000007;
            }
        }
        System.out.println(dp[n]);
    }
}
