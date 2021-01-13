package 프로그래머스;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class 조이스틱 {
    static int MOD;
    static HashMap<String,Integer> map;
    public static void main(String[] args) {
        String name = "BAAAAABBB";
        map=new HashMap<>();
        MOD = name.length();

        String start="";
        for (int i=0;i<name.length();i++)start+="A";

        find(start,0,0,name);

//        for (String s:map.keySet()){
//            System.out.println(s+"  "+map.get(s));
//        }
        System.out.println(map.get(name));
    }
    static void find(String s,int num,int idx,String name){

        int gap = Math.min(name.charAt(idx)-'A','Z'+1-name.charAt(idx));
        num += gap;
        s=s.substring(0,idx) + name.charAt(idx) + s.substring(idx+1);

        if (map.containsKey(s)){
            int temp = map.get(s);
            if (temp<num)return;
            map.put(s,num);
        }else{
            map.put(s,num);
        }
        if (s.equals(name))return;

        int left=idx-1;
        int cnt=1;
        while (left!=idx){
            if (left<0)left=name.length()-1;
            if (s.charAt(left)!=name.charAt(left))break;
            left--;cnt++;
        }
        if (left!=idx&&s.charAt(left)!=name.charAt(left)){
            find(s,num+cnt,left,name);
        }

        int right=idx+1;
        cnt=1;
        while (right!=idx){
            right%=MOD;
            if (s.charAt(right)!=name.charAt(right))break;
            right++;cnt++;
        }
        if (right!=idx&&s.charAt(right)!=name.charAt(right)){
            find(s,num+cnt,right,name);
        }


    }

}
