package 알고리즘.탐색;

import java.util.Scanner;

public class 이분탐색_lower_bound_and_upper_bound {
    static int[] list = new int[]{1,2,4,5,6,6,8,8,8,8,10,13,17};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();

        upper_bound(target);
        lower_bound(target);
    }
    static void lower_bound(int target){
        int left = 0; int right = list.length-1;

        while (left<right){     //<=로 해놓으면 while문을 나갈 수가없음 계속 같아지기때문에
            int mid = (left+right)/2;
            if (list[mid]>=target){     //더 크면 당연히 줄이는거,  같을때는 더 작은애가 잇을수도 있으니까 right를 mid로 놓고 다시 진행
                right=mid;
            }else{
                left=mid+1;
            }
        }
        System.out.println(right);
    }
    static void upper_bound(int target){
        int left = 0; int right = list.length-1;

        while (left<right){
            int mid = (left+right)/2;
            if (list[mid]>target){  //부등호만 빼주면 된다 -> mid보다 큰값을 찾는다 
                right = mid;
            }else{
                left=mid+1;
            }
        }       // => 결과값은 target값보이 끝나는지점 +1 위치
        System.out.println(right-1);
    }
}
