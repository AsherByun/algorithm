package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class algo11437 {
    static int[][] parent;
    static int n;
    static int[] depth;
    static ArrayList<Integer>[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        parent=new int[n+1][21];
        depth=new int[n+1];
        map = new ArrayList[n+1];
        for (int i=1;i<=n;i++)map[i]=new ArrayList<>();

        for (int i=0;i<n-1;i++){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            map[a].add(b); map[b].add(a);
        }
        makeParent(1,0,new boolean[n+1],1);
        setParent();
        int m=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<m;i++){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            sb.append(lca(a,b)+"\n");
        }
        System.out.print(sb);
    }
    static int lca(int a,int b){
        if (depth[a]<depth[b]){
            int temp=a;
            a=b;
            b=temp;
        }
        for (int i=20;i>=0;i--){
            int jump = 1 << i;
            if (depth[a]-depth[b] >= jump)a=parent[a][i];
        }
        if (a==b)return a;
        for (int i=20;i>=0;i--){
            if (parent[a][i]==parent[b][i])continue;
            a=parent[a][i];
            b=parent[b][i];
        }
        return parent[a][0];
    }

    static void setParent(){
        for (int i=1;i<=20;i++){
            for (int j=1;j<=n;j++){
                parent[j][i] = parent[parent[j][i-1]][i-1];
            }
        }
    }

    static void makeParent(int now,int p,boolean[] visit,int deep){
        visit[now]=true;
        parent[now][0]=p;
        depth[now]=deep;

        for (int i=0;i<map[now].size();i++){
            int next= map[now].get(i);
            if (visit[next])continue;

            makeParent(next,now,visit,deep+1);
        }
    }
}
