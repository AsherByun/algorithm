package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo4256 {
    static int n;
    static int[] pre;
    static int[] mid;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testc = Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for (int t=0;t<testc;t++){
            n=Integer.parseInt(br.readLine());
            pre = new int[n+1];
            mid = new int[n+1];
            map = new int[n];

            String[] str=br.readLine().split(" ");
            for (int i=0;i<n;i++)pre[i]=Integer.parseInt(str[i]);
            str=br.readLine().split(" ");
            for (int j=0;j<n;j++)mid[j]=Integer.parseInt(str[j]);

            post(0,n,0);
            System.out.println();
        }
    }
    static void post(int left,int right,int now){
        for (int i=left;i<right;i++){
            if (mid[i]==pre[now]){
                post(left,i,now+1);
                post(i+1,right,now+(i-left+1));
                System.out.print(pre[now]+" ");
            }
        }
    }
}
