package 프로그래머스;

import java.util.HashMap;

public class N개의최소공배수 {
    public static void main(String[] args) {
        int[] arr = {2,6,8,14};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<arr.length;i++){
            int n = arr[i];
            if (n==1)continue;
            HashMap<Integer,Integer> temp = find(n);

            for (Integer num:temp.keySet()){
                int k=temp.get(num);
                if (map.containsKey(num)){
                    map.put(num,Math.max(map.get(num),k));
                }else{
                    map.put(num,k);
                }
            }

        }
        int ans=1;
        for (Integer i:map.keySet()){
            ans *= ((int)Math.pow(i,map.get(i)));
        }
        System.out.println(ans);
    }
    static HashMap<Integer,Integer> find(int n){
        HashMap<Integer,Integer> m = new HashMap<>();

        for (int i=2;i<=n;i++){

            while (n%i==0){
                m.put(i,m.getOrDefault(i,0)+1);
                n=n/i;
            }

        }
        return m;
    }
}
