package 알고리즘.정렬;

import java.util.Arrays;
import java.util.HashMap;

public class 퀵정렬 {
    public static void main(String[] args) {
        int list[]=new int[]{2,0,2,1,1,0};
        quickSort(list,0,list.length-1);
        System.out.println(Arrays.toString(list));
    }
    static void quickSort(int list[],int left,int right){
        if (left>=right)return;
        System.out.println(right-left);
        int pivot=partition(list,left,right);
        quickSort(list,left,pivot-1);
        quickSort(list,pivot+1,right);
    }
    static int partition(int list[],int left,int right){
        int mid=(left+right)/2;
        swap(list,left,mid);
        ///////////////////////
        int pivot = list[left];
        int i=left;int j=right;
        while (i<j){
            while (pivot<list[j]){
                j--;
            }
            while (i<j&&pivot>=list[i]){
                i++;
            }
            swap(list,i,j);
        }
        list[left]=list[i];
        list[i]=pivot;
        return i;
    }
    static void swap(int list[],int a,int b){
        int temp=list[a];
        list[a]=list[b];
        list[b]=temp;
    }
}
