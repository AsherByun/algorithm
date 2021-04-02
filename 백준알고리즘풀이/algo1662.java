package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class algo1662 {
    static Stack<Integer> stack;
    static int[] closed;
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        str=br.readLine();
        stack=new Stack<>();
        closed = new int[50];

        for (int i=0;i<str.length();i++){
            char nowC = str.charAt(i);
            if (nowC=='(')stack.add(i);
            if (nowC==')')closed[stack.pop()] = i;
        }
        System.out.println(find(0,str.length()));
    }

    static int find(int start,int end){
        int cnt=0;

        for (int i=start;i<end;i++){
            char nowC = str.charAt(i);
            if (nowC == '('){
                cnt += (str.charAt(i-1)-'0')*find(i+1,closed[i])-1;
                i=closed[i];
            }else{
                cnt++;
            }
        }


        return cnt;
    }
}
