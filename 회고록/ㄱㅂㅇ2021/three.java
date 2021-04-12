package 가비아;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class three {
    public static void main(String[] args) {
        int N=3;
        int[] coffee_times={4,2,2,5,3};

        PriorityQueue<Node> pq=new PriorityQueue<>();
        ArrayList<Integer> orders=new ArrayList<>();
        long time=0;
        for (int i=0;i<coffee_times.length;i++){
            if (pq.size()<N){
                pq.offer(new Node(i+1,time+coffee_times[i]));
            }else{
                Node firstNode = pq.poll();
                time=firstNode.endTime;
                orders.add(firstNode.idx);
                pq.offer(new Node(i+1,time+coffee_times[i]));
            }
        }
        while (!pq.isEmpty()){
            Node node=pq.poll();
            orders.add(node.idx);
        }
        int[] answer = new int[orders.size()];
        for (int i=0;i<orders.size();i++){
            answer[i]=orders.get(i);
        }
    }
    static class Node implements Comparable<Node>{
        int idx;
        long endTime;

        Node(int idx,long endTime){
            this.idx=idx;
            this.endTime=endTime;
        }

        @Override
        public int compareTo(Node o) {
            if (this.endTime<o.endTime){
                return -1;
            }else if (this.endTime>o.endTime){
                return 1;
            }else{
                return this.idx<o.idx?-1:1;
            }
        }
    }
}
