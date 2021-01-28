package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;

public class 순위 {
    static int[] up;
    static int[] down;
    static ArrayList<Integer> map[];
    static ArrayList<Integer> dmap[];
    public static void main(String[] args) {
        int[][] results = {{4, 3},{4, 2},{3, 2},{1, 2},{2, 5}};
        int n=5;
        up=new int[n+1];
        Arrays.fill(up,-1);
        down=new int[n+1];
        Arrays.fill(down,-1);

        map = new ArrayList[n+1];
        for (int i=1;i<=n;i++)map[i]=new ArrayList<>();
        dmap = new ArrayList[n+1];
        for (int i=1;i<=n;i++)dmap[i]=new ArrayList<>();
        for (int i=0;i<results.length;i++){
            map[results[i][1]].add(results[i][0]);
            dmap[results[i][0]].add(results[i][1]);
        }
//        System.out.println(find(5,new boolean[n+1],map));
        for (int i=1;i<=n;i++){
            up[i]=find(i,new boolean[n+1],map);
        }
        for (int i=1;i<=n;i++){
            down[i]=find(i,new boolean[n+1],dmap);
        }
        int ans=0;
        for (int i=1;i<=n;i++){
            if (down[i]+up[i]-1==n){
                ans++;
            }
        }
        System.out.println(ans);
    }
    static int find(int now,boolean[] visit,ArrayList<Integer> arr[]){
        int sum =1;
        for (int i=0;i<arr[now].size();i++){
            int next = arr[now].get(i);
            if (!visit[next]){
                visit[next]=true;
                sum+=find(next,visit,arr);
            }
        }
        return sum;
    }
}
