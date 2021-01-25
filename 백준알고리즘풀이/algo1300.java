package 백준;

import java.util.Scanner;

public class algo1300 {
    static int n;
    static int k;
    static long ans;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n=scan.nextInt();
        k=scan.nextInt();
        find(1,k);
        System.out.println(ans);
    }
    static void find(long left,long right){
        if(left>right)return;
        long mid = (left+right)/2;

        long cnt=0;
        for (int i=1;i<=n;i++){
            cnt += Math.min(n,mid/i);
        }

        if (cnt>k){
            find(left,mid-1);
        }else{
            ans=mid+1;
            find(mid+1,right);
        }

    }
}
