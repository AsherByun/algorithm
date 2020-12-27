package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo2042 {
    static int[] map;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);
        int k=Integer.parseInt(str[2]);

        map = new int[n+1];
        tree = new long[n*5];

        for (int i=1;i<=n;i++){
            map[i]=Integer.parseInt(br.readLine());
        }

        init(1,1,n);

        StringBuilder sb = new StringBuilder();

        for (int i=0;i<m+k;i++){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            if (a==1){
                int change = c-map[b];
                map[b]=c;
                update(1,1,n,b,change);
            }else{
                sb.append(sum(1,b,c,1,n)+"\n");
            }
        }
        System.out.print(sb.toString());
    }
    static long sum(int node,int start,int end,int left,int right){
        if (left>end||right<start){
            return 0;
        }
        if (left>=start&&right<=end)return tree[node];

        int mid = (left + right)/2;
        return sum(node*2,start,end,left,mid)+sum(node*2+1,start,end,mid+1,right);
    }
    static void update(int node,int start,int end,int idx,int change){
        if (idx>end||idx<start){
            return;
        }
        tree[node] += change;
        if (start==end)return;

        int mid = (start+end)/2;
        update(node*2,start,mid,idx,change);
        update(node*2+1,mid+1,end,idx,change);
    }

    static long init(int node,int start,int end){
        if (start==end){
            return tree[node] = map[start];
        }
        int mid = (start+end)/2;

        return tree[node] = init(node*2,start,mid) + init(node*2+1,mid+1,end);
    }
}
