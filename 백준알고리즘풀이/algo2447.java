package 백준;

import java.io.*;
import java.util.Scanner;

public class algo2447 {
    static char str[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        str = new char[n+1][n+1];

        find(1,1,n);
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++) {
                sb.append(str[i][j]);
            }sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    static void find(int x,int y,int m){
        int k=m/3;
        if (m==1){
            str[x][y]='*';
            return;
        }

        find(x,y,k);find(x,y+k,k);find(x,y+2*k,k);
        find(x+k,y,k);
        for (int i=x+k;i<x+2*k;i++){
            for (int j=y+k;j<y+2*k;j++){
                str[i][j]=' ';
            }
        }
        find(x+k,y+2*k,k);
        find(x+2*k,y,k);find(x+2*k,y+k,k);find(x+2*k,y+k*2,k);
    }
}
/*
    String 으로 +계산하는것보다 그냥 char 배열이더 훨씬 빠르다
 */