package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class algo6487 {
    static int n,m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        while (true) {
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            if (n==0&&m==0)break;

            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            int sum = 0;
            for (int i = 0; i < m; i++) {
                str = br.readLine().split(" ");
                sum += Integer.parseInt(str[2]);
                pq.offer(new Node(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2])));
            }

            int cost = 0;

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                int s = node.s;
                int e = node.e;
                if (isSameParent(s, e)) continue;
                cost += node.cost;
                union(s, e);
            }
            sb.append(sum - cost);
        }
        System.out.println(sb);
    }
    static boolean isSameParent(int x,int y){
        return find(x)==find(y);
    }
    static void union(int x,int y){
        x=find(x);
        y=find(y);
        if (x<y)parent[y]=x;
        else parent[x]=y;
    }
    static int find(int x){
        if (x==parent[x])return parent[x];
        else return parent[x]=find(parent[x]);
    }
    static class Node implements Comparable<Node>{
        int s,e,cost;

        Node(int s,int e,int cost){
            this.s=s;
            this.e=e;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost<o.cost?-1:1;
        }
    }
}
