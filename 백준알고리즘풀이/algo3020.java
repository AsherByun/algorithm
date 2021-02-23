package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo3020 {
    static int[] dp;
    static int[] top,bottom;
    static int n,h;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());

        top=new int[h+2];
        bottom=new int[h+2];

        for (int i=1;i<=n;i++){
            int num = Integer.parseInt(br.readLine());

            if (i%2==1){
                bottom[num]++;
            }else{
                top[h-num+1]++;
            }
        }

        for (int i=1;i<=h;i++){
            top[i] += top[i-1];
        }
        for (int i=h;i>=1;i--){
            bottom[i] += bottom[i+1];
        }
        int min=Integer.MAX_VALUE;
        for (int i=1;i<=h;i++){
            min = Math.min(min,bottom[i]+top[i]);
        }
        int ans=0;
        for (int i=1;i<=h;i++){
            if (min==bottom[i]+top[i])ans++;
        }

        System.out.println(min+" "+ans);
    }
}
