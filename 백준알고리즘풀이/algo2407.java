package 백준;

import java.math.BigInteger;
import java.util.Scanner;

public class algo2407 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();

        BigInteger[][] dp=new BigInteger[101][101];

        for (int i=0;i<=100;i++){
            for (int j=0;j<=100;j++){
                dp[i][j]=new BigInteger("0");
            }
        }

        for (int i=0;i<=100;i++){
            dp[i][0]= BigInteger.valueOf(1);
            dp[i][i]= BigInteger.valueOf(1);
        }

        for (int i=1;i<=100;i++){
            for (int j=1;j<=i;j++){
                dp[i][j]=dp[i-1][j].add(dp[i-1][j-1]);
            }
        }
        System.out.println(dp[n][m]);
    }
}
