package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class 주식가격 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};

        int[] ans = new int[prices.length];
        ans[prices.length-1] = 0;
        for (int i=0;i<prices.length;i++){
            for (int j=i+1;j<prices.length;j++){
                if (prices[i]>prices[j]){
                    ans[i] = j-i;
                    break;
                }
                if (j==prices.length-1)ans[i]=j-i;
            }
        }
        for (int i=0;i<prices.length;i++)System.out.println(ans[i]);
    }
}
