package 코테복기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class back1197최소스패닝 {
    static int n,m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");

        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);

        PriorityQueue<Node> pq=new PriorityQueue<>();

        for (int i=0;i<m;i++){
            String[] st=br.readLine().split(" ");
            int s=Integer.parseInt(st[0]);
            int e=Integer.parseInt(st[1]);
            int w=Integer.parseInt(st[2]);
            pq.offer(new Node(s,e,w));
        }
        parent=new int[n+1];
        for (int i=1;i<=n;i++)parent[i]=i;

        int sum=0;

        while (!pq.isEmpty()){
            Node node = pq.poll();
            if (isSame(node.s,node.e))continue;
            union(node.s,node.e);
            sum+=node.w;
        }
        System.out.println(sum);
    }
    static boolean isSame(int x,int y){
        return find(x)==find(y);
    }
    static void union(int x,int y){
        x=find(x);
        y=find(y);
        if (x<y)parent[y]=x;
        else parent[x]=y;
    }
    static int find(int x){
        if (x==parent[x]){
            return x;
        }else{
            return parent[x]=find(parent[x]);
        }
    }
    static class Node implements Comparable<Node>{
        int s,e,w;

        public Node(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }


        @Override
        public int compareTo(Node o) {
            return this.w<o.w?-1:1;
        }
    }
}
