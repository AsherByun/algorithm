/*
 * 인풋 받은 값들을 hashset에 저장해서 중복되는 값 제거
 * 우선순위를 길이 -> 길이가같으면 compareto로 대문자,소문자 검사
 * bufferedReader, writer 아니면 시간초가남
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
		//testcase 개수 받기
		for(int tc=0;tc<testc;tc++) {
			int n=Integer.parseInt(br.readLine());
			HashSet<String> h=new HashSet<String>();
			
			for(int i=0;i<n;i++) {
				h.add(br.readLine());
			}
			//우선순위 큐의 우선순위 재설정
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
