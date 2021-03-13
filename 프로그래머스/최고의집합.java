package 프로그래머스;

import java.util.Arrays;

public class 최고의집합 {
    public static void main(String[] args) {
        int n=2;
        int s=8;

        if (s/n<1){
            System.out.println(-1);
            return;
        }

        int[] ans=new int[n];
        int k=(s/n);
        int r=(s%n);

        Arrays.fill(ans,k);
        int j=0;
        for (int i=0;i<r;i++){
            ans[j]++;
            j=(j+1)%n;
        }
        Arrays.sort(ans);
        for (int i=0;i<n;i++)System.out.println(ans[i]);
    }
}
