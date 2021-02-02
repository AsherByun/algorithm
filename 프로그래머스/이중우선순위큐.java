package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;


public class 이중우선순위큐 {
    static ArrayList<Integer> arr;
    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        arr = new ArrayList<>();

        for (int i=0;i<operations.length;i++){
            String str[] = operations[i].split(" ");

            if (str[0].equals("I")){
                int num = Integer.parseInt(str[1]);

                inputing(num);
            }else if (str[0].equals("D")){
                if (str[1].equals("1")&&!arr.isEmpty()){
                    arr.remove(arr.size()-1);
                }else if (!arr.isEmpty()){
                    arr.remove(0);
                }
            }
        }
        int[] ans = {0,0};
        if (arr.isEmpty()){
            System.out.println(0+"  "+0);
            return;
        }
        int max = arr.get(arr.size()-1);
        int min = arr.get(0);
        System.out.println(max+" "+min);
    }
    static void inputing(int num){

        int idx = Collections.binarySearch(arr,num);
        if (idx<0)idx=(-idx)-1;

        arr.add(idx,num);

    }
}
