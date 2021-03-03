package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class algo10972 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] str=br.readLine().split(" ");
        for (int i=0;i< str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        if(nextPermutation(arr)) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }else{
            System.out.println(-1);
        }
    }
    static boolean nextPermutation(int[] arr){
        if (n==1)return false;
        int i=n-1;
        int j=n-1;
        while (arr[i-1]>arr[i]&&i>1)--i;

        if (i<=1)return false;

        while (arr[i-1]>arr[j])j--;

        swap(i-1,j,arr);
        j=n-1;
        while (i<=j){
            swap(i,j,arr);
            i++;j--;
        }
        return true;
    }
    static void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
