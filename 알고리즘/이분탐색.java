package 알고리즘.탐색;

public class 이분탐색 {
    public static void main(String[] args) {
        int[] list = new int[]{1,3,5,6,7,9,10,13,15,19};

        int left =0;
        int right =list.length-1;
        int ans = -1;
        int target =8;
        while (left<=right){
            int mid = (left+right)/2;
            if (list[mid]==target){
                ans=mid;break;
            }else if (list[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        System.out.println(ans);
    }
}
