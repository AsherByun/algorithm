package 코테복기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class back1963 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int tc=scan.nextInt();

        for (int t=0;t<tc;t++){
            int s=scan.nextInt();
            int e=scan.nextInt();


            boolean[] visit=new boolean[10000];
            visit[s]=true;

            int cnt=0;
            Queue<Integer> q=new LinkedList<>();
            q.offer(s);

            while (!q.isEmpty()){
                int now=q.poll();
                boolean isFinish=false;
                for (int i=0;i<4;i++){
                    for (int j=0;j<10;j++){
                        if (i==0&&j==0)continue;
                        int temp=change(String.valueOf(now),String.valueOf(j),i);
                        if (isPrim(temp)){
                            if (temp==e)isFinish=true;
                            visit[temp]=true;
                            q.offer(temp);
                        }
                    }
                }
                if (isFinish)break;
            }
            System.out.println(cnt);
        }
    }
    static boolean isPrim(int n){
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0)return false;
        }
        return true;
    }
    static int change(String s,String a,int n){
        return Integer.parseInt(s.substring(0,n)+a+s.substring(n+1));
    }
}
