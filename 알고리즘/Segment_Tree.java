package 알고리즘;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
//package 백준;
//
//        import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//
//public class algo2042 {
//    static int[] map;
//    static long[] tree;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] str = br.readLine().split(" ");
//
//        int n=Integer.parseInt(str[0]);
//        int m=Integer.parseInt(str[1]);
//        int k=Integer.parseInt(str[2]);
//
//        map = new int[n+1];
//        tree = new long[n*5];
//
//        for (int i=1;i<=n;i++){
//            map[i]=Integer.parseInt(br.readLine());
//        }
//
//        init(1,1,n);
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i=0;i<m+k;i++){
//            str = br.readLine().split(" ");
//            int a = Integer.parseInt(str[0]);
//            int b = Integer.parseInt(str[1]);
//            int c = Integer.parseInt(str[2]);
//            if (a==1){
//                int change = c-map[b];
//                update(1,1,n,b,change);
//            }else{
//                sb.append(sum(1,b,c,1,n)+"\n");
//            }
//        }
//        System.out.print(sb.toString());
//    }
//    static long sum(int node,int start,int end,int left,int right){
//        if (left>end||right<start){
//            return 0;
//        }
//        if (left>=start&&right<=end)return tree[node];
//
//        int mid = (left + right)/2;
//        return sum(node*2,start,end,left,mid)+sum(node*2+1,start,end,mid+1,right);
//    }
//    static void update(int node,int start,int end,int idx,int change){
//        if (idx>end||idx<start){
//            return;
//        }
//        tree[node] += change;
//        if (start==end)return;
//
//        int mid = (start+end)/2;
//        update(node*2,start,mid,idx,change);
//        update(node*2+1,mid+1,end,idx,change);
//    }
//
//    static long init(int node,int start,int end){
//        if (start==end){
//            return tree[node] = map[start];
//        }
//        int mid = (start+end)/2;
//
//        return tree[node] = init(node*2,start,mid) + init(node*2+1,mid+1,end);
//    }
//}
