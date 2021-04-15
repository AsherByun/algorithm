package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class algo7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testc=Integer.parseInt(br.readLine());

        StringBuilder sb=new StringBuilder();

        for (int tc=0;tc<testc;tc++){
            int n=Integer.parseInt(br.readLine());

            PriorityQueue<Integer> gq=new PriorityQueue<>((a,b)->(a>b)?-1:1);
            PriorityQueue<Integer> sq=new PriorityQueue<>((a,b)->(a<b)?-1:1);

            Map<Integer,Integer> map=new HashMap<>();

            for (int i=0;i<n;i++){
                String[] str=br.readLine().split(" ");
                int num=Integer.parseInt(str[1]);
                if (str[0].equals("I")){
                    gq.offer(num);
                    sq.offer(num);
                    map.put(num,map.getOrDefault(num,0)+1);
                }else{
                    if (gq.isEmpty()||sq.isEmpty())continue;
                    int temp=0;
                    if (num==1){
                        temp=gq.poll();
                        map.put(temp,map.get(temp)-1);
                    }else{
                        temp=sq.poll();
                        map.put(temp,map.get(temp)-1);
                    }
                }
                while (!gq.isEmpty()){
                    int p=gq.peek();
                    if (map.get(p)==0){
                        gq.poll();
                    }else{
                        break;
                    }
                }
                while (!sq.isEmpty()){
                    int p=sq.peek();
                    if (map.get(p)==0){
                        sq.poll();
                    }else{
                        break;
                    }
                }
            }
            if (gq.isEmpty()||sq.isEmpty()){
                sb.append("EMPTY");
            }else{
                sb.append(gq.peek()+" "+sq.peek());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
