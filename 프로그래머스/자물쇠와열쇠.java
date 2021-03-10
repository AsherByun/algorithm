package 프로그래머스;

import java.awt.*;
import java.util.ArrayList;

public class 자물쇠와열쇠 {
    static ArrayList<int[][]> keys;
    static int count;
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0},{1, 0, 0},{0, 1, 1}};
        int[][] lock = {{1, 1, 1},{1, 1, 0},{1, 0, 1}};

        count=0;
        setKeys(key);

        for (int i=0;i<lock.length;i++){
            for (int j=0;j<lock.length;j++){
                if (lock[i][j]==0)count++;
            }
        }

        if (solve(lock)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }
    static boolean solve(int[][] lock){

        for (int i=0;i<lock.length;i++){
            for (int j=0;j<lock.length;j++){
                for (int t=0;t<4;t++){
                    if (find(i,j,keys.get(t),lock)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
    static boolean find(int x,int y,int[][] key,int[][] lock){

        for (int i=0;i<key.length;i++){
            for (int j=0;j<key.length;j++){
                if(isMatch(new Point(x,y),new Point(i,j),lock,key)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean isMatch(Point l,Point k,int[][] lock,int[][] key){
        int cnt = 0;

        for (int i=k.x,x=0;i<key.length;i++,x++){
            for (int j=k.y,y=0;j<key.length;j++,y++){
                if (l.x+x>=lock.length||l.y+y>=lock.length)continue;
                if (lock[l.x+x][l.y+y]==1&&key[i][j]==1)return false;
                if (lock[l.x+x][l.y+y]==0&&key[i][j]==1){
                    cnt++;
                }
            }
        }
        return (cnt==count);
    }

    static void setKeys(int[][] key){
        keys = new ArrayList<>();

        keys.add(rotate(key));
        for (int i=0;i<3;i++){
            keys.add(rotate(key));
        }
    }
    static int[][] rotate(int[][] key){
        for (int i=0;i<key.length/2;i++){
            for (int j=0;j<key.length;j++){
                int temp = key[i][j];
                key[i][j] = key[key.length-i-1][j];
                key[key.length-i-1][j] = temp;
            }
        }
        for (int i=0;i<key.length;i++){
            for (int j=i;j<key.length;j++){
                int temp = key[i][j];
                key[i][j] = key[j][i];
                key[j][i] = temp;
            }
        }
        int[][] rot = new int[key.length][key.length];
        for (int i=0;i<key.length;i++){
            for (int j=0;j<key.length;j++){
                rot[i][j]=key[i][j];
            }
        }
        return rot;
    }
}
