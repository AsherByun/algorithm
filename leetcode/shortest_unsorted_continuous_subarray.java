package leetcode;
/*
 * nums�� ���� �迭�� ���� �� (arr) ����
 * ������ ������ �迭 nums�� ���Ͽ� �ٲ����� �������� ������ ����ã��
 * �ΰ��� ���� +1 ��Ų ���� �ٲ���� ��, ���� �ٲ��� �����ÿ��� 0�� ����
 */
import java.util.*;
public class shortest_unsorted_continuous_subarray {
	static int[] nums= {2, 6, 4, 8, 10, 9, 15};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=nums.clone();
		Arrays.sort(arr);
		int res=0;
		int s=-1,e=-1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=arr[i]) {
				if(s==-1)s=i;
				e=i;
			}
		}
		if(s==-1) {
			System.out.println(res);
		}else {
			res=e-s+1;
			System.out.println(res);
		}
		
	}

}
