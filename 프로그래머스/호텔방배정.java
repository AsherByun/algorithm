package 프로그래머스;

import java.util.HashMap;

public class 호텔방배정 {
    static HashMap<Long,Long> parent;
    public static void main(String[] args) {
        long k=10;
        long[] room_number = {1,3,4,1,3,1};
        parent = new HashMap<>();


        long[] res = new long[room_number.length];
        for (int i=0;i<room_number.length;i++){
            long n = room_number[i];
            res[i]=find(n);
        }
        return;
    }

    static long find(long x){
        if (!parent.containsKey(x)){
            parent.put(x,x+1);
            return x;
        }

        long next = parent.get(x);
        long empty = find(next);
        parent.put(x,empty);
        return empty;
    }

}
