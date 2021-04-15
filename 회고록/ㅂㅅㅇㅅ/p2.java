package VCNC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class p2 {
    static ArrayList<Integer>[] links;
    static int[][] cost;
    static int[][] time;
    public static void main(String[] args) {
        int n=5;
        int m=4;
        int[][] paths = {{1,2,3,2},{1,3,2,2},{2,4,1,1},{2,5,4,1},{3,5,2,3},{4,5,2,1}};
        time = new int[n+1][n+1];
        cost = new int[n+1][n+1];
        links=new ArrayList[n+1];
        for (int i=1;i<=n;i++)links[i]=new ArrayList<>();

        for (int i=0;i<paths.length;i++){
            int a=paths[i][0];
            int b=paths[i][1];
            int c=paths[i][2];
            int d=paths[i][3];

            links[a].add(b); links[b].add(a);
            time[a][b]=c;time[b][a]=c;
            cost[a][b]=d;cost[b][a]=d;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]<o2[1])return -1;
                else if (o1[1]>o2[1])return 1;
                else return o1[2]<o2[2] ? -1:1;
            }
        });

        int[] distance = new int[n+1];
        int[] costSum = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        Arrays.fill(costSum,Integer.MAX_VALUE);
        distance[1]=0;
        costSum[1]=0;
        pq.offer(new int[]{1,0,0});

        while (!pq.isEmpty()){
            int[] now=pq.poll();
            int idx=now[0];int total=now[1];int dist=now[2];
            if (idx==n)continue;

            for (int i=0;i<links[idx].size();i++){
                int next=links[idx].get(i);
                int nextSum=cost[idx][next]+total;
                int nextDist=dist+time[idx][next];

                if (nextSum>m)continue;
                if (nextSum>costSum[next]&&nextDist>distance[next])continue;
                if (nextDist<distance[next]){
                    costSum[next]=nextSum;
                    distance[next]= nextDist;
                }
                pq.offer(new int[]{next,nextSum,nextDist});

            }

        }
        System.out.println(distance[n]);
    }

}
