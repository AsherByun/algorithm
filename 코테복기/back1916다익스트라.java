package 코테복기;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class back1916다익스트라 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());

        int[][] map=new int[n+1][n+1];
        for (int i=1;i<=n;i++)Arrays.fill(map[i],987654321);
        for (int i=0;i<m;i++){
            String[] str=br.readLine().split(" ");
            int s=Integer.parseInt(str[0]);
            int e=Integer.parseInt(str[1]);
            int w=Integer.parseInt(str[2]);

            if (map[s][e]>w){
                map[s][e]=w;
            }
        }
        String[] s=br.readLine().split(" ");
        int a=Integer.parseInt(s[0]);
        int b=Integer.parseInt(s[1]);

        PriorityQueue<Point> pq = new PriorityQueue<>((p1,p2)->p1.y<p2.y?-1:1);
        pq.offer(new Point(a,0));

        int[] dp=new int[n+1];
        Arrays.fill(dp,987654321);
        dp[a]=0;

        while (!pq.isEmpty()){
            Point p=pq.poll();
            int now=p.x;
            int len=p.y;
            if (dp[now]<len)continue;

            for (int i=1;i<=n;i++){
                if (now==i||map[now][i]==987654321)continue;

                if (map[now][i]+dp[now]<dp[i]){
                    dp[i]=map[now][i]+dp[now];
                    pq.offer(new Point(i,dp[i]));
                }
            }

        }
        System.out.println(dp[b]);

    }
}
