package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo2573 {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int g;
    static int[][] map;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");

        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);

        map=new int[n][m];

        for (int i=0;i<n;i++){
            str=br.readLine().split(" ");
            for (int j=0;j<m;j++)map[i][j]=Integer.parseInt(str[j]);
        }
        int time=0;
        while (true){
            time++;
            int sum=0;
            int[][] temp = new int[n][m];

            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    if (map[i][j]==0)continue;
                    int c=map[i][j];
                    for (int k=0;k<4;k++){
                        int nx=i+dx[k];
                        int ny=j+dy[k];
                        if (nx<0||ny<0||nx>=n||ny>=m)continue;
                        if (map[nx][ny]==0)c--;
                    }
                    temp[i][j]=(c<=0)?0:c;
                    sum+=temp[i][j];
                }
            }
            if (sum==0){
                System.out.println(0);
                return;
            }
            g=0;
            for (int i=0;i<n;i++){
                map[i]=temp[i].clone();
            }
            int[][] colors=new int[n][m];
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    if (colors[i][j]==0&&map[i][j]!=0){
                        g++;
                        colors[i][j]=g;
                        boolean[][] visit=new boolean[n][m];
                        visit[i][j]=true;
                        find(i,j,g,visit,colors);
                    }
                }
            }
            if (g>=2){
                break;
            }
        }
        System.out.println(time);
    }
    static void printMap(){
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                System.out.print(map[i][j]+" ");
            }System.out.println();
        }System.out.println("------------------");
    }
    static void find(int x,int y,int s,boolean[][] visit,int[][] colors){
        for (int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if (nx<0||ny<0||nx>=n||ny>=m)continue;
            if (visit[nx][ny])continue;
            if (map[nx][ny]==0)continue;
            colors[nx][ny]=s;
            visit[nx][ny]=true;
            find(nx,ny,s,visit,colors);
        }
    }
}
