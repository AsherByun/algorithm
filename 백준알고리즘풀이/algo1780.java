package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class algo1780 {
    static int[][] map;
    static int n;
    static HashMap<Integer,Integer> count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        count = new HashMap<>();
        count.put(-1,0);
        count.put(1,0);
        count.put(0,0);
        map = new int[n+1][n+1];
        for (int i=1;i<=n;i++){
            String[] str=br.readLine().split(" ");
            for (int j=1;j<=n;j++){
                map[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        find(1,1,n);
        for (int i=-1;i<=1;i++){
            System.out.println(count.get(i));
        }

    }
    static void find(int x,int y,int m){
        int k = m/3;
        int num = isSame(x,y,m);
        if (num!=2){
            count.put(num,count.get(num)+1);
            return;
        }
        find(x,y,k);find(x+k,y,k);find(x+2*k,y,k);
        find(x,y+k,k);find(x+k,y+k,k);find(x+2*k,y+k,k);
        find(x,y+2*k,k);find(x+k,y+2*k,k);find(x+2*k,y+2*k,k);

    }
    static int isSame(int x,int y,int m){
        int compare = map[x][y];
        for (int i=x;i<x+m;i++){
            for (int j=y;j<y+m;j++){
                if (map[i][j]!=compare)return 2;
            }
        }
        return compare;
    }
}
