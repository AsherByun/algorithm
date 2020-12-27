package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo2357 {
    static int n,m;
    static int ansMax,ansMin;
    static int[] max;
    static int[] min;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);

        map = new int[n+1];
        max = new int[n*5];
        min = new int[n*5];
        Arrays.fill(min,Integer.MAX_VALUE);

        for (int i=1;i<=n;i++){
            int input=Integer.parseInt(br.readLine());
            map[i]=input;
        }
        init(1,1,n);

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<m;i++){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            ansMax=0;
            ansMin=Integer.MAX_VALUE;
            find(1,a,b,1,n);
            sb.append(ansMin+" "+ansMax+"\n");
        }
        System.out.print(sb.toString());
    }
    static void find(int node,int start,int end,int left,int right){
        if (left>end||right<start){
            return;
        }
        if (start<=left&&end>=right){
            ansMax = Math.max(ansMax,max[node]);
            ansMin = Math.min(ansMin,min[node]);
            return;
        }
        int mid = (left+right)/2;
        find(node*2,start,end,left,mid);
        find(node*2+1,start,end,mid+1,right);
    }
    static int[] init(int node,int start,int end){
        if (start==end){
            max[node] = map[start];
            min[node] = map[start];
            return new int[]{map[start],map[start]};
        }
        int mid=(start+end)/2;
        int[] temp;
        temp = init(node*2,start,mid);
        max[node] = Math.max(max[node],temp[1]);
        min[node] = Math.min(min[node],temp[0]);
        temp = init(node*2+1,mid+1,end);
        max[node] = Math.max(max[node],temp[1]);
        min[node] = Math.min(min[node],temp[0]);
        return new int[]{min[node],max[node]};
    }
}
