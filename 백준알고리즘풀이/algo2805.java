package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        long m = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        long map[] = new long[n+1];
        long right = 0;
        for (int i=1;i<=n;i++){
            map[i] = Integer.parseInt(str[i-1]);
            right = Math.max(right,map[i]);
        }
        long left=0;
        long mid=0;

        while (right>=left){
            mid = (left+right)/2;

            long sum = isOk(map,mid,n);

            if (sum>=m){
                left = mid+1;
            }else{
                right = mid -1;
            }

        }
        System.out.println(mid);
    }
    static long isOk(long[] map,long h,int n){
        long sum=0;
        for (int i=1;i<=n;i++){
            if (h<map[i])sum+=map[i]-h;
        }
        return sum;
    }
}
// 이분탐색으로 적절한값을 탐색한다
// 이런 범위안에서 적절한 값을 찾을때 이분탐색을 사용하면  nlogn의 시간안에 값을 찾을수있따
// while(right>=left) 사용 결과값은 마지막 right가 답