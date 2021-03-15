package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class algo2887 {
    static int n;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        if (n==1){
            System.out.println(0);
            return;
        }

        Point[] p=new Point[n];
        parent=new int[n];
        for (int i=1;i<n;i++)parent[i]=i;

        for (int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            p[i]=new Point(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]),i);
        }
        PriorityQueue<Node> pq =new PriorityQueue<>();
        Arrays.sort(p, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x<o2.x?-1:1;
            }
        });
        for (int i=1;i<p.length;i++){
            pq.offer(new Node(p[i-1].idx,p[i].idx,p[i].x-p[i-1].x));
        }
        Arrays.sort(p, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y<o2.y?-1:1;
            }
        });
        for (int i=1;i<p.length;i++){
            pq.offer(new Node(p[i-1].idx,p[i].idx,p[i].y-p[i-1].y));
        }
        Arrays.sort(p, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.z<o2.z?-1:1;
            }
        });
        for (int i=1;i<p.length;i++){
            pq.offer(new Node(p[i-1].idx,p[i].idx,p[i].z-p[i-1].z));
        }

        int ans=0;
        while (!pq.isEmpty()){
            Node node=pq.poll();
            int s=node.s;int e=node.e;
            if (isSameParent(s,e))continue;
            ans+=node.cost;
            union(s,e);
        }
        System.out.println(ans);
    }
    static int find(int x){
        if (x==parent[x])return x;
        else return parent[x]=find(parent[x]);
    }
    static void union(int x,int y){
        x=find(x);
        y=find(y);
        if (x<y)parent[y]=x;
        else parent[x]=y;
    }
    static boolean isSameParent(int x,int y){
        return find(x)==find(y);
    }

    static class Point{
        int x,y,z,idx;
        Point(int x,int y,int z,int idx){
            this.x=x;this.y=y;this.z=z;this.idx=idx;
        }
    }
    static class Node implements Comparable<Node>{
        int s,e,cost;
        Node(int s,int e,int cost){
            this.s=s;this.e=e;this.cost=cost;
        }
        @Override
        public int compareTo(Node o) {
            return (this.cost<o.cost)?-1:1;
        }
    }
}
