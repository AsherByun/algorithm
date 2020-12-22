package 프로그래머스;
import java.lang.reflect.Array;
import java.util.*;
public class 첼린지3 {

    public static void main(String[] args) {
        int a[]={-16,27,65,-2,58,-92,-71,-68,-61,-33};

        HashMap<String,Integer> h[]=new HashMap[a.length];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            h[i]=new HashMap();
            min=Math.min(min,a[i]);
            h[i].put("down",min);
        }
        min=Integer.MAX_VALUE;
        for(int i=a.length-1;i>=0;i--){
            min=Math.min(min,a[i]);
            h[i].put("up",min);
        }

        int res=0;
        int downmin;
        int upmin;

        for(int i=0;i<a.length;i++){
            int now=a[i];
            if(i==0){
                res++;
            }else if(i==a.length-1){
                res++;
            }else{
                downmin=h[i-1].get("down");
                upmin=h[i+1].get("up");
                if(downmin<now&&upmin<now){

                }else{
//                    System.out.println(now);
                    res++;
                }
            }

        }
    System.out.println(res);
    }

}
