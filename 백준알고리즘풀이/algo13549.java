package 백준;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class algo13549 {
    static int[] map;
    static final int MAX = 100000;
    static int n,k;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        k=scan.nextInt();

        int[] dp = new int[MAX+1];

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]<o2[0]?-1:1;
            }
        });
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        boolean[] visit = new boolean[MAX+1];

        dp[n]=0;
        pq.offer(new int[]{0,n});

        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int pos=now[1];
            int cnt=now[0];
            if (cnt>dp[pos])continue;

            if (visit[pos])continue;
            visit[pos]=true;

            if (pos==k){
                break;
            }
            if (pos*2<=MAX&&pos<=k) {
                if (!visit[pos*2]) {
                    dp[pos * 2] = dp[pos];
                    pq.offer(new int[]{cnt, pos * 2});
                }
            }

            if (pos>=1){
                if (dp[pos-1]>dp[pos]+1&&!visit[pos-1]){
                    dp[pos-1]=dp[pos]+1;
                    pq.offer(new int[]{cnt+1,pos-1});
                }
            }

            if (pos<MAX){
                if (dp[pos+1]>dp[pos]+1&&!visit[pos+1]){
                    dp[pos+1]=dp[pos]+1;
                    pq.offer(new int[]{cnt+1,pos+1});
                }
            }

        }

        System.out.println(dp[k]);
    }
}
