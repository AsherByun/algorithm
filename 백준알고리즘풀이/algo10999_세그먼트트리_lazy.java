package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo10999_세그먼트트리_lazy {
    static long[] tree;
    static long[] map;
    static long[] lazy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);
        int k=Integer.parseInt(str[2]);

        map = new long[n+1];
        tree = new long[n*5];
        lazy = new long[n*5];

        for (int i=1;i<=n;i++)map[i] = Integer.parseInt(br.readLine());
        init(1,1,n);
        StringBuilder sb = new StringBuilder();



        for (int i=0;i<m+k;i++){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            if (a==1){
                long d = Long.parseLong(str[3]);
                update(1,b,c,1,n,d);
            }else{
                sb.append(sum(1,b,c,1,n)+"\n");
            }

        }
        System.out.print(sb.toString());
    }
    static long init(int node,int start,int end){
        if (start==end){
            return tree[node]=map[start];
        }
        int mid=(start+end)/2;
        return tree[node]=init(node*2,start,mid)+init(node*2+1,mid+1,end);
    }
    static void update(int node,int start,int end,int left,int right,long diff){
        if (lazy[node]!=0){
            tree[node] += (right-left+1)*lazy[node];
            if (left!=right){
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }
            lazy[node] = 0;
        }
        if (left>end||right<start)return;

        if (left>=start&&right<=end){
            tree[node] += (right-left+1)*diff;
            if (left!=right){
                lazy[node*2] += diff;
                lazy[node*2+1] += diff;
            }
            return;
        }
        int mid = (left+right)/2;
        update(node*2,start,end,left,mid,diff);
        update(node*2+1,start,end,mid+1,right,diff);

        tree[node] = tree[node*2] + tree[node*2+1];
    }
    static long sum(int node,int start,int end,int left,int right){
        if (lazy[node]!=0){
            tree[node]+=(right-left+1)*lazy[node];
            if (left!=right){
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }
            lazy[node] = 0;
        }
        if (left>end||right<start) return 0;

        if (left>=start&&right<=end)return tree[node];

        int mid = (left+right)/2;

        return sum(node*2,start,end,left,mid) + sum(node*2+1,start,end,mid+1,right);
    }
}
