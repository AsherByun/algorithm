package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class algo11049 {
    static int[][] map;
    static int n;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map=new int[n][2];
        dp=new int[n][n];

        for (int i=0;i<n;i++){
            String[] str=br.readLine().split(" ");
            map[i][0]=Integer.parseInt(str[0]);
            map[i][1]=Integer.parseInt(str[1]);
        }
        System.out.println(find(0,n-1));

    }
    static int find(int a,int b){
        if (a==b)return 0;
        if (dp[a][b]!=0)return dp[a][b];

        int min =Integer.MAX_VALUE;

        for (int i=a;i<b;i++){
            min = Math.min(min,find(a,i)+find(i+1,b)+map[a][0]*map[i][1]*map[b][1]);
        }

        dp[a][b]=min;
        return min;
    }
}
