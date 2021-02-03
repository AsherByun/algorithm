package 알고리즘.트리.세그먼트트리;

public class 세그먼트트리 {

    public static int 세그먼트트리만들기(int start,int end,int[] arr,int[] segTree,int node){
        if (start == end){
            return segTree[node] = arr[start];
        }
        int mid = (start + end) / 2;

        return segTree[node] = 세그먼트트리만들기(start,mid,arr,segTree,node*2+1)
                + 세그먼트트리만들기(mid+1,end,arr,segTree,node*2+2);
    }
    public static int 구간합구하기(int start,int end,int left,int right,int node,int[] segTree){
        if (left>end||right<start)return 0;
        if (start<=left&&right<=end)return segTree[node];

        int mid= (left+right) / 2;
        return 구간합구하기(start,end,left,mid,node*2+1,segTree)
                +구간합구하기(start,end,mid+1,right,node*2+2,segTree);
    }

    public static void update(int start,int end,int node,int index,int diff,int[] segTree){
        if (index<start||index>end)return ;
        segTree[node] += diff;
        if (start==end){
            return;
        }
        int mid = (start+end)/2;
        update(start,mid,node*2+1,index,diff,segTree);
        update(mid+1,end,node*2+1,index,diff,segTree);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,5,2,6,8,12,3,11,16};
        int[] segTree = new int[arr.length*4];

        세그먼트트리만들기(0,arr.length-1,arr,segTree,0);
        System.out.println(구간합구하기(0,3,0,arr.length-1,0,segTree));

    }
}
