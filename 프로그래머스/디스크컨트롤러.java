package 프로그래머스;

import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3},{1, 9},{2, 6}};

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i=0;i<jobs.length;i++){
            Node node = new Node(jobs[i][0],jobs[i][1]);
            pq.offer(node);
        }
        int last=-1;
        int cost=0;
        while (!pq.isEmpty()){
            Node now = pq.poll();
//            System.out.println(now.start +"  "+ (now.start+now.len)+"  "+now.len+"  "+ now.up+"  "+cost);
            if (now.start<last){
                int temp = last-now.start;
                now.start = now.start + temp;
                now.up = now.up+temp;
                pq.offer(now);
                continue;
            }

            last = now.start + now.len;
            cost += now.up + now.len;

        }
        cost = cost / jobs.length;
        System.out.println(cost);

    }
    static class Node implements Comparable<Node>{
        int start;
        int len;
        int up=0;
        Node(int start,int len){
            this.start=start;
            this.len = len;
        }
        @Override
        public int compareTo(Node o) {
            if (this.start<o.start)return -1;
            else if (this.start>o.start)return 1;
            else{
                return (this.len<o.len)?-1:1;
            }
        }
    }
}
