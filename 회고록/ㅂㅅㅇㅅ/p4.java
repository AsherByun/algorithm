package VCNC;

import java.util.ArrayList;

public class p4 {
    static ArrayList<Integer> map[];
    static int min;
    static int total;
    static boolean visit[];
    public static void main(String[] args) {
        int n=13;
        int[] cars = 	{22, 9, 1, 15, 8, 6, 20, 7, 11, 5, 10, 4, 1};
        int[][] links = {{4, 7},{13, 10},{6, 3},{7, 1},{6, 12},{5, 11},{5, 6},{5, 10},{9, 8},{8, 11},{8, 2},{7, 8}};
        min=Integer.MAX_VALUE;
        total =0;
        map = new ArrayList[n+1];
        visit = new boolean[n+1];
        for (int i=1;i<=n;i++){
            map[i] = new ArrayList<>();
        }
        for (int i=0;i<cars.length;i++)total+=cars[i];

        for (int i=0;i<links.length;i++){
            map[links[i][0]].add(links[i][1]);
            map[links[i][1]].add(links[i][0]);
        }

        visit[1]=true;
        find(1,cars);

        System.out.println(min);
    }
    static int find(int now,int[] cars){

        int sum=cars[now-1];

        for (int i=0;i<map[now].size();i++){
            int next=map[now].get(i);
            if (!visit[next]){
                visit[next]=true;
                sum+=find(next,cars);
            }
        }
        if (now==1)return 0;
        min = Math.min(Math.abs(total-sum*2),min);
        return sum;
    }

}
