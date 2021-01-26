package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo1806 {
    static int[] arr;
    static int[] dp;
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n=Integer.parseInt(str[0]);
        k=Integer.parseInt(str[1]);

        arr=new int[n+1];
        dp=new int[n+1];
        int min =Integer.MAX_VALUE;

        str=br.readLine().split(" ");
        for (int i=1;i<=n;i++)arr[i] = Integer.parseInt(str[i-1]);

        int sum=0;
        int left=1;int right=1;

        while (true) {
            while (sum < k && right <= n) {
                sum += arr[right++];
            }
            if (sum>=k){
                min=Math.min(min,right-left);
            }
            sum-=arr[left++];

            if (left>n)break;
        }
        if (min==Integer.MAX_VALUE){
            System.out.println(0);
            return;
        }
        System.out.println(min);
    }
}
