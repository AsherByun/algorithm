package 프로그래머스;

import java.util.Stack;

public class 올바른괄호의갯수 {
    static int ans;
    public static void main(String[] args) {
        int n=14;
        ans=0;
        find(0,0,"",n);
        System.out.println(ans);
    }
    static void find(int open,int close,String str,int n){
        if (open+close==n*2){
//            System.out.println(str);
            if (isCan(str))ans++;
            return;
        }

        if (open<n){
            find(open+1,close,str+"(",n);
        }
        if (close<n){
            find(open,close+1,str+")",n);
        }

    }
    static boolean isCan(String str){
        char[] c=str.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i=0;i<c.length;i++){
            if (c[i]=='('){
                stack.push('(');
            }else{
                if (stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
