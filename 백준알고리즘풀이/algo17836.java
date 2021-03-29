package 백준;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class algo17836 {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");

        int n=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);
        int T=Integer.parseInt(str[2]);

        int[][] map = new int[n+1][m+1];

        for (int i=1;i<=n;i++){
            str=br.readLine().split(" ");
            for (int j=1;j<=str.length;j++){
                map[i][j]=Integer.parseInt(str[j-1]);
            }
        }


        int swordMin = Integer.MAX_VALUE;
        boolean[][] visit = new boolean[n+1][m+1];
        visit[1][1]=true;

        Queue<Point> q = new LinkedList<>();
        boolean isPossible=false;
        boolean isSword=false;
        int turn=0;
        q.offer(new Point(1,1));

        while (!q.isEmpty()){
            boolean isFinish=false;
            turn++;
            if (turn>T){
                System.out.println("Fail");
                return;
            }
            int size=q.size();
            for (int i=0;i<size;i++){
                Point now = q.poll();
                int x=now.x;
                int y=now.y;
                for (int j=0;j<4;j++){
                    int nx=x+dx[j];
                    int ny=y+dy[j];
                    if (nx<1||ny<1||nx>n||ny>m)continue;
                    if (visit[nx][ny]||map[nx][ny]==1)continue;

                    if (map[nx][ny]==2){
                        swordMin=turn+(n-nx)+(m-ny);
                        if (swordMin<=T)isSword=true;
                        visit[nx][ny]=true;
                        q.offer(new Point(nx,ny));
                    }else if (map[nx][ny]==0){
                        visit[nx][ny]=true;
                        q.offer(new Point(nx,ny));
                    }

                    if (nx==n&&ny==m){
                        isPossible=true;
                        isFinish=true;
                    }
                }

            }
            if (isFinish)break;
        }
        if (isPossible&&isSword)System.out.println(Math.min(turn,swordMin));
        else if (isPossible&&!isSword)System.out.println(turn);
        else if (!isPossible&&isSword)System.out.println(swordMin);
        else System.out.println("Fail");
    }
}
