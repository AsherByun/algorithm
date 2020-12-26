package 알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCA {
    static boolean tree[][];
    static boolean visit[];
    static int deep[];
    static int parent[][];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        tree = new boolean[n+1][n+1];

        for (int i =0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a][b] = true;
        }

        parent = new int[n+1][21];
        deep = new int[n+1];
        visit = new boolean[n+1];

        dfs(1,0);
        connecting();
        int m= Integer.parseInt(br.readLine());

        for (int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(lca(a,b));
        }
    }
    static void dfs(int current,int depth){
        visit[current] = true;
        deep[current] = depth;

        for (int i=1;i<=n;i++){
            if (visit[i])continue;

            parent[i][0] = current;
            dfs(i,depth+1);
        }
    }
    static void connecting(){
        for (int i=1;i<21;i++){
            for (int j=1;j<=n;j++){
                parent[j][i] = parent[parent[j][0]][i-1];
            }
        }
    }

    static int lca(int a,int b){
        if (deep[a]>deep[b]){
            int temp=a;
            a=b;
            b=temp;
        }

        for (int i=20;i>=0;i--){
            int jump = 1 << i;
            if (deep[b] - deep[a] >= jump) b = parent[b][i];
        }

        if (a == b)return a;

        for (int i=20;i>=0;i--){
            if (parent[a][i] == parent[b][i])continue;

            a = parent[a][i];
            b = parent[b][i];
        }
        return parent[a][0];
    }
}
