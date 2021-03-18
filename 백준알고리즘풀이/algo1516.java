package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo1516 {
    static int n;
    static int[] degree;
    static int[] time;
    static int[] dp;
    static ArrayList<Integer>[] before;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        before=new ArrayList[n+1];
        for (int i=1;i<=n;i++)before[i]=new ArrayList<>();
        degree=new int[n+1];
        time=new int[n+1];
        dp=new int[n+1];

        for (int i=1;i<=n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            time[i]=Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()){
                int t=Integer.parseInt(st.nextToken());
                if (t==-1)break;
                before[t].add(i);
                degree[i]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for (int i=1;i<=n;i++){
            if (degree[i]==0)q.offer(i);
        }

        while (!q.isEmpty()){
            int now=q.poll();
            dp[now]+=time[now];
            for (int i=0;i<before[now].size();i++){
                int next = before[now].get(i);
                degree[next]--;
                dp[next]=Math.max(dp[next],dp[now]);
                if (degree[next]==0){
                    q.offer(next);
                }
            }
        }
        for (int i=1;i<=n;i++)System.out.println(dp[i]);

    }
}
