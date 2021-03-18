package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo3109 {
    static int n,m;
    static int[][] map;
    static int max;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        visit=new boolean[n][m];
        map=new int[n][m];
        for (int i=0;i<n;i++){
            str=br.readLine().split("");
            for (int j=0;j<m;j++){
                if (str[j].equals(".")){
                    map[i][j]=0;
                }else{
                    visit[i][j]=true;
                    map[i][j]=1;
                }
            }
        }
        max=0;
        for (int i=0;i<n;i++){
            find(i,0);
        }
        System.out.println(max);
    }
    static int[] dx = {-1,0,1};
    static boolean find(int x,int y){
        if (y==m-1){
            max++;
            return true;
        }

        for (int i=0;i<3;i++){
            int nx=x+dx[i];
            int ny=y+1;

            if (nx<0||nx>n-1)continue;
            if (visit[nx][ny])continue;
            visit[nx][ny]=true;
            if(find(nx,ny)){
                return true;
            }
        }
        return false;
    }
}
