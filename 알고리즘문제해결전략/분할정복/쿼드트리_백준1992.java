package 알고리즘문제해결전략.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리_백준1992 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];

        for (int i=1;i<=n;i++){
            String[] str = br.readLine().split("");
            for (int j=1;j<=n;j++){
                map[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        int a = map[1][1];
        boolean can=true;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if (a!=map[i][j])can=false;
            }
        }
        if (can){
            System.out.println(a);
            return;
        }


        String ans = "(" + quard(n,1,1);
        System.out.println(ans);

    }
    static String quard(int m,int x,int y){
        int n = m/2;
        String returnStr = "";

        boolean can=true;
        int a = map[x][y];
        for (int i=x;i<x+n;i++){
            for (int j=y;j<y+n;j++){
                if (a!=map[i][j]){
                    can=false;
                }
            }
        }
        if (can)returnStr += Integer.toString(a);
        else returnStr += "(" + quard(n,x,y);
        can=true;
        a=map[x][y+n];
        for (int i=x;i<x+n;i++){
            for (int j=y+n;j<y+m;j++){
                if (a!=map[i][j]){
                    can=false;
                }
            }
        }
        if (can)returnStr += Integer.toString(a);
        else returnStr += "(" + quard(n,x,y+n);
        can=true;
        a=map[x+n][y];
        for (int i=x+n;i<x+m;i++){
            for (int j=y;j<y+n;j++){
                if (a!=map[i][j]){
                    can=false;
                }
            }
        }
        if (can)returnStr += Integer.toString(a);
        else returnStr += "(" + quard(n,x+n,y);
        can=true;
        a=map[x+n][y+n];
        for (int i=x+n;i<x+m;i++){
            for (int j=y+n;j<y+m;j++){
                if (a!=map[i][j]){
                    can=false;
                }
            }
        }
        if (can)returnStr += Integer.toString(a);
        else returnStr += "(" + quard(n,x+n,y+n);
        can=true;
        return returnStr + ")";
    }
}
