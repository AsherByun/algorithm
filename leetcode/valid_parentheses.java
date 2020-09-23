package leetcode;
/*
 * stack�� �����
 * ���� ��ȣ���� ������ ���ؿ� ����
 * �ݴ� ��ȣ���� ������ ���� �ֱٿ� ���� ��ȣ�� �����ͼ� ���Ͽ� ��Ī�Ǹ� ��� �ƴϸ� ����
 * ��� ���ڸ� ���Ŀ� ���ؿ� ���� �����ִٸ� ����
 * O(N)
 */
import java.util.*;
public class valid_parentheses {
	static String s="(}";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		boolean can=true;
		for(int i=0;i<s.length();i++) {
			char now=s.charAt(i);
			if(now=='['||now=='{'||now=='(') {
				stack.push(now);
			}else {
				if(stack.isEmpty()) {
					can=false;break;
				}else {
					char temp=(char)stack.pop();
					if(temp=='[') {
						if(now!=']') {can=false;break;}
					}else if(temp=='{') {
						if(now!='}') {can=false;break;}
					}else {
						if(now!=')') {can=false;break;}
					}
				}
			}
		}
		if(!stack.isEmpty())can=false;
		if(can)System.out.println("true");
		else System.out.println("false");
	}

}
