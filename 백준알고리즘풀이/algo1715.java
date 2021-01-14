package 백준;

import java.util.PriorityQueue;
import java.util.Scanner;

public class algo1715 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n=scan.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<n;i++)pq.offer(scan.nextInt());
        int ans=0;
        while (pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            ans +=a+b;
            pq.offer(a+b);
        }
        System.out.println(ans);
    }
}
