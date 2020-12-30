package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo11054 {
    static int n;
    static int[] map;
    static int[] front;
    static int[] back;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        max=0;
        map = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i=0;i<n;i++){
            map[i]=Integer.parseInt(str[i]);
        }
        setFront();
        setBack();
        for (int i=0;i<n;i++){
            int cnt = front[i] + back[i] -1;
            max = Math.max(max,cnt);
        }
        System.out.print(max);
    }
    static void setFront(){
        front = new int[n];
        front[0]=1;

        for (int i=1;i<n;i++){
            front[i]=1;
            for (int j=0;j<i;j++){
                if (map[i]>map[j]&&front[i]<front[j]+1){
                    front[i] = front[j] + 1;
                }
            }
        }
    }
    static void setBack(){
        back = new int[n];
        back[n-1]=1;
        for (int i=n-2;i>=0;i--){
            back[i]=1;
            for (int j=n-1;j>i;j--){
                if (map[i]>map[j]&&back[i]<back[j]+1){
                    back[i] = back[j]+1;
                }
            }
        }
    }
//    static int binarySearch(int[] arr,int target,int len){
//        int left = 0;
//        int right = len;
//        int mid = -1;
//
//        while (right>=left){
//            mid = (left+right)/2;
//            if (arr[mid]==target){
//                return mid;
//            }else if (arr[mid]>target){
//                right=mid-1;
//            }else{
//                left=mid+1;
//            }
//        }
//        return left;
//    }
}
