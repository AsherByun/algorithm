package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class algo2110 {
    static ArrayList<Integer> arr;
    static int n,m;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);

        arr = new ArrayList<>();
        for (int i=0;i<n;i++)arr.add(Integer.parseInt(br.readLine()));
        Collections.sort(arr);

        int left = 1; int right = arr.get(arr.size()-1);
        max=0;

        while (left<=right){
            int mid = (left+right)/2;
            int start = arr.get(0);
            int dis = 0;
            int cnt =1;

            for (int i=1;i<n;i++){
                dis = arr.get(i) - start;
                if (dis>=mid){
                    cnt++;
                    start = arr.get(i);
                }
            }
            if (cnt>=m){
                max = mid;
                left = mid + 1;
            }else {
                right = mid -1;
            }

        }
        System.out.println(max);
    }

}
