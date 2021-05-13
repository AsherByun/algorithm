package 라인코테;
import java.util.*;
import java.awt.*;
public class line2021_3 {
    static String s;
    static int res=0;
    static int ans[]=new int[2];
    public static void main(String[] args) {
        int n=1000	;
        s=Integer.toString(n);

        int size=s.length();
        size=size/2;

        if (s.charAt(size)=='0'){
            for (int i=size+1;i<s.length();i++){
                if(s.charAt(i)=='0')size=i;
                else break;
            }
        }
        go(size,s);

    }
    static void go(int size,String s){

        if(s.length()==1){
            ans[0]=res;ans[1]=Integer.parseInt(s);
            System.out.println(ans[0]+"   "+ans[1]);
            return;
        }
        System.out.println(s+"    "+size);
        int a ;
        int b ;
        if(size>=s.length()-1){
            a = Integer.parseInt(s.substring(0, size));
            b = Integer.parseInt(s.substring(size));
        }else {
            a = Integer.parseInt(s.substring(0, size + 1));
            b = Integer.parseInt(s.substring(size + 1));
        }

        String str=Integer.toString(a+b);



        int sizee=str.length();
        sizee=sizee/2;

        if (str.charAt(sizee)=='0'){
            for (int i=sizee+1;i<str.length();i++){
                if(str.charAt(i)=='0')sizee=i;
                else break;
            }
        }
        res++;
        go(sizee,str);

    }

}
