package 프로그래머스;

import java.util.ArrayList;

public class 네트워크 {
    static ArrayList<Integer>[] map;
    static boolean[] visit;
    public static void main(String[] args) {
        int n=3;
        int[][] computers = new int[][]{{1, 1, 0},{1, 1, 0},{0, 0, 1}};

        map=new ArrayList[n];
        visit=new boolean[n];

        for (int i=0;i<computers.length;i++){
            map[i] = new ArrayList<>();
            for (int j=0;j<computers[0].length;j++){
                if (computers[i][j]==1&&i!=j){
                    map[i].add(j);
                }
            }
        }
        int cnt=0;
        for (int i=0;i<n;i++){
            if (!visit[i]){
                cnt++;
                visit[i]=true;
                dfs(i);
            }
        }

        System.out.println(cnt);
    }
    static void dfs(int now){

        for (int i=0;i<map[now].size();i++){
            int next=map[now].get(i);
            if (!visit[next]){
                visit[next]=true;
                dfs(next);
            }
        }
    }
}
