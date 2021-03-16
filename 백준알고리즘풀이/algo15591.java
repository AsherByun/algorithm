package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class algo15591 {
    static int n,m;
    static long[][] map;
    static ArrayList<Node>[] nodes;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] str= br.readLine().split(" ");
        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);

        nodes = new ArrayList[n+1];
        for (int i=1;i<=n;i++){
            nodes[i]=new ArrayList<>();
        }

        for (int i=0;i<n-1;i++){
            str = br.readLine().split(" ");
            int s=Integer.parseInt(str[0]);
            int e=Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            nodes[s].add(new Node(s,e,c));
            nodes[e].add(new Node(e,s,c));
        }

        map = new long[n+1][n+1];
        for (int i=1;i<=n;i++){
            Arrays.fill(map[i],INF);
        }
//        ArrayList<Long>[] sol = new ArrayList[n+1];
//        for (int i=1;i<=n;i++)sol[i]=new ArrayList<>();
        for (int i=1;i<=n;i++){
            makeDist(i);
//            for (int j=1;j<=n;j++){
//                if (i==j)continue;
//                sol[i].add(map[i][j]);
//            }
//
        }
//        for (int i=1;i<=n;i++){
//            for (int j=1;j<=n;j++){
//                System.out.println(i+" "+j+" "+map[i][j]);
//            }System.out.println("--------------");
//        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<m;i++){
            str=br.readLine().split(" ");
            int k=Integer.parseInt(str[0]);
            int v=Integer.parseInt(str[1]);
            int ans = 0;
            for (int j=1;j<=n;j++)if (map[v][j]>=k)ans++;
            sb.append(ans-1+"\n");
        }
        System.out.println(sb);
    }
    static void makeDist(int num){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[n+1];
        visit[num]=true;
        for (int i=0;i<nodes[num].size();i++){
            Node node=nodes[num].get(i);
            pq.offer(node);
        }

        while (!pq.isEmpty()){
            Node node = pq.poll();
            if (visit[node.e])continue;
            visit[node.e]=true;

            map[num][node.e] = Math.min(map[num][node.e],Math.min(node.c,map[num][node.s]));
            for (int i=0;i<nodes[node.e].size();i++){
                Node next = nodes[node.e].get(i);
                if (visit[next.e])continue;
                pq.offer(next);
            }

        }
    }
    static class Node implements Comparable<Node>{
        int s,e;
        long c;
        public Node(int s, int e, long c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
        @Override
        public int compareTo(Node o) {
            return this.c<o.c?-1:1;
        }
    }
}
