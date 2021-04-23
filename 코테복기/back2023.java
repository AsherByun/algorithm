package 코테복기;

import java.util.PriorityQueue;
import java.util.Scanner;

public class back2023 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int n=scan.nextInt();
        PriorityQueue<Integer> pq =new PriorityQueue();

        pq.offer(2);
        pq.offer(3);
        pq.offer(5);
        pq.offer(7);


        StringBuilder sb=new StringBuilder();
        while (!pq.isEmpty()){
            int now=pq.poll();
            if (((int)Math.log10(now))==n-1){
                sb.append(now+"\n");
                continue;
            }

            for(int i=0;i<=9;i++){
                int temp = now*10+i;
                if(check(temp)){
                    pq.offer(temp);
                }
            }

        }
        System.out.println(sb.toString());
    }
    static boolean check(int k){

        for(int i=2;i<=Math.sqrt(k);i++){
            if(k%i==0)return false;
        }
        return true;
    }
}
