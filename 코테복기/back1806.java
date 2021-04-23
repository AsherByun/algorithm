package 코테복기;

public class back1806 {
    public static void main(String[] args) {
        int n=10;
        int m=15;

        int[] arr = {5,1,3,5,10,7,4,9,2,8};

        int left=0;int right=0;
        int sum=arr[0];
        int min=Integer.MAX_VALUE;

        while (right<n&&left<=right){
            System.out.println(left+" "+right+" "+sum+" "+min);
            if (sum<m){
                while (sum<m&&right<n){
                    sum+=arr[right++];
                }
                min=Math.min(min,right-left+1);
            }else{
                min=Math.min(min,right-left+1);
                sum-=arr[left++];
            }
        }
        System.out.println(min);
    }
}
