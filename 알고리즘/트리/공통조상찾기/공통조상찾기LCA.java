package 알고리즘.트리.공통조상찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 공통조상찾기LCA { //dp사용해서 만들기

    public static void makeDepth(int p,int now,int deep){
        visit[now] = true;
        parent[now][0] = p;
        depth[now] = deep;

        for (int i=1;i<=n;i++){
            if (visit[i]||!link[now][i])continue;
            makeDepth(now,i,deep+1);
        }
    }
    public static void makeParent(){
        for (int i=1;i<=20;i++){
            for (int j=1;j<=n;j++){
                parent[j][i] = parent[parent[j][i-1]][i-1];
            }
        }
    }
    public static int LCA(int a,int b){
        if (depth[a]<depth[b]){
            int temp=a;
            a=b;
            b=temp;
        }
        for (int i=20;i>=0;i--){
            int jump = 1 << i;
            if (depth[a]-depth[b]>=jump)a=parent[a][i];
        }
        if (a == b) return a;

        for (int i=20;i>=0;i--){
            if (parent[a][i]==parent[b][i])continue;

            a=parent[a][i];
            b=parent[b][i];
        }
        return parent[a][0];
    }
    static int[][] parent;
    static int[] depth;
    static boolean[] visit;
    static boolean[][] link;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=15;
        parent = new int[n+1][21];
        depth = new int[n+1];
        visit = new boolean[n+1];
        link = new boolean[n+1][n+1];

        for (int i=0;i<n-1;i++){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]); int b = Integer.parseInt(str[1]);
            link[a][b]=true;link[b][a]=true;
        }
        makeDepth(0,1,1);
        makeParent();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<4;i++){
            String[] str = br.readLine().split(" ");
            int ans = LCA(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
/*
1 3
3 12
12 14
12 2
2 9
2 11
2 13
13 6
1 5
5 8
8 4
8 15
15 7
15 10
6 8
14 6
4 10
2 6
 */