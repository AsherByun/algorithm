package algo;
import java.util.*;
public class algo9663_2 {
	static int n;
	static int[] visit;
	static int[] c;
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		n=scan.nextInt();
		
		
		int c=1;
		
		for(int i=1;i<=n;i++) {
			visit=new int[n+2];
			visit[1]=i;
			dfs(c);
			
		}
		
		System.out.println(count);
		
	}
	static void dfs(int c) {
		
		if(c==n) {
			count++;
		}else {
		
		
		for(int i=1;i<=n;i++) {
			visit[c+1]=i;
			if(ispossible(c+1)) {
				dfs(c+1);
			}else {
				visit[c+1] = 0;
			}
			
			}
		
		}
		visit[c]=0;
		
	}
	
	static boolean ispossible(int c) {
		
		for(int i=1;i<c;i++) {
			if(visit[i]==visit[c]) {
				return false;
			}
			if(Math.abs(visit[i]-visit[c])==Math.abs(i-c)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	

}
