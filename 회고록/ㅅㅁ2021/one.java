package 소마2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class one {
    static int n;
    static HashMap<String,Integer> convert;
    static HashMap<Integer,String> reverse;
    static ArrayList<Integer>[] map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
        convert=new HashMap<>();
        reverse=new HashMap<>();

        String[] str = br.readLine().split(" ");
        n=str.length;
        for (int i=0;i<str.length;i++){
            convert.put(str[i],i);
            reverse.put(i,str[i]);
        }
        map=new ArrayList[n];
        for (int i=0;i<n;i++)map[i]=new ArrayList<>();

        int[] start = new int[n];
        int[] link = new int[n];
        int m=Integer.parseInt(br.readLine());
        for (int i=0;i<m;i++){
            str = br.readLine().split(" ");
            map[convert.get(str[0])].add(convert.get(str[1]));
            start[convert.get(str[1])]++;
            link[convert.get(str[0])]++;
        }

        for (int i=0;i<n;i++){
            if (start[i]==0&&link[i]!=0){
                dfs(i,reverse.get(i)+"");
            }
        }
        System.out.println(sb.toString());
    }
    static void dfs(int now, String s){

        if (map[now].size()==0){
            sb.append(s+"\n");
        }
        for (int i=0;i<map[now].size();i++){
            dfs(map[now].get(i),s+" "+reverse.get(map[now].get(i)));
        }
    }
}
