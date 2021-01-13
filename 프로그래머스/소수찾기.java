package 프로그래머스;

import java.util.HashSet;

public class 소수찾기 {
    static int max;
    static HashSet<Integer> hset;
    static String[] str;
    static boolean[] dp;
    public static void main(String[] args) {
        String numbers="011";

        str = numbers.split("");
        hset = new HashSet<>();
        max = 0;
        make(0,new boolean[str.length],"");
        dp=new boolean[max+1];
        dp[1]=true;
        dp[0]=true;
        for (int i=2;i<=max;i++){
            if (!dp[i]){
                for (int j=2;i*j<=max;j++){
                    dp[j*i] = true;
                }
            }
        }
        int total=0;
        for (Integer num:hset){
            if (!dp[num])total++;
        }
        System.out.println(total);
    }
    static void make(int idx,boolean[] visit,String s){

        if (idx==str.length){
            return;
        }

        for (int i=0;i<str.length;i++){
            if (!visit[i]){
                visit[i]=true;
                int num = Integer.parseInt(s+str[i]);
                max = Math.max(num,max);
                hset.add(num);
                make(idx+1,visit,s+str[i]);
                visit[i]=false;
            }
        }

    }
}
