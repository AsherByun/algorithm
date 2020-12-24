package 알고리즘문제해결전략;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 시계맞추기_algospot_clocksync {
    static ArrayList<int[]> button;
    static int[] map;
    static int min;
    static boolean isPossible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        button = new ArrayList<>();
        button.add(new int[]{0, 1, 2});
        button.add(new int[]{3,7,9,11});
        button.add(new int[]{4,10,14,15});
        button.add(new int[]{0,4,5,6,7});
        button.add(new int[]{6, 7, 8, 10, 12});
        button.add(new int[]{0, 2, 14, 15});
        button.add(new int[]{3, 14, 15});
        button.add(new int[]{4, 5, 7, 14, 15});
        button.add(new int[]{1, 2, 3, 4, 5});
        button.add(new int[]{3, 4, 5, 9, 13});
        StringBuilder sb = new StringBuilder();
        for (int tc=0;tc<testcase;tc++){
            map = new int[16];
            String str[] = br.readLine().split(" ");
            for (int i=0;i<16;i++)map[i]=Integer.parseInt(str[i]);

            min=Integer.MAX_VALUE;
            isPossible=false;
            dfs(0,new ArrayList<Integer>());
            if (isPossible)sb.append(min+"\n");
            else sb.append(-1+"\n");
        }
        System.out.print(sb.toString());
    }
    static void dfs(int now,ArrayList<Integer> arr){
        if (now == 10){
            if (checking(arr)){
                isPossible=true;
                int total =0;
                for (int i=0;i<arr.size();i++)total+=arr.get(i);
                min = Math.min(total,min);
            }
            return;
        }

        for (int i=0;i<4;i++){
            arr.add(i);
            dfs(now+1,arr);
            arr.remove(arr.size()-1);
        }

    }
    static boolean checking(ArrayList<Integer> arr){
        int tmap[] = map.clone();

        for (int i=0;i<arr.size();i++){
            int cnt = arr.get(i);
            for (int j=0;j<button.get(i).length;j++){
                int num = button.get(i)[j];
                tmap[num] += 3 * cnt;
                if (tmap[num]>12)tmap[num]-=12;
            }
        }

        for (int i=0;i<tmap.length;i++){
            if (tmap[i]!=12)return false;
        }
        return true;
    }
}
