package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;

public class 압축 {
    static ArrayList<Integer> ans;
    static HashMap<String,Integer> map;
    public static void main(String[] args) {
        String msg ="KAKAO";
        ans=new ArrayList<>();
        map =new HashMap<>();
        int key=27;

        for (int i=1;i<=26;i++){
            map.put(Character.toString('A'+(i-1)),i);
        }

        for (int i=0;i<msg.length();i++){
            StringBuilder sb=new StringBuilder();
            sb.append(msg.charAt(i));
            int idx=i+1;

            while (true){
                String temp=sb.toString();
                if (idx>=msg.length()){
                    if (map.containsKey(temp)){
                        ans.add(map.get(temp));
                        map.put(sb.toString(),key++);
                    }
                    i=idx-1;
                    break;
                }
                sb.append(msg.charAt(idx));
                if (map.containsKey(sb.toString())){
                    idx++;
                }else{
                    ans.add(map.get(temp));
                    map.put(sb.toString(),key++);
                    i=idx-1;
                    break;
                }
            }

        }
        int[] answer = new int[ans.size()];
        for (int i=0;i<ans.size();i++)answer[i]=ans.get(i);


    }
}
