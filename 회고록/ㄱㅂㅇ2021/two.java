package 가비아;

import java.util.HashMap;
import java.util.HashSet;

public class two {
    static HashSet<String> set;
    public static void main(String[] args) {
        String s="zxzxz";

        set=new HashSet<>();

        for (int i=0;i<s.length();i++){
            String str=s.substring(i);
            for (int j=1;j<=str.length();j++){
                String ss=(str.substring(0,j));
                if (isPossible(ss))set.add(ss);
            }
        }
        System.out.println(set.size());
    }
    static boolean isPossible(String s){
        HashMap<Character,Integer> map=new HashMap<>();

        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (map.containsKey(c)){
                return false;
            }else{
                map.put(c,1);
            }
        }

        return true;
    }
}
