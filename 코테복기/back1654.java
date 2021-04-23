package 코테복기;

import java.util.Scanner;

public class back1654 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();

        int[] arr=new int[n];
        for (int i=0;i<n;i++)arr[i]=scan.nextInt();

        int left=1;
        int right=Integer.MAX_VALUE-1;
        int ans=0;
        while (left<=right){
            int mid=(left+right)/2;

            int cnt=0;
            for (int i=0;i<n;i++){
                cnt+=(arr[i]/mid);
            }
            if (cnt>=m){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        System.out.println(ans);
    }
}
