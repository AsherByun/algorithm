package 알고리즘;

public class LIS최장증가부분수열2 {
    public static void main(String[] args) {
        int list[] = {1,4,5,8,9,12,40};
        System.out.println(binarySearch(10,list));
    }
    static int binarySearch(int target,int[] list){
        int left = 0;
        int right = list.length-1;
        int mid = 0;
        while (left<right){
            mid = (left+right)/2;
            System.out.println(left+"  "+mid+"  "+right);
            if (list[mid] == target){
                return mid;
            }
            else if (list[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return mid;
    }
}
