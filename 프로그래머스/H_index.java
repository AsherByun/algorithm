package 프로그래머스;

import java.util.Arrays;

public class H_index {
    public static void main(String[] args) {
        int in[] = {3,0,6,1,5};
        Arrays.sort(in);

        int ans=0;
        for (int i=0;i<in.length;i++){
            if (in.length-in[i]==in[i]-1){
                ans=in[i];
            }
        }
        System.out.println(ans);
    }
}
