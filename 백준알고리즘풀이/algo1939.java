package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class algo1939 {
    static int n,m;
    static ArrayList<Node>[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new ArrayList[n+1];
        for (int i=0;i<=n;i++)map[i]=new ArrayList<>();

        for (int i=0;i<m;i++){
            String[] str = br.readLine().split(" ");
            int s=Integer.parseInt(str[0]); int e=Integer.parseInt(str[1]); int cost=Integer.parseInt(str[2]);
            map[s].add(new Node(s,e,cost));
            map[e].add(new Node(e,s,cost));
        }
        String[] str= br.readLine().split(" ");
        int start = Integer.parseInt(str[0]);
        int end = Integer.parseInt(str[1]);

        ArrayList<Node> lines = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[n+1];

        pq.offer(new Node(start,start,Integer.MAX_VALUE));

        while (!pq.isEmpty()){
            Node node = pq.poll();
            if (visit[node.e])continue;
            lines.add(node);
            visit[node.e] = true;

            for (int i=0;i<map[node.e].size();i++){
                Node next = map[node.e].get(i);
                if (visit[next.e])continue;

                pq.offer(next);
            }

        }
        int min = Integer.MAX_VALUE;
        boolean[] pass = new boolean[2];
        for (int i=1;i<lines.size();i++){
            Node node = lines.get(i);
            min=Math.min(min,node.cost);
            if (node.s==start||node.e==start)pass[0]=true;
            if (node.s==end||node.e==end)pass[1]=true;
            if (pass[0]&&pass[1])break;
        }
        System.out.println(min);
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
            return (this.cost<o.cost)?1:-1;
        }
    }
}
