package 프로그래머스;

import java.util.*;

public class 광고삽입 {
    public static void main(String[] args) {
        String plays = "50:00:00";
        String advs = "50:00:00";
        String[] logs = {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"};

        int play = toTime(plays);
        int adv = toTime(advs);
        long[] dp = new long[3600 * 100];
        for (int i=0;i<logs.length;i++){
            String[] s = logs[i].split("-");
            int startTime = toTime(s[0]);
            int endTime = toTime(s[1]);
            dp[startTime]++; dp[endTime]--;
        }


        for (int i=1;i<play;i++){
            dp[i] = dp[i-1] +dp[i];
        }

        for (int i=1;i<play;i++){
            dp[i] = dp[i-1] +dp[i];
        }
        long max=0;
        long maxPoint=0;
        for (int i=adv-1;i<play;i++){
            if (i>=adv){
                if (max<dp[i]-dp[i-adv]){
                    max=dp[i] - dp[i-adv];
                    maxPoint = i-adv+1;
                }
            }else{
                max=Math.max(max,dp[i]);
            }
        }
        System.out.println(toStringTime(maxPoint));

    }
    static String toStringTime(long time){
        String str = "";

        long hour = time / 3600;
        time %= 3600;
        if (hour<10)str += "0"+hour + ":";
        else str+=hour + ":";

        long minu = time / 60;
        time %= 60;
        if (minu<10)str += "0"+minu + ":";
        else str+=minu + ":";

        long sec = time;
        if (sec<10)str += "0"+sec;
        else str+=sec;
        return str;
    }

    static int toTime(String s){
        String[] str = s.split(":");
        int time = Integer.parseInt(str[0])*3600 + Integer.parseInt(str[1])*60+Integer.parseInt(str[2]);
        return time;
    }
}
