package 프로그래머스;
import java.util.*;
public class 첼린지 {
    public static void main(String[] args) {
        int numbers[]={2,1,3,4,1};

        PriorityQueue pq=new PriorityQueue();
        HashSet set=new HashSet();
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                int temp=numbers[i]+numbers[j];
                if(!set.contains(temp)){
                    set.add(temp);
                    pq.add(temp);
                }
            }
        }
        int[] answer=new int[set.size()];
        int k=0;
        while (!pq.isEmpty()){
            answer[k]= (int) pq.poll();
            k++;
        }
        for (int i=0;i<set.size();i++){
            System.out.println(answer[i]);
        }
    }

}
