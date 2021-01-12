package 프로그래머스;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    static int w,h;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int area,size;
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture ={{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        h = m;
        w = n;
        boolean[][] visit = new boolean[h][w];
        area =0; size=0;

        for (int i=0;i<h;i++){
            for (int j=0;j<w;j++){
                if (picture[i][j]==0)continue;
                if (!visit[i][j]){
                    area++;
                    bfs(i,j,visit,picture);
                }
            }
        }
        System.out.print(area+"  "+size);
    }
    static void bfs(int x,int y,boolean[][] visit,int[][] picture){
        Queue<Point> q = new LinkedList<>();
        int val = picture[x][y];
        int tsize=0;
        visit[x][y]=true;
        q.offer(new Point(x,y));

        while (!q.isEmpty()){
            Point p = q.poll();
            tsize++;
            for (int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if (nx>=0&&ny>=0&&nx<h&&ny<w){
                    if (!visit[nx][ny]&&val==picture[nx][ny]){
                        visit[nx][ny]=true;
                        q.offer(new Point(nx,ny));
                    }
                }
            }

        }
        size=Math.max(size,tsize);

    }
}
