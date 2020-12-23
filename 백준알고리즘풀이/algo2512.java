package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str[]=br.readLine().split(" ");

        long map[] = new long[n+1];
        for (int i=1;i<=n;i++){
            map[i] = Integer.parseInt(str[i-1]);
        }
        int total = Integer.parseInt(br.readLine());

        Arrays.sort(map);
        long left[] = new long[n+1];
        left[0]=0;
        for (int i=1;i<=n;i++){
            left[i]=left[i-1]+map[i];
        }

        long ans=0;
        if (left[n]<=total)ans=map[n];

        for (int i=1;i<=n;i++){
            if (total>=left[i-1]){
                int temp = n-i+1;
                long value = (total-left[i-1])/temp;
                if (value<=map[i]){
                    ans = Math.max(ans,value);
                }
            }
        }
    System.out.println(ans);
    }
}
