package 월간코;

import java.util.Stack;

public class p20210415_2 {
    public static void main(String[] args) {
        String s="[](){}";
        int cnt=0;
        for (int i=0;i<s.length();i++){
            if (check(s.substring(i)+s.substring(0,i))){
             cnt++;
            }
        }
        System.out.println(cnt);
    }
    static boolean check(String s){
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if(c=='{'||c=='['||c=='('){
                stack.push(c);
            }else{
                if(stack.isEmpty())return false;
                char out=stack.pop();

                if (c=='}'){
                    if (out!='{')return false;
                }else if(c==')'){
                    if (out!='(')return false;
                }else{
                    if (out!='[')return false;
                }
            }
        }
        if (!stack.isEmpty())return false;
        return true;
    }
}
