package 베이글;
import java.util.*;
public class code2 {
    static int max=0;
    static int[] count;
    static ArrayList<Integer> map[] = new ArrayList[100001];
    public static void main(String[] args) {
        int n=7;
        int[][] relation = {{1,2},{2,5},{2,6},{1,3},{1,4},{3,7}};
        String[] dirname ={"root","abcd","cs","hello","etc","hello","solution"};
        count=new int[n];
        for (int i=0;i<n;i++){
            count[i]=dirname[i].length();
        }
        for (int i=0;i<100001;i++){
            map[i]=new ArrayList<>();
        }

        for (int i=0;i<relation.length;i++){
            int s=relation[i][0]-1;
            int e=relation[i][1]-1;
            map[s].add(e);
        }

        dfs(0,count[0]);
        System.out.println(max);

    }
    static void dfs(int now,int sum){
        if (max<sum)max=sum;
        for (int i=0;i<map[now].size();i++){
            int next=map[now].get(i);
            dfs(next,sum+count[next]+1);
        }

    }
}
