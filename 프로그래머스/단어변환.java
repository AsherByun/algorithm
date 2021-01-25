package 프로그래머스;

import java.util.HashMap;

public class 단어변환 {
    static int min;
    static HashMap<String,Integer> map;
    public static void main(String[] args) {
        String begin = "hit";
        String target ="cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};
        map=new HashMap<>();
        min=Integer.MAX_VALUE;
        for (int i=0;i<words.length;i++)map.put(words[i],Integer.MAX_VALUE);

        find(begin,0,target);
        System.out.println(min);

    }
    static void find(String str,int cnt,String target){
        if (str.equals(target)){
            min = Math.min(min,cnt);
            return;
        }

        for (int i=0;i<str.length();i++){
            for (int j=0;j<26;j++){
                String next = str.substring(0,i) + (char)('a'+ j) +str.substring(i+1);
                if (map.containsKey(next)){
                    if (map.get(next)>cnt+1){
                        map.put(next,cnt+1);
                        find(next,cnt+1,target);
                    }
                }
            }
        }

    }
}
/*
    해쉬맵에 dp 처럼 사요 -> 그냥 visit 사용했어도 괜찮
    각 문자마다 26번 돌면서 다음 것을 찾음 -> 그냥 한자리 다른거 찾아도됐음
 */