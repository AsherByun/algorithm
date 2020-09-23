package leetcode;
/*
 * PriorityQueue�� ���
 * �ΰ��� �� ex) a1,a2 ->   a1a2�� a2a1�� ���ؼ� a1a2�� ũ�ٸ� a1,a2������ ����, a2a1�� �� ũ�ٸ� a2,a1�� �����ϴ� �������
 * ť�� ���� ������ ������� �����鼭 ���ڸ��� �����ϸ� ���� ū���� ����
 */
import java.util.*;
public class Largest_Number {
	static int nums[]= {0,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1=o1.toString();
				String s2=o2.toString();

				String t1 = (s1+s2);
				String t2 = (s2+s1);
				
				for(int i=0;i<t1.length();i++) {
					int a1=t1.charAt(i)-'0'; int a2=t2.charAt(i)-'0';
					if(a1>a2) return -1;
					else if(a1<a2)return 1;
					else continue;
				}
				return 0;
				
			}
		});
		for(int i=0;i<nums.length;i++) {
			pq.add(nums[i]);
		}
		String str="";
		boolean can=false;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0)can=true;
			str+=pq.poll();
			
		}
		if(!can)System.out.println("0");
		else System.out.println(str);
	}

}
