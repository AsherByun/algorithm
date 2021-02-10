package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class algo1647스패닝트리 {
    static int n;
    static int m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);
        parent=new int[n+1];
        for (int i=1;i<=n;i++){
            parent[i]=i;
        }
        PriorityQueue<Node> pq=new PriorityQueue<>();

        for (int i=0;i<m;i++){
            str = br.readLine().split(" ");
            int s=Integer.parseInt(str[0]);
            int e=Integer.parseInt(str[1]);
            int c=Integer.parseInt(str[2]);
            pq.offer(new Node(s,e,c));
        }
        PriorityQueue<Node> ans = new PriorityQueue<>();

        while (!pq.isEmpty()){
            Node now = pq.poll();

            if (isSameParent(now.e,now.s))continue;
            union(now.s,now.e);
            ans.offer(now);

        }
        int sum=0;
        while (ans.size()>1){
            Node now = ans.poll();
            sum+=now.cost;
        }
        System.out.println(sum);
    }
    static boolean isSameParent(int x,int y){
        x=find(x);
        y=find(y);
        return x==y;
    }
    static void union(int x,int y){
        x=find(x);
        y=find(y);

        if (x>y){
            parent[x]=y;
        }else{
            parent[y]=x;
        }
    }
    static int find(int x){
        if (x==parent[x]){
            return x;
        }else{
            return parent[x]=find(parent[x]);
        }
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
