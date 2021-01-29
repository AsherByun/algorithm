package 알고리즘.그래프;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 다익스트라 {
    static final int INF = Integer.MAX_VALUE;
    static final int INIT = 0;
    static public int[] 다익스트라(int[][] weight,int n){
        // 시작점은 1번

        int[] distance = new int[n+1];
        Arrays.fill(distance,INF);
        distance[1] = INIT;  //시작점은 0으로 초기화

        // int[2] -> int[0]=이번 노드의 번호 , int[1]=현노드까지의 길이값   ->길이값으로 정렬 > 힙구조 -> logn
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1]<o2[1])?-1:1;
            }
        });

        pq.offer(new int[]{1,0}); // 1번부터시작
        while (!pq.isEmpty()){
            int now[] = pq.poll();
            int num = now[0]; int cost = now[1];
            for (int i=1;i<=n;i++){         //여기서 시간복잡도 줄일려면 1~n이아니라 arrayList로 받아와 안에있는애들만 실행해주면 된다
                if (distance[i]>distance[num]+weight[num][i]&&weight[num][i]!=0){
                    distance[i] = distance[num]+weight[num][i];
                    pq.offer(new int[]{i,distance[i]});
                }
            }
        }


        return distance;
    }
    public static void main(String[] args) {
        int n=6;
        int[][] w=new int[n+1][n+1];
        w[3][6] = 1;w[3][4] = 1;w[2][3] = 1;w[3][1] = 1;w[1][2] = 1;w[2][4] = 1;w[2][5] = 1;
        w[6][3] = 1;w[4][3] = 1;w[3][2] = 1;w[1][3] = 1;w[2][1] = 1;w[4][2] = 1;w[5][2] = 1;
        int[] distance = 다익스트라(w,n);

        for (int i=1;i<=n;i++){
            System.out.println(i+"  "+distance[i]);
        }

    }
}
