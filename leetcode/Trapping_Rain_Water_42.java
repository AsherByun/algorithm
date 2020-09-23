package leetcode;
/*
 * ���� ����Ʈ���� �翷�� �ִ밪�� �ּ������� �۴ٸ� ���� �� �� ����
 * �¿� �ִ밪�� �ּҰ��� ���� ������ ���̸� �����ش�;
 */
import java.util.*;
public class Trapping_Rain_Water_42 {
	static int[] height= {0,1,0,2,1,0,1,3,2,1,2,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=0;
		for(int i=0;i<height.length;i++) {
			int rmax=0;
			int lmax=0;	
			for(int j=0;j<i;j++) {
				lmax=Math.max(lmax, height[j]);
			}
			for(int j=i+1;j<height.length;j++) {
				rmax=Math.max(rmax, height[j]);
			}
			int min=Math.min(lmax, rmax);
			if(min>height[i]) {
				res+=min-height[i];
			}
		}
		System.out.println(res);
	}
}


/*
 * ��� ���� ���鼭 ���� ���ߴµ� �ð��ʰ��� ���� 
 */

//int res=0;
//int max=0;
//for(int j=0;j<height.length;j++) {
//	max=Math.max(max, height[j]);
//}
//for(int i=1;i<=max;i++) {
//	int s=0;
//	int l=0;
//	boolean can=false;
//	for(int j=0;j<height.length;j++) {
//		if(i<=height[j]) {
//			if(!can) {
//				l=j;
//				s=j;can=true;
//			}else {
//				res+=(l==s)?0:l-s;
//				l=j;s=j;
//			}
//		}else {
//			l++;
//		}
//	}
//
//}
//System.out.println(res);