package 프로그래머스;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        int n = 6;
        int times[] = {7,10};
        Arrays.sort(times);
        long right = (long)times[times.length-1]*(long)n;
        long left = 1;
        long ans=Long.MAX_VALUE;

        while (left<=right){
            long mid = (left+right)/2;

            long cnt = 0;

            for (int i=0;i<times.length;i++){
                cnt += mid/times[i];
            }

            if (cnt >= n){
                ans = Math.min(ans,mid);
                right=mid-1;
            }else{
                left=mid+1;
            }

        }
        System.out.println(ans);
    }
}
