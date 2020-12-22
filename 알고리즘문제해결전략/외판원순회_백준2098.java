package 알고리즘문제해결전략;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 외판원순회_백준2098 {
    static int[][] dp;
    static int n;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][(1<<n)-1];

        for (int i=0;i<n;i++)
        Arrays.fill(dp[i],Integer.MAX_VALUE);

        for (int i=0;i<n;i++){
            String str[] = br.readLine().split(" ");
            for (int j=0;j<n;j++){
                int cost = Integer.parseInt(str[j]);
                map[i][j] = cost;
            }
        }

        System.out.print(dfs(0,1));
    }
    static int dfs(int now,int path){
        if (path == (1<<n) -1){
            if (map[now][0]==0)return Integer.MAX_VALUE;
            return map[now][0];
        }
        if (dp[now][path] != Integer.MAX_VALUE){
            return dp[now][path];
        }

        for (int i=0;i<n;i++) {
            int next = path | (1<<i);
            if (map[now][i]==0||(path&(1<<i))!=0)continue;

            dp[now][path] = Math.min(dp[now][path],dfs(i,next)+map[now][i]);
        }
        return dp[now][path];
    }
}

/* 현재노드와 지금까지 순회한 노드들 -> 비트마스크로 나타냄
*  재귀적으로 가장 작은 순회 노드를 받아옴
*  현재노드가 최대값을 가지지 않는다면 이미 순회해서 찾았기 때문에 return
*
* */