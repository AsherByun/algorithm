package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class algo1922 {
    static ArrayList<Integer>[] map;
    static int[][] costs;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());

        map = new ArrayList[n+1];
        for (int i=1;i<=n;i++)map[i]=new ArrayList<>();
        costs=new int[n+1][n+1];
        for (int i=0;i<m;i++){
            String[] str = br.readLine().split(" ");
            int a=Integer.parseInt(str[0]);
            int b=Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            costs[a][b]=cost;
            costs[b][a]=cost;
            map[a].add(b);
            map[b].add(a);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[2]<o2[2])?-1:1;
            }
        });

        boolean[] visit = new boolean[n+1];
        pq.offer(new int[]{1,1,0});
        int sum=0;

        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int s=now[0];int e=now[1];int cost=now[2];
            if (visit[e])continue;
            visit[e]=true;
            sum+=cost;
            for (int i=0;i<map[e].size();i++){
                int next = map[e].get(i);

                if (!visit[next]){
                    pq.offer(new int[]{e,next,costs[e][next]});
                }
            }
        }
        System.out.println(sum);
    }
}
