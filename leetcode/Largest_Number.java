package LEETCODE;

import java.math.BigInteger;
import java.util.Deque;
import java.util.PriorityQueue;

public class Largest_number {
    public static void main(String[] args) {
        int[] nums={3,30,34,5,9};

        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            BigInteger temp1=new BigInteger(a+b);
            BigInteger temp2=new BigInteger(b+a);
            return temp2.compareTo(temp1);
        });


        for (int i=0;i<nums.length;i++){
            pq.offer(nums[i]+"");
        }
        StringBuilder sb=new StringBuilder();

        while (!pq.isEmpty()){
            sb.append(pq.poll());
        }
    }
}
