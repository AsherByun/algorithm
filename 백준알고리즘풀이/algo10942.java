package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo10942 {
    static int[][] dp;
    static int n,m;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        dp = new int[n+1][n+1];
        map = new int[n+1];
        for (int i=1;i<=n;i++)map[i]=Integer.parseInt(str[i-1]);
        StringBuilder sb=new StringBuilder();
        m=Integer.parseInt(br.readLine());
        for (int i=0;i<m;i++){
            str=br.readLine().split(" ");
            int s=Integer.parseInt(str[0]);
            int e=Integer.parseInt(str[1]);
            if (query(s,e)){
                sb.append(1+"\n");
            }else{
                sb.append(0+"\n");
            }
        }
        System.out.print(sb.toString());
    }
    static boolean query(int s,int e){
        if (s>=e)return true;
        if (dp[s][e]!=0){
            return (dp[s][e]==1)?false:true;
        }

        if (query(s+1,e-1)&&(map[s]==map[e])){
            dp[s][e]=2;
        }else{
            dp[s][e]=1;
        }

        return (dp[s][e]==1)?false:true;
    }
}
