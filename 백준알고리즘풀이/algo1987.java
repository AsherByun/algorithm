package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class algo1987 {
    static char[][] map;
    static int n,m;
    static int max;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);

        map=new char[n+1][m+1];
        max=0;

        for (int i=1;i<=n;i++){
            String s = br.readLine();
            for (int j=1;j<=m;j++){
                map[i][j] = s.charAt(j-1);
            }
        }
        find(1,1,0,new HashSet<>());
        System.out.println(max);
    }
    static void find(int x, int y, int cnt, Set<Character> set){
        if (set.contains(map[x][y])){
            return;
        }else{
            max = Math.max(max,cnt+1);
            set.add(map[x][y]);

            for (int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if (nx>n||ny>m||nx<1||ny<1)continue;
                find(nx,ny,cnt+1,set);
            }
            set.remove((Character)map[x][y]);
        }


    }
}
