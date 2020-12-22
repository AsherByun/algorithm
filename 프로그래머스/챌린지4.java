package 프로그래머스;
import java.util.*;
public class 챌린지4 {
    public static void main(String[] args) {
        int a[][]= {{0,1,0},{1,1,1},{1,1,0},{0,1,1}};
        int rowsum=0;
        int row=a.length;
        int col=a[0].length;
        int climit[]=new int[col];

        int rmove[]=new int[row];
        int cmove[]=new int[col];
        Arrays.fill(rmove,col);
        Arrays.fill(cmove,row);

        for(int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                if(a[i][j]==1){
                    rowsum++;
                    climit[j]++;
                    rmove[i]--;
                    cmove[j]--;
                }
            }
        }

        int rnow[]=new int[row];
        int cnow[]=new int[col];

        int tsum=rowsum;
        int k=0;
        while(true){
            rnow[k++%row]+=2;
            tsum-=2;
            if(tsum<=0)break;
        }
        for(int i=0;i<row;i++){
            System.out.println(rnow[i]);
        }

    }
}
