package 소마2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class thr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);
        int e=Integer.parseInt(str[2]);

        ArrayList<Integer> map=new ArrayList<>();
        int now=-1;
        int cnt=0;

        str=br.readLine().split(" ");
        for (int i=0;i<n;i++){
            int num=Integer.parseInt(str[i]);
            if (num==e){
                cnt++;
                now=i;
            }
            map.add(num);
        }
        int paint=0;
        if (now==-1){
            int idx=-Collections.binarySearch(map,e)-1;
            cnt++;
            if (idx==0){
                now=0;
            }else{
                if (e-map.get(idx-1)>map.get(idx)-e){
                    paint=map.get(idx)-e;
                    now=idx;
                }else{
                    paint=e-map.get(idx-1);
                    now=idx-1;
                }
            }
        }
        int left=now-1;int right=now+1;
        while (cnt!=m){
            if (left-1<0){
                paint+=map.get(right+1)-map.get(right);
                right=right+1;
            }else if (right+1>=map.size()){
                paint+=map.get(left)-map.get(left-1);
                left=left-1;
            }else if(map.get(right+1)-map.get(left)>map.get(left)-map.get(left-1)){
                paint+=map.get(right+1)-map.get(right);
                right=right+1;
            }else {
                paint+=map.get(left)-map.get(left-1);
                left=left-1;
            }
            cnt++;
        }
        System.out.println(paint);
    }
}
