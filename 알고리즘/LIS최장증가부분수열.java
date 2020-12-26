package 알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//nlogn
public class LIS최장증가부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N=sc.nextInt();
        int[] A=new int[N];
        for (int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int[] lis=new int[N];
        lis[0]=A[0];
        int idx=1;
        int tmp=0;
        for (int i=1;i<N;i++){
            if (lis[idx-1]<A[i])
                lis[idx++]=A[i];
            else if (lis[0]>A[i])
                lis[0]=A[i];
            else{
                tmp= Arrays.binarySearch(lis,0,idx,A[i]);
                lis[tmp<0?-tmp-1:tmp]=A[i];
            }
            System.out.println(idx);
        }
    }
}
