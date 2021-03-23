/*
 * ��ǲ ���� ������ hashset�� �����ؼ� �ߺ��Ǵ� �� ����
 * �켱������ ���� -> ���̰������� compareto�� �빮��,�ҹ��� �˻�
 * bufferedReader, writer �ƴϸ� �ð��ʰ���
 */
package samsong;
import java.util.*;
import java.io.*;
public class sw7701 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int testc=Integer.parseInt(br.readLine());
		//testcase ���� �ޱ�
		for(int tc=0;tc<testc;tc++) {
			int n=Integer.parseInt(br.readLine());
			HashSet<String> h=new HashSet<String>();
			
			for(int i=0;i<n;i++) {
				h.add(br.readLine());
			}
			//�켱���� ť�� �켱���� �缳��
		PriorityQueue sorted=new PriorityQueue<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()<o2.length())return -1;
				else if(o1.length()>o2.length())return 1;
				else {
					return o1.compareTo(o2);
				}
			}
		});
			for(String str:h) {
				sorted.add(str);
			}
		
		
			bw.write("#"+(tc+1)+"\n");
			while(!sorted.isEmpty()) {
				String str=(String)sorted.poll();
				bw.write(str+"\n");
			}
			bw.flush();
			
		}
	}

}
