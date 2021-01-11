package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        int blen = 100;
        int weight = 100;
        int tweight[] ={10};

        int total=0;
        int time=0;
        Queue<Integer> q= new LinkedList<>();
        int idx=0;

        for (int i=0;i<blen;i++)q.offer(0);

        while (idx<tweight.length){
            if (q.size()>=blen){
                int out=q.poll();
                total-=out;
            }
            if (total+tweight[idx]<=weight){
                q.offer(tweight[idx]);
                total+=tweight[idx++];
            }else{
                q.offer(0);
            }
            time++;
        }
        if (!q.isEmpty()){
            time+=q.size();
        }
        System.out.println(time);
    }
}
