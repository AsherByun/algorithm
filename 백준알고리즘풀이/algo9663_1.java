package algo;
import java.util.*;
public class algo9663_1 {
	static int n;
	static int[][] map;
	static boolean[] visit;
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		n=scan.nextInt();
		
		visit=new boolean[n+2];
		int c=1;
		for(int i=1;i<=n;i++) {
			
			visit[i]=true;
			find(i,c);
			visit[i]=false;
		}
		
		System.out.println(count);
		
	}
	static void find(int x,int c) {
		
		if(c==n) {
			count++;
		}else {
		
		
		for(int i=1;i<=n;i++) {
			if(!visit[i]&&!visit[i-1]&&!visit[i+1]) {
				c++;
				visit[i]=true;
				find(i,c);
				visit[i]=false;
				}
			}
		
		}
		
		
	}
	
	

}
