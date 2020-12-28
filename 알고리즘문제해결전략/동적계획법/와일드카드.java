package 알고리즘문제해결전략.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//완탐 + 동적계획법
public class 와일드카드 {
    static int dp[][];
    static String S,W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testc=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc=0;tc<testc;tc++){
            W = br.readLine();
            int n=Integer.parseInt(br.readLine());

            for (int i=0;i<n;i++){
                dp = new int[101][101];
                S = br.readLine();

                if (match_ver1(0,0)){
                    sb.append(S+"\n");
                }
            }

        }
        System.out.print(sb.toString());
    }
    static boolean match_ver1(int w,int s){

        if (dp[w][s] != 0){
            return (dp[w][s]==2)?true:false;
        }

        while (s<S.length()&&w<W.length()&&(W.charAt(w)=='?'||W.charAt(w)==S.charAt(s))){
            ++w;++s;
        }

        if (w==W.length()){
            if (s==S.length()){
                dp[w][s] = 2;
                return true;
            }else{
                dp[w][s] = 1;
                return false;
            }
        }

        if (W.charAt(w)=='*'){
            for (int skip=0;skip+s<=S.length();++skip){
                if (match_ver1(w+1,skip+s)){
                    dp[w][s]=2;
                    return true;
                }
            }
        }
        dp[w][s]=1;
        return false;
    }
    //반복문 제거
    static boolean match_ver2(int w,int s){
        if (dp[w][s] != 0){
            return (dp[w][s]==2)?true:false;
        }
        if (w<W.length()&&s<S.length()&&(W.charAt(w)=='?'||W.charAt(w)==S.charAt(s))){
            dp[w][s] = match_ver2(w+1,s+1) ? 2:1;
            return (dp[w][s]==2)?true:false;
        }
        if (W.charAt(w)=='*'){
            if ((s<S.length()&&match_ver2(w,s+1))||match_ver2(w+1,s)){
                dp[w][s]=2;
                return true;
            }
        }
        dp[w][s]=1;
        return false;
    }
}
