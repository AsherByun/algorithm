package 백준;

import java.io.BufferedReader;
import java.util.Scanner;

public class algo4811 {
    static long[][] dp;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        dp =new long[31][31];
        find(30,30);
        StringBuilder sb=new StringBuilder();
        while (true){
            int n=scan.nextInt();
            if (n==0)break;
            sb.append(dp[n][n]+"\n");
        }
        System.out.print(sb.toString());
    }
    static long find(int w,int h){
        if (dp[w][h]!=0)return dp[w][h];

        if (w==0){
            return dp[w][h]=1;
        }
        if (h-1>=w){
            dp[w][h]+=find(w,h-1);
        }
        dp[w][h]+=find(w-1,h);
        return dp[w][h];
    }
}
