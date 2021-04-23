package 코테복기;

import java.util.Arrays;

public class back2110 {
    public static void main(String[] args) {
        int n=5;
        int c=3;
        int[] arr = {1,2,8,4,9};

        Arrays.sort(arr);


        int left = 1;
        int right = arr[arr.length-1];

        int mid;
        int min;

        while (left<=right){
            mid = (left+right)/2;
            int cnt=1;
            int start=arr[0];
            int dis=0;


            for(int i=1;i<arr.length;i++){
                dis = arr[i] - start;
                if (dis>=mid){
                    cnt++;
                    start=arr[i];
                }
            }

            if (cnt>=c){
                min=mid;
                left = mid+1;
            }else{
                right = mid-1;
            }

        }

    }
}
