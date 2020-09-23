package leetcode;
/*
 * dp���
 * dp[i-1]+nums[i] < nums[i] �ϰ�� ���� ���� �����ϴ°� ��ŭ���� dp[i]=nums[i]
 * �ݴ��� ��� ���Ѱ��� �� ŭ���� dp[i]=dp[i-1]+nums[i]
 * �� ���� max���� ���Ͽ� ��ū ���� ����
 * O(N)
*/
import java.util.*;
public class maximum_subarray {
	static int nums[]= {-2,1,-3,4,-1,2,1,-5,4};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dp[]=new int[nums.length];
		int max=nums[0];
		dp[0]=nums[0];
		
		for(int i=1;i<nums.length;i++) {
			if(dp[i-1]+nums[i]<nums[i]) {
				dp[i]=nums[i];
			}else {
				dp[i]=dp[i-1]+nums[i];
			}
			if(max<dp[i])max=dp[i];
		}
		System.out.println(max);
	}

}
