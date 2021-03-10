package 프로그래머스;

import java.util.*;

public class 셔틀버스 {
    static int[] times;
    public static void main(String[] args) {
        int n=10;
        int t=60;
        int m=45;
        String[] timetable={"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};

        times = new int[timetable.length];
        convertToint(timetable);
        int start = 1;
        int end = 23*60+59;
        int ans = start;
        while (start<=end){
            int mid = (start+end)/2;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int j=0;j<times.length;j++){
                Node node = new Node(times[j]);
                pq.offer(node);
            }
            Node node = new Node(mid);
            node.isTarget=true;
            pq.offer(node);

            if (find(pq,t,m,n)){
                ans=mid;
                start = mid +1;
            }else{
                end = mid-1;
            }
        }
        System.out.println(convertToString(ans));
    }
    static boolean find(PriorityQueue<Node> pq,int t,int m,int n){

        for (int i=0;i<n;i++){
            int hour = 9*60 + i*t;
            for (int j=1;j<=m;j++){
                if (pq.isEmpty()||pq.peek().time>hour)break;
                Node node=pq.poll();
                if (node.isTarget)return true;
            }
        }

        return false;
    }

    static void convertToint(String[] time){
        for (int i=0;i<time.length;i++){
            String[] str = time[i].split(":");
            times[i] = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
        }
    }
    static String convertToString(int time){
        String hour = time/60 +"";
        String minu = time%60 +"";
        if (hour.length()==1)hour="0"+hour;
        if (minu.length()==1)minu="0"+minu;
        return hour+":"+minu;
    }
    static class Node implements Comparable<Node>{
        int time;
        boolean isTarget=false;

        Node(int time){
            this.time=time;
        }

        @Override
        public int compareTo(Node o) {
            if (this.time<o.time)return -1;
            else if (this.time>o.time)return 1;
            else{
                if (this.isTarget)return 1;
                else return -1;
            }
        }
    }
}
