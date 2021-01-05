package 알고리즘문제해결전략.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class JLIS {
    static int[][] dp;
    static int[] a;
    static int[] b;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testc=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int itt=1;itt<=testc;itt++){
            String[] str = br.readLine().split(" ");
            n=Integer.parseInt(str[0]);
            m=Integer.parseInt(str[1]);

            dp = new int[n+1][m+1];
            for (int j=0;j<=n;j++) Arrays.fill(dp[j],-1);

            a=new int[n+1];
            b=new int[m+1];

            str = br.readLine().split(" ");
            for (int i=1;i<=n;i++)a[i]=Integer.parseInt(str[i-1]);
            str = br.readLine().split(" ");
            for (int i=1;i<=m;i++)b[i]=Integer.parseInt(str[i-1]);

            sb.append(jlis(1,1)+"\n");
        }
        System.out.print(sb.toString());
    }
    static int jlis(int idxA,int idxB){
        if (dp[idxA][idxB]!=-1)return dp[idxA][idxB];

        int res = 2;

        int valA = a[idxA];
        int valB = b[idxB];

        int max = Math.max(valA,valB);

        for (int next=idxA+1;next<=n;next++){
            if (max<a[next]){
                res = Math.max(res,jlis(next,idxB)+1);
            }
        }
        for (int next=idxB+1;next<=m;next++){
            if (max<b[next]){
                res = Math.max(res,jlis(idxA,next)+1);
            }
        }
        dp[idxA][idxB] = res;
        return res;
    }
}
