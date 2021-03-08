package 프로그래머스;

import java.util.ArrayList;

public class 방금그곡 {
    public static void main(String[] args) {
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String m = "CC#BCC#BCC#BCC#B";

        System.out.println(solve(musicinfos,m,setStr(m)));

    }
    static String solve(String[] map,String m,String[] target){
        String ans="(None)";
        int max=0;

        for (int i=0;i<map.length;i++){
            String[] str = map[i].split(",");
            int term = time(str[1]) - time(str[0]);
            String[] sarr =setStr(str[3]);

            String[] temp = new String[term];
            if (sarr.length>term){
                for (int j=0;j<term;j++)temp[j]=sarr[j];
            }else{
                int k=0;
                for (int j=0;j<term;j++){
                    temp[j] = sarr[k++];
                    k%=sarr.length;
                }
            }
            if(kmp(getPi(target),temp,target)){
                if (max<term){
                    max=term;
                    ans=str[2];
                }
            }
        }

        return ans;
    }
    static String[] setStr(String str){
        ArrayList<String> carr = new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<str.length();i++){
            if (i==str.length()-1){
                sb.append(str.charAt(i));
                carr.add(sb.toString());
                break;
            }
            if (str.charAt(i+1)=='#'){
                sb.append(str.charAt(i++));
                sb.append(str.charAt(i));
                carr.add(sb.toString());
                sb=new StringBuilder();
            }else{
                sb.append(str.charAt(i));
                carr.add(sb.toString());
                sb=new StringBuilder();
            }
        }
        return carr.toArray(new String[carr.size()]);
    }
        static boolean kmp(int[] pi, String[] str, String[] target){
            int j=0;
            for (int i=0;i<str.length;i++){
                while (j>0&&!str[i].equals(target[j])) j=pi[j-1];     //현재 문자와 다르면 접두사를 체크해서 뒤로 돌아간다

                if (str[i].equals(target[j])){     //같으면 현재위치가 끝부분이면 ok  아니면 다음으로 넘김
                    if (j==target.length-1){
                        return true;
                    }else{
                        j++;
                    }
                }
            }
            return false;
        }

    static int[] getPi(String[] str){
        int[] pi = new int[str.length];

        for (int i=1;i<str.length;i++){
            if (str[pi[i-1]].equals(str[i]))pi[i] = pi[i-1]+1;
        }

        return pi;
    }


    static int time(String s){
        String[] str = s.split(":");
        return Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
    }
}
