package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class algo2820 {
    static int n,m;
    static long[] map;
    static long[] tree;
    static long[] lazy;
    static int[] l;
    static int[] r;
    static int cnt;
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);

        map = new long[n+1];
        tree = new long[n*4];
        lazy = new long[n*4];
        l = new int[n+1];
        r = new int[n+1];
        list = new ArrayList[n+1];
        for (int i=1;i<=n;i++)list[i] = new ArrayList<>();

        map[1] = Long.parseLong(br.readLine());

        for (int i=2;i<=n;i++){
            str = br.readLine().split(" ");
            map[i] = Long.parseLong(str[0]);
            list[Integer.parseInt(str[1])].add(i);
        }
        cnt = 0;
        dfs(1);

        for (int i=1;i<=n;i++)update(1,l[i],l[i],1,n,map[i]);

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<m;i++){
            str = br.readLine().split(" ");
            if (str[0].equals("p")){
                int a = Integer.parseInt(str[1]);
                long b = Long.parseLong(str[2]);
                update(1,l[a]+1,r[a],1,n,b);
            }else{
                int a = Integer.parseInt(str[1]);
                sb.append(query(1,l[a],l[a],1,n)+"\n");
            }
        }
        System.out.print(sb.toString());
    }
    static void lazyUpdate(int node,int start,int end){
        if (lazy[node]!=0){
            tree[node] += lazy[node];
            if (start!=end){
                lazy[node*2]+=lazy[node];
                lazy[node*2+1]+=lazy[node];
            }
            lazy[node] = 0;
        }
    }
    static void update(int node,int start,int end,int left,int right,long diff){
        lazyUpdate(node,left,right);
        if (start>right||end<left)return;
        if (left>=start&&right<=end){
            tree[node] += diff;
            if (left!=right){
                lazy[node*2] += diff;
                lazy[node*2+1] += diff;
            }
            return;
        }
        int mid = (left+right)/2;
        update(node*2,start,end,left,mid,diff);
        update(node*2+1,start,end,mid+1,right,diff);
    }
    static long query(int node,int start,int end,int left,int right){
        lazyUpdate(node,left,right);
        if (left>end||right<start)return 0;
        if (start==left&&right==end){
            return tree[node];
        }
        int mid = (left+right)/2;
        return query(node*2,start,end,left,mid) + query(node*2+1,start,end,mid+1,right);
    }
    //여기가 가장중요 원래의 순서를 벗어나서 새로운 순서를 만들고
    //순서에 따라 범위를 주는 방법!!
    //l[a] 가 새로운 순서가 된다
    static void dfs(int now){
        l[now] = ++cnt;
        for (int i:list[now]){
            dfs(i);
        }
        r[now] = cnt;
    }
}
