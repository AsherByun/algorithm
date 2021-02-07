package algo;
import java.util.*;
public class algo11724 {
	static int n;
	static int m;
	static int[][] map;
	static int[] visit;
	static int count=0;
	static Stack<Integer> s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList res = new ArrayList();
		
		n=scan.nextInt();
		m=scan.nextInt();
		
		map=new int[n][n];
		visit = new int[n];
		for(int i=0;i<m;i++) {
			int a=scan.nextInt();
			int b=scan.nextInt();
			map[a-1][b-1]=1;
			map[b-1][a-1]=1;			
		}
		s = new Stack<Integer>();
		for(int i=0;i<n;i++) {
			if(visit[i]==0) {
				count++;
			for(int j=0;j<n;j++) {
				if(map[i][j]==1) {
					
					find(j);
				}
				
			}
			
			
		}
		visit[i]=1;	
			
	}
		System.out.println(count);
		
	}
	static void find(int j) {
		visit[j]=1;
		for(int i=0;i<n;i++) {
			if(visit[i]==0&&map[j][i]==1) {
				
				find(i);
			}
			
			
		}
		
	}
	
	
	

}
