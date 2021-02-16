package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class algo1477파나메트릭서치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] str=br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int len = Integer.parseInt(str[2]);

        ArrayList<Integer> arr = new ArrayList<>();
        str = br.readLine().split(" ");
        for (int i=0;i<n;i++)arr.add(Integer.parseInt(str[i]));
        arr.add(0);arr.add(len);
        Collections.sort(arr);

        int min = Integer.MAX_VALUE;
        int left = 1;
        int right=len;

        for (int i=1;i<arr.size();i++){
            right = Math.max(right,arr.get(i)-arr.get(i-1)-1);
        }
        int mid;
        while (left<=right){
            mid = (right+left)/2;
            int count=0;
            for (int i=1;i<arr.size();i++){
                count+=(arr.get(i)-arr.get(i-1)-1)/mid;
            }
            if (count>=m){
                left = mid+1;
            }else{
                right=mid-1;
                min=mid;
            }
        }
        System.out.print(min);
    }
}
