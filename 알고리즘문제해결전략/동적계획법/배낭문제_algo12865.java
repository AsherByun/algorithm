package 알고리즘문제해결전략.동적계획법;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 배낭문제_algo12865 {
    static int n,m;
    static int[][] dp;
    static Point[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);

        dp = new int[n+1][m+1];
        map = new Point[n+1];
        for (int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        for (int i=1;i<=n;i++){
            str = br.readLine().split(" ");
            int w = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            map[i] = new Point(w,c);
        }
        System.out.println(find(1,m));
    }
    static int find(int idx,int remain){
        if (idx>n){
            return 0;
        }
        if (dp[idx][remain]!=-1)return dp[idx][remain];

        dp[idx][remain] = find(idx+1,remain);

        if (remain>=map[idx].x){
            dp[idx][remain] = Math.max(dp[idx][remain],find(idx+1,remain-map[idx].x)+map[idx].y);
        }

        return dp[idx][remain];

    }
}
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        int dp[][]=new int[n+1][m+1];
//
//        int w[] = new int[n+1];
//        int value[] = new int[n+1];
//
//        for (int i=1;i<=n;i++){
//            st = new StringTokenizer(br.readLine());
//            w[i] = Integer.parseInt(st.nextToken());
//            value[i] = Integer.parseInt(st.nextToken());
//        }
//
//        for (int i=1;i<=n;i++){
//            for(int j=1;j<=m;j++){
//                dp[i][j] = dp[i-1][j];
//                if (j-w[i]>=0){
//                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+value[i]);
//                }
//
//            }
//        }
//        System.out.println(dp[n][m]);
//    }
//}
