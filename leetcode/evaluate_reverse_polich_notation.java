package leetcode;
import java.util.*;
/*
 * ���ڴ� stack�� �־����
 * �����ڰ� ������ ���ؿ��� 2���� ���� �����ڿ� �°� ����� �� ���ؿ� �ٽ� ����
 * ���ؿ� ���� ������ ���� ��
 */
public class evaluate_reverse_polich_notation {
	static String[] tokens= {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
	static Stack<Integer> num=new Stack();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<tokens.length;i++) {
			String str=tokens[i];
			if(str.equals("*")||str.equals("+")||str.equals("-")||str.equals("/")) {
				int b=num.pop();
				int a=num.pop();
				int temp=calcul(a,b,str);
				num.push(temp);
			}else {
				num.push(Integer.parseInt(str));
			}
		}
			
		System.out.println(num.pop());
	}
	static int calcul(int a,int b,String c) {
		switch(c) {
		case "+":
			return a+b;
		case "-":
			return a-b;
		case "*":
			return a*b;
		case "/":
			return a/b;
		}
		return 0;
	}
}
