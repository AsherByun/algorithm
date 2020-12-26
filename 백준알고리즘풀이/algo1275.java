package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo1275 {
    static int map[];
    static long tree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int q = Integer.parseInt(str[1]);

        tree = new long[n*5];
        map = new int[n+1];

        str = br.readLine().split(" ");
        for (int i=1;i<=n;i++){
            map[i]=Integer.parseInt(str[i-1]);
        }
        init(1,1,n);
        StringBuilder sb =new StringBuilder();
        for (int i=0;i<q;i++){
            str = br.readLine().split(" ");
            int x =Integer.parseInt(str[0]);
            int y =Integer.parseInt(str[1]);
            int a =Integer.parseInt(str[2]);
            int b =Integer.parseInt(str[3]);
            if (x>y){
                int temp=x;
                x=y;y=temp;
            }
            sb.append(sum(1,x,y,1,n)+"\n");

            update(1,1,n,a,b);
        }
        System.out.print(sb.toString());
    }
    static long init(int node,int start,int end){
        if (start==end){
            return tree[node] = map[start];
        }
        int mid = (start+end)/2;
        return tree[node] = init(node*2,start,mid) + init(node*2+1,mid+1,end);
    }

    static long sum(int node,int start,int end,int left,int right){
        if (left>end||right<start)return 0;
        if (left>=start&&right<=end){
            return tree[node];
        }
        int mid = (left+right)/2;
        return sum(node*2,start,end,left,mid) + sum(node*2+1,start,end,mid+1,right);
    }

    static long update(int node,int start,int end,int idx,int diff){
        if (idx>end||idx<start)return tree[node];

        if (start==end){
            return tree[node] =diff;
        }

        int mid = (start+end)/2;
        return tree[node] = update(node*2,start,mid,idx,diff) +update(node*2+1,mid+1,end,idx,diff);
    }

}
