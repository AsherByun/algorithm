package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class algo1167 {
    static List<Integer> map[];
    static List<Integer> cost[];
    static int n;
    static int max;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        max=0;
        visit = new boolean[n+1];
        map = new ArrayList[n+1];
        cost = new ArrayList[n+1];
        for (int i=1;i<=n;i++){
            cost[i] = new ArrayList<>();
            map[i] = new ArrayList<>();
        }

        for (int i=1;i<=n;i++){
            String str[]=br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);

            for (int j=1;j<str.length-1;j++){
                int b = Integer.parseInt(str[j]);
                j++;
                int c = Integer.parseInt(str[j]);

                map[a].add(b);cost[a].add(c);
                map[b].add(a);cost[b].add(c);
            }
        }
        visit[1]=true;
        find(1);
        System.out.println(max);
    }
    static int find(int now){
        ArrayList<Integer> len = new ArrayList<>();
        int top=0;
        for (int i=0;i<map[now].size();i++){
            int next = map[now].get(i);
            if (!visit[next]){
                visit[next]=true;
                int temp = find(next) + cost[now].get(i);
                top = Math.max(top,temp);
                len.add(temp);
            }
        }
        len.remove((Integer)top);
        int second = 0;
        for (int i=0;i<len.size();i++){
            if (len.get(i)>second)second=len.get(i);
        }

        int r = top + second;
        max = Math.max(r,max);

        return top;
    }

}
