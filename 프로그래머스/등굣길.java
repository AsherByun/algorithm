package 프로그래머스;

public class 등굣길 {
    static int dx[]=new int[]{1,0};
    static int dy[]=new int[]{0,1};
    static int map[][];
    static int dp[][];
    static int gx,gy;
    public static void main(String[] args) {
        int m = 4;int n=3;
        int puddles[][] = new int[][]{{2,2}};
        gx=n;gy=m;
        map = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for (int i=0;i<puddles.length;i++){
            int x = puddles[i][1];int y=puddles[i][0];
            map[x][y] = 1;
        }
        System.out.println(find(1,1));

    }
    static int find(int x,int y){
        if (x==gx&&y==gy)return 1;

        if (dp[x][y]!=0){
            return dp[x][y];
        }

        for (int i=0;i<2;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if (nx>0&&ny>0&&nx<=gx&&ny<=gy){
                if (map[nx][ny]!=1){
                    dp[x][y] += find(nx,ny);
                }
            }
        }
        return dp[x][y];
    }
}
