package leetcode;
/*
 * �� �ڸ����� �κ� ���ڿ��� ���ؼ� ��Ī���� Ȯ��.
 * ȿ�������� �ſ� ������������ ����
 * O(mN^2)
*/
import java.util.*;
public class palindrom_substrings {
	static String s = "aba";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=s.length();
		for(int i=0;i<s.length();i++) {
			for(int j=i+2;j<=s.length();j++) {
				if(find(s.substring(i, j))){
					res++;
				}
			}
		}
		System.out.println(res);
	}
	static boolean find(String str) {//�¿��Ī���� Ȯ���ϴ� �Լ�
		int start=0;
		int end=str.length()-1;
		
		while(start<=end) {
			if(str.charAt(start)!=str.charAt(end)) {
				return false;
			}
			start++;end--;
		}
		
		return true;
	}
}
