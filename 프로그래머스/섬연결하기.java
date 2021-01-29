package 프로그래머스;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 섬연결하기 {

    public static void main(String[] args) {
        int n=4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        int[][] map = new int[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[2] <= o2[2])?-1:1;
            }
        });
        boolean[] visit = new boolean[n];

        for (int i=0;i<costs.length;i++){
            map[costs[i][0]][costs[i][1]] = costs[i][2];
            map[costs[i][1]][costs[i][0]] = costs[i][2];
        }
        int sum=0;

        pq.offer(new int[]{0,0,0});
        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int s = now[0]; int e = now[1]; int cost =now[2];
            if (visit[e])continue;
            visit[e]=true;
            sum+= cost;

            for (int i=0;i<n;i++){
                if (map[e][i]!=0&&!visit[i]){
                    pq.offer(new int[]{e,i,map[e][i]});
                }
            }

        }
        System.out.println(sum);
    }
}
