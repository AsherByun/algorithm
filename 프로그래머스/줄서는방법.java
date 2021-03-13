package 프로그래머스;

import java.util.ArrayList;

public class 줄서는방법 {
    static long[] facto;
    static int[] arr;
    public static void main(String[] args) {
        int n=20;
        long k=2;

        arr = new int[n];

        facto=new long[21];
        facto[0]=1;
        for (int i=1;i<=n;i++){
            facto[i]=facto[i-1]*i;
        }

        find(new boolean[n+1],n,n,k,new ArrayList<>());
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void find(boolean[] visit,int n,int idx, long k, ArrayList<Integer> list){
        if (idx==0){
            for (int i=0;i<list.size();i++)arr[i]=list.get(i);
            return;
        }
//        System.out.println(facto[idx-1]+"  "+idx+"  "+k);
        for (int i=1;i<=n;i++){
            if (visit[i])continue;
            if (k<=facto[idx-1]){
                list.add(i);
                visit[i]=true;
                find(visit,n,idx-1,k,list);
            }else{
                k-=facto[idx-1];
            }
        }
    }
}
