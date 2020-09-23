package leetcode;
import java.util.*;
public class Next_permutaion31 {
	static int[] nums= {1};
	public static void main(String[] args) {
		next_permutation();
		for(int i=0;i<nums.length;i++) {
			System.out.printf("%d ", nums[i]);
		}
	}
	static void next_permutation() {
		int i=nums.length-1;
		
		while(i>0&&nums[i-1]>=nums[i])i--;
		
		if(i<=0) {
			Arrays.sort(nums);
			return;
		}
		
		int j=nums.length-1;
		while(nums[i-1]>=nums[j])j--;
		swap(i-1,j);
		
		j=nums.length-1;
		for(;i<j;i++,j--) {
			swap(i,j);
		}
		
	}
	static void swap(int i,int j) {
    	int temp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=temp;
    }
}
