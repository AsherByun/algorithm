package 프로그래머스;

import java.util.Arrays;
import java.util.Comparator;

public class 매칭22 {
    public static void main(String[] args) {
        int[] numbers = {40, 403};

        Comparator comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Integer.parseInt(o1+o2)>=Integer.parseInt(o2+o1))return -1;
                else return 1;
            }
        };
        String[] nums = new String[numbers.length];

        for (int i=0;i<nums.length;i++){
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums,comparator);
        String ans="";
        for (int i=0;i<nums.length;i++){
            ans+=nums[i];
        }
        int zero=0;
        for (int i=0;i<ans.length();i++){
            if (ans.charAt(i)=='0')zero++;
        }
        if (zero==ans.length()){
            ans="0";
        }
        System.out.print(ans);
    }
}
