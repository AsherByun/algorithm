package 프로그래머스;

import java.awt.*;
import java.util.ArrayList;

public class 하노이탑 {
    static ArrayList<Point> arr;
    public static void main(String[] args) {
        int n = 2;

        arr=new ArrayList<>();
        move(1,2,3,n);
        int[][] ans = new int[arr.size()][2];
        for (int i=0;i<arr.size();i++){
            ans[i][0]=arr.get(i).x;
            ans[i][1]=arr.get(i).y;
        }


    }
    static void move(int from,int by,int to,int n){
        if (n==1){
            arr.add(new Point(from,to));
            return;
        }
        move(from,to,by,n-1);
        arr.add(new Point(from,to));
        move(by,from,to,n-1);
    }
}
