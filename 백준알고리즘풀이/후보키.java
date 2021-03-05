package 프로그래머스;

import java.lang.reflect.Array;
import java.util.*;

public class 후보키 {
    static int n;
    static String[][] map;
    static int ans;
    static ArrayList<Set<Integer>> keys;
    static ArrayList<ArrayList<Integer>> combi;
    static boolean can;
    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        combi=new ArrayList<>();
        map=relation;
        n=relation[0].length;
        ans=0;
        keys=new ArrayList<>();

        dfs(0,new HashSet<Integer>());

        System.out.println(ans);

    }
    static boolean isKey(Set<Integer> arr){
        for (Set<Integer> set:keys){
            Set<Integer> temp = new HashSet<>();
            temp.addAll(arr);
            temp.addAll(set);

            if (temp.size()==arr.size())return false;
        }
        HashSet<String> hashSet = new HashSet<>();
        for (int i=0;i<map.length;i++){
            String str="";
            for (Integer j : arr){
                str+=map[i][j];
            }
            if (hashSet.contains(str))return false;
            hashSet.add(str);
        }
        Set<Integer> tarr=new HashSet<>();
        tarr.addAll(arr);
        keys.add(tarr);
        return true;
    }
    static void dfs(int idx, HashSet<Integer> arr){
        if (idx==n){
            if (arr.size()==0)return;
            if (isKey(arr))ans++;
            return;
        }
        dfs(idx+1,arr);
        arr.add(idx);
        dfs(idx+1,arr);
        arr.remove((Integer)idx);
    }
}
