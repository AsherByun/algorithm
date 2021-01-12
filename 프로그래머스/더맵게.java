package 프로그래머스;

import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {
        int[] sco={1,2,3,9,10,12};
        int k=7;

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int cnt=0;
        for (int i=0;i<sco.length;i++)pq.offer(sco[i]);
        while (pq.size()>1){
            if (pq.peek()<k){
                int a=pq.poll();
                int b=pq.poll();

                pq.offer(a+b*2);
                cnt++;
            }else{
                break;
            }
        }

        if (pq.peek()<k)System.out.print(-1);
        else System.out.print(cnt);
    }
}
