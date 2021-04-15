package VCNC;

import java.util.ArrayList;

public class p3 {
    static boolean[] visit;
    static ArrayList<Integer>[] map;
    static int[] checked;
    static int sum;
    static int count;
    public static void main(String[] args) {
        int n=4;
        int[][] nationality ={{1,2},{2,3}};
        map=new ArrayList[n+1];
        visit=new boolean[n+1];
        sum=0;

        for (int i=1;i<=n;i++)map[i]=new ArrayList<>();
        for (int i=0;i<nationality.length;i++){
            map[nationality[i][0]].add(nationality[i][1]);
            map[nationality[i][1]].add(nationality[i][0]);
        }
        for (int i=1;i<=n;i++){
            if (visit[i])continue;
            visit[i]=true;
            count=0;
            find(i);
            sum += (n-count)*count;
        }
        System.out.println(sum/2);
    }
    static void find(int now){
        count++;

        for (int i=0;i<map[now].size();i++){
            int next=map[now].get(i);
            if (!visit[next]) {
                    visit[next]=true;
                    find(next);
            }
        }

    }
}
