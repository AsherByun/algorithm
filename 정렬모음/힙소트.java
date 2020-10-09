package 알고리즘.정렬;

import java.util.Arrays;

public class 힙소트 {
    public static void main(String[] args) {
        int list[]=new int[]{5,1,6,7,3,2,11,4,9,8,10};
        for (int i=list.length/2-1;i>=0;i--){
            heapify(list,list.length,i);
        }

        for (int i=list.length-1;i>=0;i--){
            System.out.println(Arrays.toString(list));
            swap(list,i,0);
            heapify(list,i-1,0);

        }

        System.out.println(Arrays.toString(list));
    }
    static void heapify(int list[],int size,int pnode){
        int parent=pnode;
        int lnode=parent*2+1;
        int rnode=parent*2+2;

        if (size>lnode&&list[parent]<list[lnode]){
            parent=lnode;
        }
        if (size>rnode&&list[parent]<list[rnode]){
            parent=rnode;
        }
        if (parent!=pnode){
            swap(list,pnode,parent);
            heapify(list,size,parent);
        }
    }
    static void swap(int list[],int a,int b){
        int temp=list[a];
        list[a]=list[b];
        list[b]=temp;
    }
}

