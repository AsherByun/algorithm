package 코테복기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] str=br.readLine().split(" ");
        int n=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);
        int l=Integer.parseInt(str[2]);

        int[] arr=new int[n+2];

        str=br.readLine().split(" ");
        for (int i=1;i<=str.length;i++){
            arr[i]=Integer.parseInt(str[i-1]);
        }
        arr[0]=0;arr[n+1]=l;
        Arrays.sort(arr);
        int left=1;int right=arr[n-1];

        while (left<=right){
            int start=0;
            int point=0;
            int mid=(left+right)/2;

            for (int i=0;i<=n+1;i++){

            }
        }
    }
}
