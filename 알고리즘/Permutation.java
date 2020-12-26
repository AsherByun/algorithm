package 알고리즘;

import java.io.*;
import java.util.Arrays;
import java.util.*;
public class Permutation {
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] num=new int[n];
        for(int i=0;i<num.length;i++) {
            num[i]=i+1;
        }
        Arrays.sort(num);
        print(num);

        while(next_permutation(num));

        System.out.println(sb);

    }
    static boolean next_permutation(int list[]) {
        int i=list.length-1;
        while(i>0&&list[i-1]>=list[i])i--;

        if(i<=0)return false;

        int j=list.length-1;
        while(list[i-1]>=list[j])j--;

        swap(i-1,j,list);

        j=list.length-1;
        for(;i<j;i++,j--) {
            swap(i,j,list);
        }
        print(list);
        return true;
    }
    static void swap(int i,int j,int[] list) {
        int temp=list[i];
        list[i]=list[j];
        list[j]=temp;
    }



    static void print(int[] arr) {

        for(int i=0;i<arr.length;i++) {
            sb.append(arr[i]+" ");
        }
        sb.append("\n");

    }
}