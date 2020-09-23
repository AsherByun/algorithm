package leetcode;
import java.util.*;
public class jump_game {
	static int nums[]= {0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int len=0;
		
		if(nums[0]==0) {
			System.out.println("false");
			return;
		}
		len=nums[0];
		boolean can=true;
		for(int i=1;i<nums.length;i++) {
			len--;
			if(len<0) {
				can=false;
				break;
			}
			if(nums[i]==0)continue;
			if(nums[i]>len)len=nums[i];
		}
		if(can)System.out.println("true");
		else System.out.println("false");
	}
}
