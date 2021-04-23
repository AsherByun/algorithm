package 코테복기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class back1261 {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");

        int n=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);

        int[][] map = new int[m+1][n+1];

        for (int i=1;i<=m;i++){
            String[] s=br.readLine().split("");
            for (int j=1;j<=n;j++){
                map[i][j]=Integer.parseInt(s[j-1]);
            }
        }

        boolean[][] visit=new boolean[m+1][n+1];
        visit[1][1]=true;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,1,0,0));

        while (!pq.isEmpty()){
            Node node=pq.poll();

            int x=node.x;
            int y=node.y;
            int cnt=node.cnt;
            int len=node.len;

            if (x==m&&y==n){
                System.out.println(cnt);
                return;
            }

            for (int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if (nx<=0||ny<=0||nx>m||ny>n)continue;
                if (visit[nx][ny])continue;

                if (map[nx][ny]==1){
                    pq.offer(new Node(nx,ny,cnt+1,len+1));
                }else{
                    pq.offer(new Node(nx,ny,cnt,len+1));
                }
                visit[nx][ny]=true;
            }

        }

    }
    static class Node implements Comparable<Node>{
        int x,y;
        int cnt;
        int len;

        Node(int x,int y,int cnt,int len){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
            this.len=len;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cnt<o.cnt)return -1;
            else{
                if (this.len<o.len)return -1;
                else return 1;
            }
        }
    }
}
