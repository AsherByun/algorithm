package 프로그래머스;
import java.util.*;
public class 챌린지2_2 {
    static int[][] map;
    static ArrayList<Integer> res=new ArrayList<>();
    public static void main(String[] args) {
        int arr[][]={{0}};
        map=arr;

        split(map.length,0,0);

        int ans[]=new int[2];
        for (int i=0;i<res.size();i++){
            int temp=res.get(i);
            if (temp==0)ans[0]++;
            else ans[1]++;
        }
        System.out.println(ans[0]+"  "+ans[1]);
    }
    static void split(int range,int x,int y){
        int a=map[x][y];
        boolean can=true;
        for (int i=x;i<x+range;i++){
            for (int j=y;j<y+range;j++){
                if (a!=map[i][j])can=false;
            }
        }
        if (can){
            res.add(a);
            return;
        }else{
            split(range/2,x,y);
            split(range/2,x+range/2,y);
            split(range/2,x,y+range/2);
            split(range/2,x+range/2,y+range/2);
        }


    }

}
