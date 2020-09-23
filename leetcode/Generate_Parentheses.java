package leetcode;
/*
 * dfs�� ����Ͽ� ������ ����
 * ó���� �׻� (�� ����
 * (�� ������ n���� �۴ٸ� ���ؿ� ������ �ٽ� Ž��
 * ������ ����� 0�̾ƴ϶�� pop() �� �� ���ڿ��� )�� �߰��ϰ� �ٽ� Ž��
 */
import java.util.*;
public class Generate_Parentheses {
	static int k;
	static List list;
	public static void main(String[] args) {
		k=3;
		list=new ArrayList();
		
		Stack s = new Stack();
		s.add('(');
		dfs(1,0,1,s,"(");
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	static void dfs(int l,int r,int c,Stack s,String str) {
		if(c==(k*2)) {
			if(s.size()==0&&l==k&&r==k) {
				list.add(str);
				return;
			}
		}
		Stack temp=(Stack)s.clone();
		if(l<k) {
			temp.add('(');
			dfs(l+1,r,c+1,temp,str+"(");
			temp.pop();
		}
		
		if(!temp.isEmpty()) {
			temp.pop();
			dfs(l,r+1,c+1,temp,str+")");
		}
	}
}
