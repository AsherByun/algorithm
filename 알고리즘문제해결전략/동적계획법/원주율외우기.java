package 알고리즘문제해결전략.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 원주율외우기 {
    static int[] arr;
    static int[] dp;
    static String word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for (int tc=0;tc<n;tc++) {
            word = br.readLine();
            dp = new int[word.length()];
            Arrays.fill(dp,Integer.MAX_VALUE);
            sb.append(find(0)+"\n");
        }
        System.out.print(sb.toString());
    }

    static int find(int idx){
        if(idx>word.length()-3)return 0;
        if (dp[idx]!=Integer.MAX_VALUE)return dp[idx];
        char now = word.charAt(idx);
        int cnt=1;
        int next=idx+1;
        for (;next<word.length();next++){
            if (now==word.charAt(next)){
                cnt++;
            }else
                break;
            if (cnt>=5)break;
        }
        if (cnt>=3){
            dp[idx] = Math.min(dp[idx],1+find(next+1));
        }
        cnt=1;
        for (next=idx+1;next<word.length();next++){
            if (word.charAt(next-1)-'0'+1==word.charAt(next)-'0'){
                cnt++;
            }else{
                break;
            }
            if (cnt>=5)break;
        }
        if (cnt>=3){
            dp[idx] = Math.min(dp[idx],2+find(next+1));
        }

        cnt=2;
        for (next=idx+2;next<word.length();next++){
            if (word.charAt(next-2)==word.charAt(next))cnt++;
            else break;
            if (cnt>=5)break;
        }
        if (cnt>=3){
            dp[idx] = Math.min(dp[idx],4+find(next+1));
        }
        int gap = word.charAt(idx)-'0' - (word.charAt(idx+1)-'0');
        cnt=2;
        for (next=idx+2;next<word.length();next++){
            if (word.charAt(next-1)-'0' - (word.charAt(next)-'0')==gap){
                cnt++;
            }else break;
            if (cnt>=5)break;
        }
        if (cnt>=3)dp[idx] = Math.min(dp[idx],5+find(next+1));

        for (next=idx+3;next<=idx+5;next++){
            dp[idx] = Math.min(dp[idx],find(next)+10);
        }
        return dp[idx];
    }
}
