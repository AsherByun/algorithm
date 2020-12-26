package 알고리즘;

import java.lang.reflect.Array;
import java.util.*;

public class 다익스트라_우선순위큐 {
    static int n,m,k,x;
    static int distance[];
    static boolean visit[];
    static ArrayList<Integer> map[];
    static node node[];
    static ArrayList<Integer> res;
    static class node implements Comparable<node>{
        int idx;
        int dst;
        boolean visit=false;
        node(int idx,int dst){
            this.dst=dst; this.idx=idx;
        }

        @Override
        public int compareTo(node o) {
            return this.dst-o.dst;
        }
    }
    static void dijkstra(){
        PriorityQueue<node> pq=new PriorityQueue<>();
        distance=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[x]=0;
        pq.offer(new node(x,0));

        while (!pq.isEmpty()){
            node tnode=pq.poll();
            int cost=tnode.dst; int here=tnode.idx;
//            if(distance[here]<cost)
//                continue;

            for (int i=0;i<map[here].size();i++){
                int end=(int)map[here].get(i);
                if(distance[end]>distance[here]+1){
                    distance[end]=distance[here]+1;
                    pq.offer(new node(end,distance[end]));
                }
            }
        }
        for (int i=1;i<=n;i++){
            if (distance[i]==k){
                res.add(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt(); m=scan.nextInt(); k=scan.nextInt(); x=scan.nextInt();
        map=new ArrayList[n+1];
        res=new ArrayList<>();
        for (int i=1;i<=n;i++){
            map[i]=new ArrayList<Integer>();
        }

        for (int i=0;i<m;i++){
            int s=scan.nextInt(); int e=scan.nextInt();
            map[s].add(e);
        }
        dijkstra();
        if (res.size()==0){
            System.out.println(-1);
        }else{
            for (int i=0;i<res.size();i++){
                System.out.println(res.get(i));
            }
        }
    }
}
