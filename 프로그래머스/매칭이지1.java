package 프로그래머스;

import java.util.Stack;

public class 매칭이지1 {
    public static void main(String[] args) {
        String p = ")(";

        System.out.println(find(p));


    }
    static String find(String p){

        String u="";
        String v="";

        for (int i=1;i<=p.length();i++){
            if (isBalanced(p.substring(0,i))){
                u=p.substring(0,i);
                if (i!=p.length())v=p.substring(i);
                break;
            }
        }

        if (!v.equals("")){
            v = find(v);
        }
        String changedu="";

        if (!isPerfact(u)){
            for (int i=1;i<u.length()-1;i++){
                if (u.charAt(i)=='(')changedu+=')';
                else changedu+='(';
            }
            u=changedu;
            return "("+v+")"+u;
        }else{
            return u+v;
        }
    }

    static boolean isBalanced(String s){
        int open=0;
        int close=0;

        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                open++;
            }else{
                close++;
            }
        }
        if (open==close){
            return true;
        }else
            return false;
    }
    static boolean isPerfact(String s){
        Stack<Character> stack = new Stack<>();

        for (int i=0;i<s.length();i++){
            char now = s.charAt(i);

            if (now=='('){
                stack.push('(');
            }else{
                if (stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }

        }
        return true;
    }
}
