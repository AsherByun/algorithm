package 프로그래머스;

import java.util.Arrays;
import java.util.HashSet;

public class 두개뽑아서더하기 {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<numbers.length;i++){
            for (int j=i+1;j<numbers.length;j++){
                set.add(numbers[i]+numbers[j]);
            }
        }

        int[] ans = new int[set.size()];
        int j=0;
        for (Integer i : set){
            ans[j++]=i;
        }
        Arrays.sort(ans);
    }
}
