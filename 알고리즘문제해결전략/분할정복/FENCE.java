package 알고리즘문제해결전략.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FENCE {
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<testc;i++){
            int n=Integer.parseInt(br.readLine());
            map = new int[n];
            String[] str = br.readLine().split(" ");

            for (int j=0;j<n;j++){
                map[j]=Integer.parseInt(str[j]);
            }
            sb.append(solve(map,0,n-1)+"\n");
        }
        System.out.print(sb.toString());
    }
    static int solve(int[] map,int left,int right){
        int mid=(left+right)/2;
        if (left==right)return map[left];
        int max = Math.max(solve(map,left,mid),solve(map,mid+1,right));

        int lo = mid;
        int hi = mid+1;
        int height = Math.min(map[lo],map[hi]);
        int sum = height*2;
        int cnt=2;
        while (lo>left||hi<right){
            cnt++;
            int lh=0;int rh=0;
            if (lo>0){
                lh=map[lo-1];
            }
            if (hi<map.length-1){
                rh=map[hi+1];
            }
            if (lh>rh){
                height=Math.min(height,lh);lo--;
            }else{
                height=Math.min(height,rh);hi++;
            }
            sum = Math.max(cnt*height,sum);
        }
        max = Math.max(max,sum);
        return max;
    }
}

/*
    분할기법 -> 가운데를 시작으로 겹치는 부분에서시작 -> 양옆으로 더 큰곳으로 퍼져나감 -> left,right의 범위를 초과하면 중복된다
    기저 상태는 left==right인 상황 하나밖에없을때
    logn개를 n번 탐색 -> nlogn으로 줄일수있다
 */