package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class algo14002 {
    static int[] map;
    static int n;
    static ArrayList<Integer>[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map=new int[n];

        dp=new ArrayList[n];

        String[] str=br.readLine().split(" ");
        for (int i=0;i<str.length;i++)map[i]=Integer.parseInt(str[i]);

        ArrayList<Integer> ans=new ArrayList<>();
        for (int i=0;i<n;i++){
            ArrayList<Integer> temp=find(i);
            if (temp.size()>ans.size()){
                ans= (ArrayList<Integer>) temp.clone();
            }
        }
        Collections.sort(ans);
//        for (int i=0;i<n;i++){
//            System.out.println(i+" ====");
//            for (int j=0;j<dp[i].size();j++){
//                System.out.println(dp[i].get(j));
//            }
//        }
        System.out.println(ans.size());
        for (int i=0;i<ans.size();i++)System.out.print(ans.get(i)+" ");
    }

    static ArrayList<Integer> find(int idx){
        if (dp[idx]!=null)return dp[idx];

        dp[idx]=new ArrayList<>();

        for (int i=idx+1;i<n;i++){
            if (map[idx]<map[i]){
                ArrayList<Integer> temp=find(i);
                if (temp.size()>dp[idx].size()){
                    dp[idx]= (ArrayList<Integer>) temp.clone();
                }
            }
        }
        dp[idx].add(map[idx]);
        return dp[idx];
    }
}
