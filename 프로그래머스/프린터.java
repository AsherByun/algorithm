package 프로그래머스;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class 프린터 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int ans=0;
        LinkedList<Integer> list=new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0;i<priorities.length;i++) {
            list.add(priorities[i]);
            pq.offer(-priorities[i]);
        }

        while (!pq.isEmpty()){
            ans++;
            int now = -pq.poll();

            while (true){
                if (list.get(0)==now){
                    break;
                }
                int temp=list.get(0);
                list.remove(0);
                list.add(temp);
                location--;
                if (location<0)location+=list.size();
            }
            if (location==0){
                break;
            }
            list.remove(0);
            location--;
        }


        System.out.println(ans);
    }

}
