package 알고리즘;
import java.util.*;
public class Segment_Tree {
    static int arr[]={1,9,3,8,4,5,5,9,10,3,4,5};
    static int tree[]=new int[4*12];        //tree크기는 arr크기를 만드는 2^k k의 반올림 *arr size
    public static void main(String[] args) {
        init(arr,tree,1,0,arr.length-1);

        for(int i=0;i<33;i++){
            System.out.print(tree[i]+" ");
        }System.out.println();
        System.out.println(sum(0,2,1,0,arr.length-1));

        int change = 5;
        update(0,arr.length-1,1,1,arr[1]-change);
    }
    static int init(int arr[],int tree[],int node,int start,int end){
        if (start==end){
            return tree[node]=arr[start];
        }
        int mid=(start+end)/2;
        return tree[node]=init(arr,tree,node*2,start,mid)+init(arr,tree,node*2+1,mid+1,end);
    }

    static int sum(int start,int end,int node,int left,int right){
        if (left>end||right<start)return 0; //범위가 벗어나면 끝
        if (start<=left&&end>=right){   //범위안에 있으면 둘다. 그값을 가져옴
            return tree[node];
        }
        int mid = (left+right)/2;
        return sum(start,end,node*2,left,mid)+sum(start,end,node*2+1,mid+1,right);
    }
    //dif는 원래값과 차이
    static void update(int start,int end,int node,int index,int dif){
        if (index<start||index>end){
            return;
        }
        tree[node] += dif;
        if (start==end){
            return;
        }
        /* 변경된 값이 속한 구간합을 모두 바꿈 */
        int mid = (start+end)/2;
        update(start,mid,node*2,index,dif);
        update(mid+1,end,node*2+1,index,dif);
    }
}
