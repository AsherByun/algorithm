package 백준;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class algo17472 {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int[][] lands;
    static int[][] map;
    static int[][] bridge;
    static int[] parent;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");

        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);

        map=new int[n+1][m+1];
        for (int i=1;i<=n;i++){
            str=br.readLine().split(" ");
            for (int j=1;j<=m;j++){
                map[i][j]=Integer.parseInt(str[j-1]);
            }
        }
        ArrayList<Point> startP=new ArrayList<>();

        lands=new int[n+1][m+1];
        boolean[][] visit=new boolean[n+1][m+1];
        int num=1;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if (visit[i][j]||map[i][j]!=1)continue;
                visit[i][j]=true;
                lands[i][j]=num;
                startP.add(new Point(i,j));
                splitLands(i,j,num++,visit);
            }
        }
//        for (int i=1;i<=n;i++){
//            for (int j=1;j<=m;j++){
//                System.out.print(lands[i][j]+" ");
//            }System.out.println();
//        }
        bridge=new int[num][num];
        for (int i=0;i<num;i++) Arrays.fill(bridge[i],Integer.MAX_VALUE);

        for (int i=0;i<startP.size();i++){
            linking(i+1,startP.get(i));
        }
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for (int i=1;i<num;i++) {
            for (int j = 1; j < num; j++) {
                pq.offer(new Node(i,j,bridge[i][j]));
            }
        }
        boolean[] v=new boolean[num];
        parent=new int[num];
        for (int i=0;i<num;i++)parent[i]=i;

        int sum=0;
        while (!pq.isEmpty()){
            Node node=pq.poll();
            int x=node.x;int y=node.y;int len=node.len;
            if (isSameParent(x,y)||len<2||len==Integer.MAX_VALUE)continue;
            v[x]=true;v[y]=true;
            sum+=len;
            union(x,y);
        }
        for (int i=1;i<num;i++)
            if (!v[i]){
            System.out.println(-1);return;
        }
        System.out.println(sum);
    }
    static int find(int x){
        if (x==parent[x])return x;
        else return parent[x]=find(parent[x]);
    }
    static boolean isSameParent(int x,int y){
        return find(x)==find(y);
    }
    static void union(int x,int y){
        x=find(x);
        y=find(y);
        if (x<y)parent[y]=x;
        else parent[x]=y;
    }
    static class Node implements Comparable<Node>{
        int len,x,y;
        Node(int x,int y,int len){
            this.len=len;this.x=x;this.y=y;
        }
        @Override
        public int compareTo(Node o) {
            return this.len<o.len?-1:1;
        }
    }

    static void linking(int num,Point start){

        Queue<int[]> q=new LinkedList<>();
        boolean[][] visit=new boolean[n+1][m+1];
        visit[start.x][start.y]=true;
        q.offer(new int[]{start.x,start.y,0,5});

        while (!q.isEmpty()){
            int[] now = q.poll();
            int x=now[0];int y=now[1];int len=now[2];int direct=now[3];

            if (lands[x][y]==num) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                    if (visit[nx][ny]) continue;
                    if (lands[nx][ny] != num && lands[nx][ny] != 0 && len >= 2) {
                        bridge[num][lands[nx][ny]] = Math.min(bridge[num][lands[nx][ny]], len);
                        bridge[lands[nx][ny]][num] = Math.min(bridge[lands[nx][ny]][num], len);
                        visit[nx][ny] = true;
                    } else if (lands[nx][ny] == 0) {
                        visit[nx][ny] = true;
                        q.offer(new int[]{nx, ny, len+1,i});
                    }else if (lands[nx][ny] == num) {
                        visit[nx][ny] = true;
                        q.offer(new int[]{nx, ny, len,i});
                    }
                }
            }else{
                int nx = x + dx[direct];
                int ny = y + dy[direct];
                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                if (visit[nx][ny]) continue;
                if (lands[nx][ny] != num && lands[nx][ny] != 0 && len>=2) {
                    bridge[num][lands[nx][ny]] = Math.min(bridge[num][lands[nx][ny]], len);
                    bridge[lands[nx][ny]][num] = Math.min(bridge[lands[nx][ny]][num], len);
                    visit[nx][ny] = true;
                }  else if (lands[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx, ny, len+1,direct});
                }else if (lands[nx][ny] == num) {
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx, ny, len,direct});
                }
            }

        }
    }
    static void splitLands(int x,int y,int num,boolean[][] visit){
        for (int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if (nx<1||ny<1||nx>n||ny>m)continue;
            if (map[nx][ny]!=1||visit[nx][ny])continue;
            lands[nx][ny]=num;
            visit[nx][ny]=true;
            splitLands(nx,ny,num,visit);
        }
    }
}
