package 프로그래머스;

import java.util.HashMap;

public class 위장 {
    public static void main(String[] args) {
        String[][] clothes={{"a","a"},{"b","b"},{"b","e"},{"b","d"},{"b","c15"},{"b","c14"},{"b","c13"},{"b","c12"},{"b","c6"},{"b","c5"},{"b","c4"},{"b","c3"},{"b","c2"},{"b","1"}};

        HashMap<String ,Integer> map = new HashMap<>();
        for (int i=0;i<clothes.length;i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }

        int ans=1;

        for (String s:map.keySet()){
            ans *= (map.get(s)+1);
        }
        ans-=1;
    }

}
