package 프로그래머스;

public class 멀쩡한사각형 {
    public static void main(String[] args) {
        int W=8;
        int H=12;

        long ans = 0;
        long max= (long)W;
        long min= (long)H;
        if (W<H){
            long temp=max;
            max=min;
            min=temp;
        }

        long val=1;
        while (val>0){
            val=max%min;
            max=min;
            min=val;
        }

        ans = (long)W*(long)H - ((long)W + (long)H -max);
    }

}
