package 프로그래머스;

import java.util.*;

public class 튜플 {
    public static void main(String[] args) {
        String s="{{2},{2,1},{2,1,3},{2,1,3,4}}";
        StringTokenizer st=new StringTokenizer(s,"{}");
        while (st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
        String str[]=s.split("}");
        int size=0;
        ArrayList<ArrayList> total=new ArrayList();
        for (int i=0;i<str.length;i++){
            ArrayList<Integer> arr=new ArrayList<>();

            for (int j=0;j<str[i].length();j++){
                char c=str[i].charAt(j);
                if (c-'0'>=0&&c-'0'<=9){
                    arr.add(c-'0');
                }
            }
            size=Math.max(size,arr.size());
            total.add(arr);
        }
        Comparator<ArrayList> comparator=new Comparator<ArrayList>() {
            @Override
            public int compare(ArrayList o1, ArrayList o2) {
                if (o1.size()>o2.size()){
                    return 1;
                }else if(o1.size()<o2.size()){
                    return -1;
                }else return 0;
            }
        };
        Collections.sort(total,comparator);
        int ans[]=new int[size];
        ArrayList<Integer> tmparr=new ArrayList();
        for (int i=0;i<total.size();i++){
            ArrayList<Integer> arr=total.get(i);
            for (int j=0;j<arr.size();j++){
                int temp=arr.get(j);
                if (!tmparr.contains(temp))tmparr.add(temp);
            }
        }
        for (int i=0;i<tmparr.size();i++){
            ans[i]=tmparr.get(i);
        }
    }
}
