package leetcode;
/*
 * ���������� ����ؼ� ���� ū��������
 * -> �糡���� ������Ʈ�� ����ϸ� �ӵ��� �ξ� �������� �ִ�.
 */
public class container_with_most_water_11 {
	static int[] height= {1,8,6,2,5,4,8,3,7};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max=0;
		for(int i=0;i<height.length-1;i++) {
			for(int j=i+1;j<height.length;j++) {
				int a=height[i];
				int b=height[j];
				int h=Math.min(a, b);
				max=Math.max(max, h*(j-i));
			}
		}
		System.out.println(max);
	}

}
