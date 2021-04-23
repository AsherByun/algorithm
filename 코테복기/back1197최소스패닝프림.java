package 코테복기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class back1197최소스패닝프림 {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i=0;i<=n;i++)list.add(new ArrayList<>());


        for (int i = 0; i < m; i++) {
            String[] st = br.readLine().split(" ");
            int s = Integer.parseInt(st[0]);
            int e = Integer.parseInt(st[1]);
            int w = Integer.parseInt(st[2]);
            list.get(s).add(new Node(s,e,w));
            list.get(e).add(new Node(e,s,w));
        }

        boolean[] visit=new boolean[n+1];
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(1,1,0));
        int sum=0;

        while (!pq.isEmpty()){
            Node node=pq.poll();
            if (visit[node.e])continue;
            visit[node.e]=true;
            sum+=node.w;

            for (Node nd:list.get(node.e)){
                if (visit[nd.e])continue;
                pq.offer(nd);
            }

        }
        System.out.println(sum);
    }
    static class Node implements Comparable<Node>{
        int s,e,w;

        public Node(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o){
            return this.w<o.w?-1:1;
        }
    }
}
