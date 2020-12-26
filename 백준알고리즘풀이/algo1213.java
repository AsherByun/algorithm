package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class algo1213 {
    static HashMap<Character,Integer> hash;
    static ArrayList<Character> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        hash = new HashMap<>();
        arr = new ArrayList<>();
        char oddchar='.';
        for (int i=0;i<str.length();i++){
            char now = str.charAt(i);
            if (!arr.contains(now))arr.add(now);
            hash.put(now,hash.getOrDefault(now,0)+1);
        }
        Set<Character> set = hash.keySet();
        Collections.sort(arr);
        LinkedList<Character> front = new LinkedList<>();
        LinkedList<Character> back = new LinkedList<>();
        int odd=0;
        for (char val:hash.keySet()){
            int a = hash.get(val);
            if (a%2!=0){
                odd++;
                oddchar=val;
            }
        }
        if (odd>1){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for (int i=0;i<arr.size();i++){
            char now=arr.get(i);
            int cnt = hash.get(now);
            if (cnt % 2==1){
                if (cnt!=1){
                    cnt/=2;
                    for (int j=0;j<cnt;j++){
                        front.add(now);
                        back.add(0,now);
                    }
                    hash.put(now,cnt);
                }
            }else{
                cnt /= 2;
                for (int j=0;j<cnt;j++){
                    front.add(now);
                    back.add(0,now);
                }
            }
        }
        if (oddchar!='.'){
            int cnt = hash.get(oddchar);
            for (int i=0;i<cnt;i++){
                front.add(oddchar);
            }
        }
        for (int i=0;i<front.size();i++){
            System.out.print(front.get(i));
        }
        for (int i=0;i<back.size();i++){
            System.out.print(back.get(i));
        }


    }
}
