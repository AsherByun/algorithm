package 라인코테;
import java.util.*;
import java.awt.*;
public class line2021_5 {
    int dx[]={0,-1,0,1};
    int dy[]={-1,0,1,0};
    static int map[][][];
    public static void main(String[] args) {
        int maze[][]={{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}};
        map=new int[maze.length][maze.length][4];

        for (int i=0;i<maze.length;i++){
            for (int j=0;j<maze.length;j++){
                if(j==0&&maze[i][j]==0){
                    map[i][j][0]=1;
                }else if (j==maze.length-1&&maze[i][j]==0){
                    map[i][j][2]=1;
                }else if (i==0&&maze[i][j]==0){
                    map[i][j][1]=1;
                }else if (i==maze.length-1&&maze[i][j]==0){
                    map[i][j][3]=1;
                }
                if (maze[i][j]==1){
                    Arrays.fill(map[i][j],1);
                }
            }
        }

        for (int i=0;i<4;i++){
            if (map[0][0][i]==1){

            }
        }

    }
}
