package algo;
import java.util.*;
public class algo11403 {

	static int[][] map;
	static int n;
	static Stack<Integer> s;
	static int[] visit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList res = new ArrayList();
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		map = new int[n][n];
		
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=scan.nextInt();
			}
		}
		int[][] rmap = new int[n][n];
		s = new  Stack<Integer>();
		for(int i=0;i<n;i++) {
			visit = new int[n];
			
			
			for(int j=0;j<n;j++) {
				if(map[i][j]==1) {
					s.push(j);
					dfs(j);
				}			
			}
			while(!s.isEmpty()) {
				int a = (int) s.pop();
				rmap[i][a]=1;
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.printf("%d", rmap[i][j]);
				if(j<n-1) {System.out.printf(" ");}
			}
			System.out.printf("\n");
		}
		
		
	}
	static void dfs(int j) {
		visit[j]=1;
		for(int i = 0;i<n;i++) {
			if(map[j][i]==1&&visit[i]==0) {
				s.push(i);
				dfs(i);
			}
		}
		
		
		
	}
	
	

}
