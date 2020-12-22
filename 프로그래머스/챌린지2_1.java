package 프로그래머스;
import java.util.*;
public class 챌린지2_1 {
    public static void main(String[] args) {
        int n=45;
        String s="";
        while (true){
            if (n<3){
                s+=String.valueOf(n);
                break;
            }
            String temp=String.valueOf(n%3);
            s+=temp;
            n=n/3;
        }
        int res=0;
        int j=0;
        for (int i=s.length()-1;i>=0;i--){
            int a=s.charAt(i)-'0';
            res+=Math.pow(3,j++)*a;
        }
        System.out.println(res);
    }
}
