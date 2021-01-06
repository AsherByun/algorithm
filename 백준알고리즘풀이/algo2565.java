package 백준;

import java.util.Scanner;

public class algo2565 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int cost[] = new int[501];
        int last=0;
        for (int i=1;i<=n;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            cost[s]=e;
            last=Math.max(Math.max(s,e),last);
        }

        int dp[] = new int[501];

        int max=0;
        for (int i=1;i<=last;i++){
            if (cost[i]==0)continue;
            dp[i]=1;
            for (int j=1;j<i;j++){
                if (cost[i]>cost[j]&&dp[i]<dp[j]+1)dp[i]=dp[j]+1;
            }
            max = Math.max(dp[i],max);
        }
        System.out.print(n-max);
    }
}
