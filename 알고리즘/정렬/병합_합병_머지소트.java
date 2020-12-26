package 알고리즘.정렬;

import java.util.Arrays;

public class 병합_합병_머지소트 {
    public static void main(String[] args) {
        int list[]=new int[]{5,1,6,7,3,2,11,4,9,8,10};
        int tmp[]=new int[list.length];
        mergeSort(list,tmp,0,list.length-1);
        System.out.println(Arrays.toString(list));
    }
    static void mergeSort(int list[],int tmp[],int start,int end){
        if (start>=end)return;

        int mid=(start+end)/2;
        mergeSort(list,tmp,start,mid);
        mergeSort(list, tmp, mid+1, end);

        int left=start;
        int right=mid+1;
        int idx=start;

        while (left<=mid||right<=end){
            if (right>end||(left<=mid&&list[left]<list[right])){
                tmp[idx++]=list[left++];
            }else{
                tmp[idx++]=list[right++];
            }
        }
        for (int i=start;i<=end;i++){
            list[i]=tmp[i];
        }
    }
}
