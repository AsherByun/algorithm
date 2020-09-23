import java.util.HashMap;
/*
 * ���Ͽ� ���ε� �˰����� �����
 * �ִ� �ּҰ��� �˼���� �迭�̾ƴ� HashMap�� �������
 * �� �����̵����� ���� �ڱ⺸�� 1ū���� �ִ��� ������ Ȯ���� �� ������  1ū���� �θ� �ڽ��� �θ�� ����
 * ���� 1���� ���� Ȯ���ѵ� ������ 1�������� �θ� �ڽ��� �θ�� �ٲ�
 * ������ �ٽ� �ѹ��� ���鼭 �� �θ�� �ڽ��� ���� ���� �ִ���̸� Ȯ���� -> but �Է� ������ ���׹����̶� ������Ʈ�� �ȵȾֵ��� �־ findback���� �����
 * ���� ū �θ� ã�Ƽ� ���ߵ�
 */
public class Longest_Consecutive_Sequence {
	static HashMap h;
	static int nums[]= {1,3,5,2,4};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  h=new HashMap();
			for(int i=0;i<nums.length;i++) {
				h.put(nums[i], nums[i]);
				int temp=find(nums[i]+1);
				h.put(nums[i],temp);
				
				if(h.containsKey(nums[i]-1)) {
					h.put(nums[i]-1,temp);
				}
				
			}
			
			int max=0;
			for(int i=0;i<nums.length;i++) {
				int temp=(int)h.get(nums[i]);
				if((int)h.get(temp)!=temp) {
					temp=backfind(temp);
				}
				max=Math.max(max, (temp-nums[i]+1));
			}
	        System.out.println(max);
		}
		static int backfind(int t) {
			int temp=(int)h.get(t);
			if(t==temp) {
				return temp;
			}else {
				return backfind(temp);
			}
		}
		static int find(int x) {
			if(h.containsKey(x)) {
				int temp=(int)h.get(x);
				if(x==temp)return x;
				else return find(temp);
			}
			else return x-1;
		}
	}
