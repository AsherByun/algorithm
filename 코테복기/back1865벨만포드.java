package 코테복기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class back1865벨만포드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());

        StringBuilder sb=new StringBuilder();
        for (int tt=0;tt<tc;tt++){
            String[] str=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int m=Integer.parseInt(str[1]);
            int w=Integer.parseInt(str[2]);

            ArrayList<ArrayList<Node>> list = new ArrayList<>();

            for (int i=0;i<=n;i++)list.add(new ArrayList<>());

            for (int i=0;i<m+w;i++){
                String[] st=br.readLine().split(" ");
                int s=Integer.parseInt(st[0]);
                int e=Integer.parseInt(st[1]);
                int cost=Integer.parseInt(st[2]);
                if (i<m){
                    list.get(s).add(new Node(s,e,cost));
                    list.get(e).add(new Node(e,s,cost));
                }else{
                    list.get(s).add(new Node(s,e,-cost));
                }

            }

            boolean isb=false;
            for (int i=1;i<=n;i++){
                if (find(i,list,n)){
                    sb.append("YES\n");
                    isb=true;
                    break;
                }
            }
            if (!isb)sb.append("NO\n");
        }
        System.out.println(sb.toString());
    }
    static boolean find(int start,ArrayList<ArrayList<Node>> list,int n){
        int inf = 99999999;
        int[] dp = new int[n+1];
        Arrays.fill(dp,inf);
        dp[start]=0;
        boolean update=false;

        for (int i=1;i<n;i++){
            update=false;

            for (int j=1;j<=n;j++){
                for (Node node:list.get(j)){
                    if(dp[node.s]==inf)continue;

                    if (dp[node.s]+node.w<dp[node.e]){
                        dp[node.e]=node.w+dp[node.s];
                        update=true;
                    }

                }
            }
            if (!update)break;
        }

        if (update){
            for (int j=1;j<=n;j++){
                for (Node node:list.get(j)){
                    if(dp[node.s]==inf)continue;

                    if (dp[node.s]+node.w<dp[node.e]){
                        dp[node.e]=node.w+dp[node.s];
                        return true;
                    }

                }
            }
        }
        return false;
    }

    static class Node{
        int s,e,w;
        public Node(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}
