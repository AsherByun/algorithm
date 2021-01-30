package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		int map[]=new int[n];
		int max=-1;
		
		int h[]=new int[10001];
		boolean visit[]=new boolean[10001];
		
		for(int i=0;i<n;i++) {
			map[i]=Integer.parseInt(br.readLine());
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
