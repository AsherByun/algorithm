package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo10830 {
    static int n;
    static long b;
    static int[][] map;
    static int[][] one;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] str=br.readLine().split(" ");
        n=Integer.parseInt(str[0]);
        b=Long.parseLong(str[1]);

        map=new int[n][n];
        for (int i=0;i<n;i++){
            str=br.readLine().split(" ");
            for (int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(str[j]);
            }
        }

        one=new int[n][n];
        for (int i=0;i<n;i++){
            one[i][i]=1;
        }

        int[][] ans=find(map,b);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(ans[i][j]%1000+" ");
            }System.out.println();
        }
    }
    static int[][] find(int[][] x,long len){
        if (len==0)return one;
        if (len==1)return x;

        if (len%2==0){
            int[][] m = find(x,len/2);
            return mul(m,m);
        }else{
            int[][] m = find(x,len/2);
            return mul(mul(m,m),x);
        }
    }
    static int[][] mul(int[][] a,int[][] b){
        int[][] matrix = new int[n][n];

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                for (int k=0;k<n;k++){
                   matrix[i][j] += (a[i][k]*b[k][j]);
                   matrix[i][j] %= 1000;
                }
            }
        }
        return matrix;
    }
}
