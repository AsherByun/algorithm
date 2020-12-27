package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class algo1208 {
    static int cost[];
    static int m;
    static long cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str =br.readLine().split(" ");

        int n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);
        cost = new int[n];
        cnt=0;
        str = br.readLine().split(" ");
        for (int i=0;i<n;i++)cost[i]=Integer.parseInt(str[i]);

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        find(0,n/2,a,0);
        find(n/2,n,b,0);

        Collections.sort(a);
        Collections.sort(b);

        int left = 0;
        int right = b.size()-1;

        while (left<a.size()&&right>=0){
            int leftVal = a.get(left);
            int rightVal = b.get(right);

            if (leftVal+rightVal==m){
                long leftCnt = 0;
                long rightCnt = 0;
                while (left<a.size()){
                    if (a.get(left)==leftVal){
                        leftCnt++;
                        left++;
                    }else{
                        break;
                    }
                }
                while (right>=0){
                    if (b.get(right)==rightVal){
                        rightCnt++;
                        right--;
                    }else{
                        break;
                    }
                }
                cnt += leftCnt*rightCnt;
            }
            else if (leftVal+rightVal>m){
                right--;
            }else{
                left++;
            }
        }
        if (m==0){
            System.out.print(cnt-1);
        }else{
            System.out.print(cnt);
        }
    }
    //모든 부분집합 구하기
    static void find(int idx,int n,ArrayList<Integer> arr,int sum){
        if (idx==n){
            arr.add(sum);
            return;
        }
        find(idx+1,n,arr,sum+cost[idx]);
        find(idx+1,n,arr,sum);
    }

}
