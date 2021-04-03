package 데브매칭2021;

import java.util.HashSet;

public class four {
    static int[] score;
    static HashSet<Integer> set;
    public static void main(String[] args) {
        int[] lottos = {44,1,0,0,31,25};
        int[] win_nums = {31,10,45,1,6,19};

        setUp(lottos);
        int[] ans = new int[]{findMax(win_nums),findMin(win_nums)};
        System.out.println(ans[0]+" "+ans[1]);
    }
    static void setUp(int[] lottos){
        score=new int[7];
        score[0]=6;score[1]=6;
        score[2]=5;score[3]=4;
        score[4]=3;score[5]=2;score[6]=1;

        set=new HashSet<>();
        for (int i=0;i<lottos.length;i++){
            if (lottos[i]!=0)
            set.add(lottos[i]);
        }

    }
    static int findMax(int[] win){
        int hiden = 6-set.size();
        int cnt=0;
        for (int i=0;i<win.length;i++){
            if (set.contains(win[i]))cnt++;
        }
        cnt+=hiden;
        return score[cnt];
    }
    static int findMin(int[] win){
        int cnt=0;
        for (int i=0;i<win.length;i++){
            if (set.contains(win[i]))cnt++;
        }
        return score[cnt];
    }
}
