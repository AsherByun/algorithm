package LEETCODE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Basic_Calculator2 {
    public static void main(String[] args) {
        String s = "3+2*2";

        Stack<Integer> stack=new Stack<>();

        int num=0;
        char[] map=s.toCharArray();
        char operation = '+';

        for (int i=0;i<map.length;i++){
            char c=map[i];

            if (Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            if(!Character.isDigit(c)&&!Character.isWhitespace(c)||i==map.length-1){
                if (operation=='-'){
                    stack.push(-num);
                }else if (operation=='+'){
                    stack.push(num);
                }else if (operation=='*'){
                    stack.push(stack.pop()*num);
                }else if (operation=='/'){
                    stack.push(stack.pop()/num);
                }
                operation=c;
                num=0;
            }
        }

        int sum =0;
        while (!stack.isEmpty())sum+=stack.pop();
        System.out.println(calcul(s));
    }
    static int calcul(String s){
        if (s==null||s.isEmpty())return 0;
        int len=s.length();
        int num=0;
        int lastNum = 0;
        int res=0;
        char operation='+';
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if (Character.isDigit(c)){
                num = (num * 10) + (c-'0');
            }
            if (!Character.isDigit(c)&&!Character.isWhitespace(c)||i==s.length()-1){
                if (c=='-'||c=='+'){
                    res += lastNum;
                    lastNum = (operation=='+')?num:-num;
                }else if (c=='*'){
                    lastNum = lastNum * num;
                }else if (c=='/'){
                    lastNum = lastNum / num;
                }
                operation=c;
                num=0;
            }
        }
        res+=lastNum;
        return res;
    }
}
