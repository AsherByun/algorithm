package 프로그래머스;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 야근지수 {
    public static void main(String[] args) {
        int n = 99;
        int[] works = {2,15,22,55,55};

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2?-1:1;
            }
        });
        for (int i=0;i<works.length;i++)pq.offer(works[i]);

        while (n>0){
            int temp=pq.poll();
            pq.offer(temp-1);
            n--;
            if (pq.peek()==0)break;
        }
        long ans = 0;

        while (!pq.isEmpty()){
            int t=pq.poll();
            ans += t*t;
        }
        System.out.println(ans);
    }
}
