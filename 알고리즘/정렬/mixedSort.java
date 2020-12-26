package 알고리즘.정렬;
import java.util.*;
public class mixedSort {
    static final int LIMIT = 10;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int list[]=new int[n];

        for (int i=0;i<n;i++){
            list[i]=scan.nextInt();
        }

        quickSort(list,0,list.length-1);
        System.out.println(Arrays.toString(list));
    }
    static void quickSort(int list[],int left,int right) {

        if (right - left <= LIMIT) {    //10개이하
            for (int i = right; i >= left; i--) {
                for (int j = left; j < i; j++) {
                    if (list[j] > list[j + 1]) {
                        swap(list, j+1, j);
                    }
                }
            }
        } else {
            int pivot = partition(list, left, right);
            quickSort(list, left, pivot - 1);
            quickSort(list, pivot + 1, right);
        }
    }
    static int partition(int list[],int left,int right){
        int mid=(left+right)/2;
        swap(list,left,mid);

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
