package 소마2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int p=Integer.parseInt(str[0]);
        int n=Integer.parseInt(str[1]);
        int h=Integer.parseInt(str[2]);

        ArrayList<Integer>[] com = new ArrayList[p+1];
        for (int i=0;i<=p;i++)com[i]=new ArrayList();

        for (int i=0;i<n;i++){
            str=br.readLine().split(" ");
            int num=Integer.parseInt(str[0]);
            int hour=Integer.parseInt(str[1]);
            if (hour>h)continue;
            com[num].add(hour);
        }

        for (int i=0;i<=p;i++) Collections.sort(com[i]);
        int[] money = new int[p+1];

        for (int i=1;i<=p;i++){
        if (com[i].size()==0)continue;
            boolean[] time = new boolean[25];
            time[0]=true;
            for (int j=0;j<com[i].size();j++){
                int nowTime = com[i].get(j);
                for(int k=0;k<=24;k++){
                    if (k-nowTime<0)continue;
                    if (time[k-nowTime])time[k]=true;
                }
            }
            for(int j=h;j>=0;j--){
                if(time[j]){
                    money[i]=j;
                    break;
                }
            }

        }
        for (int i=1;i<=p;i++){
            System.out.println(i+" "+money[i]*1000);
        }
    }
}
