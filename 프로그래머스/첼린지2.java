package 프로그래머스;

import java.util.HashSet;
import java.util.PriorityQueue;

public class 첼린지2 {
    static int m;
    static int map[][];
    public static void main(String[] args) {
        int n=4;
        m=n;
        map=new int[n+1][n+1];
        int i=1;int j=1;int c=0;int k=0;
        while (true){
            c=tri(j,i,c,k);
            if(c==0)break;

            i++;j+=2;k++;

        }
        int[] ans=new int[n*(n+1)/2];
        int temp=0;
        for(int ti=1;ti<=n;ti++){
            for(int tj=1;tj<=n;tj++){
                if(map[ti][tj]!=0){
                    ans[temp++]=map[ti][tj];
                }
            }
        }


    }
    static int tri(int x,int y,int c,int k){
        int sum=c+1;
        if(x>m||y>m)return 0;
        if(map[x][y]!=0){
            return 0;
        }else{
            for(int i=x;i<=m;i++){
                if(map[i][y]==0){
                    map[i][y]=sum;
                    sum++;
                }else{
                    break;
                }
            }
            int end=0;
            for(int j=k+2;j<=m;j++){
                if(map[m-k][j]==0){
                    map[m-k][j]=sum;
                    sum++;
                    end=j;
                }else{
                    break;
                }
            }
            end--;
            int t=0;
            for(int i=m-k-1;i>=y;i--){
                if(end-t<0){
                    sum++;break;
                }
                if(map[i][end-t]==0){
                    map[i][end-t]=sum;
                    sum++;
                    t++;
                }else{
                    break;
                }
            }
//            for(int ti=1;ti<=m;ti++){
//                for(int tj=1;tj<=m;tj++){
//                    System.out.printf("%d ",map[ti][tj]);
//                }System.out.println("");
//            }

        }
        return sum-1;
    }
}
