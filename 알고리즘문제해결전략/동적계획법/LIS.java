package 알고리즘문제해결전략.동적계획법;

import java.util.Arrays;

public class LIS {
    static int dp[];
    static int arr[];
    public static void main(String[] args) {
        arr = new int[]{1,9,2,4,10,3,5};
        dp = new int[arr.length];
        Arrays.fill(dp,-1);

        System.out.print(lis(0));
    }
    static int lis(int idx){
        if (dp[idx]!=-1)return dp[idx];

        int res = 1;
        for (int next=idx+1;next<arr.length;next++){
            if (arr[next]>arr[idx]){
                res = Math.max(res, lis(next)+1);
            }
        }
        dp[idx]=res;
        return res;
    }

}
