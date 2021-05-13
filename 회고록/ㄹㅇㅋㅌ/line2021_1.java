package 라인코테;
import java.util.*;
import java.awt.*;
public class line2021_1 {
    static int map[][];
    public static void main(String[] args) {
        int[][] boxes={{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
        map=boxes;
        HashMap<Integer,Integer> h=new HashMap();
        HashSet<Integer> set=new HashSet();
        for (int i=0;i<boxes.length;i++){
            int a=boxes[i][0]; int b=boxes[i][1];
            if (h.containsKey(a)){
                h.put(a,h.get(a)+1);
            }else {
                h.put(a,1);
            }
            if (h.containsKey(b)){
                h.put(b,h.get(b)+1);
            }else {
                h.put(b,1);
            }
            set.add(a);set.add(b);
        }
        int up=0;
        int size=map.length;

        for (int i:set){
            int temp=h.get(i);
            if(temp>=2){up++;}
        }
        int res=size-up;
        if(res<=0){
            System.out.println(0);
        }else{
            System.out.println(res);
        }


    }
}
