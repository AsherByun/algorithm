package 라인코테;
import java.util.*;
import java.awt.*;
public class line2021_2 {
    static int map[];
    static int number[];
    static int num,last,start;
    static ArrayList<Integer> q=new ArrayList();
    public static void main(String[] args) {
        int ball[]={1, 2, 3, 4, 5, 6};
        int order[]={6, 2, 5, 1, 4, 3};
        map=ball;
        number=new int[ball.length];
        num=0;
        last=ball.length-1;
        start=0;
        for (int i=0;i<order.length;i++){
            int now=order[i];
            if(ball[last]==now){
                number[num]=now;
                last--;
                num++;
                back();
            }else if(ball[start]==now){
                number[num]=now;
                start++;
                num++;
                front();
            }else{
                q.add(now);
            }
        }

        for (int i=0;i<number.length;i++){
            System.out.println(number[i]);
        }

    }
    static void back(){
        for (int i=0;i<q.size();i++) {
            int now = q.get(i);
            if (map[last] == now) {
                number[num] = now;
                q.remove(i);
                last--;
                num++;
                back();
                return;
            }
        }
    }
    static void front() {
        for (int i=0;i<q.size();i++) {
            int now = q.get(i);
            if (map[start] == now) {
                number[num] = now;
                q.remove(i);
                start++;
                num++;
                front();
                return;
            }
        }
    }
}
