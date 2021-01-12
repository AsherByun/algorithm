package 백준;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class algo1194비트마스킹 {
    static int[][][] dp;
    static final int INF = Integer.MAX_VALUE;
    static int n,m;
    static char[][] map;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str=  br.readLine().split(" ");
        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);
        setting();
        Point startPoint = new Point(0,0);
        for (int i=1;i<=n;i++){
            char c[] = br.readLine().toCharArray();
            for (int j=1;j<=m;j++){
                map[i][j] = c[j-1];
                if (map[i][j]=='0'){
                    startPoint=new Point(i,j);
                    map[i][j]='.';
                }
            }
        }
        System.out.println(find(startPoint));

    }
    static int find(Point startP) {
        Queue<Node> q = new LinkedList<>();
        dp[startP.x][startP.y][0] = 0;
        q.offer(new Node(startP.x,startP.y,0));
        int time=0;

        while (!q.isEmpty()){
            int size = q.size();
            for (int tc=0;tc<size;tc++){
                Node now = q.poll();
                int x=now.x;int y=now.y;

                for (int i=0;i<4;i++){
                    int nx=x+dx[i];
                    int ny=y+dy[i];

                    if (nx<=0||ny<=0||nx>n||ny>m)continue;

                    if (map[nx][ny]=='#')continue;

                    if (map[nx][ny]=='1')return time+1;

                    if (map[nx][ny]=='.'){
                        if (dp[nx][ny][now.visit]>dp[x][y][now.visit]+1){
                            dp[nx][ny][now.visit] = dp[x][y][now.visit] +1;
                            q.offer(new Node(nx,ny,now.visit));
                        }
                    }

                    if (map[nx][ny]>='a'&&map[nx][ny]<='f'){
                        int visit = now.visit | (1<<(map[nx][ny]-'a'));
                        if (dp[nx][ny][visit]>dp[x][y][now.visit]+1){
                            dp[nx][ny][visit] = dp[x][y][now.visit]+1;
                            q.offer(new Node(nx,ny,visit));
                        }
                    }

                    if (map[nx][ny]>='A'&&map[nx][ny]<='F'){
                        int offset = (1<<(map[nx][ny]-'A'));
                        if ((now.visit & offset) > 0 && dp[nx][ny][now.visit] > dp[x][y][now.visit] +1){
                            dp[nx][ny][now.visit] = dp[x][y][now.visit] + 1;
                            q.offer(new Node(nx,ny, now.visit));
                        }
                    }

                }

            }time++;

        }
        return -1;

    }
    static class Node{
        int x,y;
        int visit;
        Node(int x,int y,int visit){
            this.x=x;
            this.y=y;
            this.visit=visit;
        }
    }
    static void setting(){
        dp = new int[n+1][m+1][(1<<6)];
        map = new char[n+1][m+1];

        for (int i=0;i<=n;i++){
            for (int j=0;j<=m;j++){
                Arrays.fill(dp[i][j],INF);
            }
        }
    }
}
