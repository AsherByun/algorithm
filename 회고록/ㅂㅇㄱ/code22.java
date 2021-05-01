package 베이글;
import java.util.*;
public class code22 {
    static int max=0;
    static int[] union = new int[100001];
    static int[] count;
    static int[] num;
    public static void main(String[] args) {
        int n=7;
        int[][] relation = {{1,2},{2,5},{2,6},{1,3},{1,4},{3,7}};
        String[] dirname ={"root","abcd","cs","hello","etc","hello","solution"};
        count=new int[n+1];
        for (int i=1;i<=n;i++){
            count[i]=dirname[i-1].length();
        }

        for (int i=0;i<relation.length;i++){
            int s=relation[i][0];
            int e=relation[i][1];

            union[e]=find(s,e);

        }
        for (int i=1;i<=n;i++){
            System.out.println(union[i]);
        }


    }
    static int find(int head,int now){
        if (union[head]==0){
            return head;
        }else{
            union[now]=find(union[head], head);
            return union[now];
        }
    }
}

