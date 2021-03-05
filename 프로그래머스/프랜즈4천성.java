package 프로그래머스;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 프랜즈4천성 {
    public static void main(String[] args) {
        int m=4;
        int n=5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        char[][] map = new char[m][n];
        int broken=0;
        for (int i=0;i<m;i++)map[i]=board[i].toCharArray();

        while (true){
            boolean isMore = false;
            Set<Point> removeP = new HashSet<>();

            for (int i=0;i<m-1;i++){
                for (int j=0;j<n-1;j++){
                    if(map[i][j]=='x')continue;
                    if (map[i][j]==map[i+1][j]&&map[i][j]==map[i][j+1]&&map[i][j]==map[i+1][j+1]){
                        removeP.add(new Point(i,j));removeP.add(new Point(i,j+1));
                        removeP.add(new Point(i+1,j));removeP.add(new Point(i+1,j+1));
                        isMore=true;
                    }
                }
            }
            broken+=broke(removeP,map);
            move(map);
            if (!isMore)break;

        }
//        System.out.println(broken);
//        for (int i=0;i<m;i++){
//            for (int j=0;j<n;j++){
//                System.out.print(map[i][j]);
//            }System.out.println();
//        }
    }
    static void move(char[][] map){

        for (int y=0;y<map[0].length;y++){
            String str = "";
            for (int x=map.length-1;x>=0;x--){
                if (map[x][y]!='x')str+=String.valueOf(map[x][y]);
                map[x][y]='x';
            }
            int j=0;
            for (int x=map.length-1;x>=map.length-str.length();x--){
                map[x][y]=str.charAt(j++);
            }

        }

    }

    static int broke(Set<Point> set,char[][] map){
        int b=0;

        for (Point p:set) {
            int x = p.x;
            int y = p.y;
            if (map[x][y] == 'x') continue;
            else {
                map[x][y] = 'x';
                b++;
            }
        }
        return b;
    }
}
