package 데브매칭2021;

import java.util.LinkedList;

public class two {
    static int[][] map;
    public static void main(String[] args) {
        int rows = 6;
        int colums = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        map=new int[rows+1][colums+1];
        int k=1;
        for (int i=1;i<=rows;i++){
            for (int j=1;j<=colums;j++){
                map[i][j]=k++;
            }
        }
        int[] ans=new int[queries.length];
        for (int i=0;i<queries.length;i++){
            ans[i]=rotate(queries[i][0],queries[i][1],queries[i][2],queries[i][3]);
        }

    }
    static int rotate(int x1,int y1,int x2,int y2){
        LinkedList<Integer> arr=new LinkedList<>();

        int min=Integer.MAX_VALUE;
        for (int i=y1;i<y2;i++){
            arr.add(map[x1][i]);
            min=Math.min(min,map[x1][i]);
        }
        for (int i=x1;i<x2;i++){
            arr.add(map[i][y2]);
            min=Math.min(min,map[i][y2]);
        }
        for (int i=y2;i>y1;i--){
            arr.add(map[x2][i]);
            min=Math.min(min,map[x2][i]);
        }
        for (int i=x2;i>x1;i--){
            arr.add(map[i][y1]);
            min=Math.min(min,map[i][y1]);
        }

        arr.add(0,arr.get(arr.size()-1));
        int k=0;
        for (int i=y1;i<y2;i++){
            map[x1][i]=arr.get(k++);
        }
        for (int i=x1;i<x2;i++){
            map[i][y2]=arr.get(k++);;
        }
        for (int i=y2;i>y1;i--){
            map[x2][i]=arr.get(k++);;
        }
        for (int i=x2;i>x1;i--){
            map[i][y1]=arr.get(k++);;
        }

        return min;
    }
}
