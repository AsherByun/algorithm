package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class algo9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String tar = br.readLine();
        int n = tar.length();

        char[] cmap=tar.toCharArray();
        int idx=0;
        char[] out=new char[str.length()];

        for (int i=0;i<str.length();i++){
            out[idx] = str.charAt(i);
            if (check(out,idx,tar))idx -= tar.length();
            idx++;
        }
        String ans=String.valueOf(out,0,idx);

        if (ans.equals(""))System.out.println("FRULA");
        else System.out.println(ans);
    }

    static boolean check(char[] out,int idx,String bomb){
        if (idx<bomb.length()-1)return false;

        for (int i=0;i<bomb.length();i++){
            if(bomb.charAt(i)!=out[idx-bomb.length()+1+i])return false;
        }
        return true;
    }
}
