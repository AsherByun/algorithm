package algo;
/* dp�� ������
 * map=>input ���� ���� ����
 * dp =>���� ���ڰ� ���Ե� �������� ������ ��
 * 0->n ���� �����ϸ鼭 ���� dp�� ����� ���� ���� ū���� ���� ������ �۰� ���� dp���� �۴ٸ� 
 * ���� �ٲ���
 */


import java.util.*;
public class algo11055_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int map[]=new int[n];
		int dp[]=new int[n];
		
		for(int i=0;i<n;i++) {
			map[i]=scan.nextInt();
		}
		dp[0]=1;
		int max=0;
		
		for(int i=0;i<n;i++) {
			dp[i]=map[i];
			for(int j=0;j<i;j++) {
				//���� ������ �ڽ����� ���� �� ���� Ŀ���� ��������� ��� ->dp update
				if((dp[j]+map[i]>dp[i])&&map[i]>map[j]) {
					dp[i]=map[i]+dp[j];
				}
			}
			if(max<dp[i])max=dp[i];
		}
		System.out.println(max);
	}

}
