package algo;
import java.util.*;
public class algo10989_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		StringBuilder sb=new StringBuilder();
		int map[]=new int[n];
		int max=-1;
		
		int h[]=new int[10001];
		boolean visit[]=new boolean[10001];
		
		for(int i=0;i<n;i++) {
			map[i]=scan.nextInt();
			if(max<map[i])max=map[i];
			h[map[i]]++;
		}
		
		for(int i=1;i<=max;i++) {
			if(h[i]>0) {
				for(int j=0;j<h[i];j++) {
					sb.append(i+"\n");
				}
			}
			
		}
		
		System.out.println(sb);
		
		
	}

}
