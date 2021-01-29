package 알고리즘.그래프;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 프림 {
    static public int 프림(int[][] weight,int n){
        PriorityQueue<int[]> pq =new PriorityQueue<>(new Comparator<int[]>() {  // 간선들의 길이를 기준으로 정렬 int[0] => 현노드번호(픽된애) int[1]=다음노드 int[1]=간선의 번호
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[2]<o2[2])?-1:1;
            }
        });
        int sum =0;
        pq.offer(new int[]{1,1,0}); //시작 노드 1번

        boolean[] visit = new boolean[n+1]; //들린 곳인지 알아야함

        while (!pq.isEmpty()){
            int now[] = pq.poll();
            int s=now[0]; int e=now[1]; int cost = now[2];

            if (visit[e])continue;
            visit[e]=true;
            sum += cost;

            for (int i=1;i<=n;i++){
                if (!visit[i]&&weight[e][i]!=0){
                    pq.offer(new int[]{e,i,weight[e][i]});
                }
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        int n=6;
        int[][] w=new int[n+1][n+1];
        w[3][6] = 1;w[3][4] = 1;w[2][3] = 4;w[3][1] = 3;w[1][2] = 2;w[2][4] = 5;w[2][5] = 3;
        w[6][3] = 1;w[4][3] = 1;w[3][2] = 4;w[1][3] = 3;w[2][1] = 2;w[4][2] = 5;w[5][2] = 3;
        int ans = 프림(w,n);
        System.out.println(ans);
    }
}
