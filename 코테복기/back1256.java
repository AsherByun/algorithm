package 코테복기;

import java.math.BigInteger;
import java.util.Scanner;

public class back1256 {
    static long[][] dp;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int n=scan.nextInt();
        int m=scan.nextInt();
        long k=scan.nextLong();

        dp=new long[n+m+1][n+m+1];
        for (int i=1;i<n+m+1;i++){
            dp[i][i]=1;
            dp[i][0]=1;
            for (int j=i-1;j>0;j--){
                dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
            }
        }
        System.out.println(find(n,m,k));
    }
    static String find(int n,int m,long k){
        String rs="";

        if (n==0){
            while (m-->0){
                rs+="z";
            }
            return rs;
        }else if (m==0){
            while (n-->0){
                rs+="a";
            }
            return rs;
        }

        if (dp[n+m-1][n-1]<k){
            return "z"+find(n,m-1,k-dp[n+m-1][n-1]);
        }else{
            return "a"+find(n-1,m,k);
        }

    }
}
