package 알고리즘문제해결전략;

import java.util.ArrayList;

public class 조합 {
    public static void main(String[] args) {
        int n = 5;
        int s = 4;

        combination(n,new ArrayList<>(),0,s);

    }
    static void combination(int n, ArrayList<Integer> arr,int next,int s){
        if (arr.size()==s){
            System.out.println(arr);
            return;
        }

        for (int i=next;i<n;i++){
            arr.add(i);
            combination(n,arr,i+1,s);
            arr.remove(arr.size()-1);
        }

    }
}
