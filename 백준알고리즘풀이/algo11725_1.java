package algo;
import java.util.*;
public class algo11725_1 {

	static int[][] map;
	static int n;

	static HashMap h = new HashMap();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		n= scan.nextInt();
		map=new int[n+1][n+1];
		
		for(int i=1;i<n;i++) {
			int a=scan.nextInt();
			int b=scan.nextInt();
		
			map[a][b]=1;
			map[b][a]=1;		
		
			
		}
		
		find(1);
		
		for(int i=2;i<=n;i++) {
			System.out.println(h.get(i));
		}
		
		
		
		
	}
	
	static void find(int st) {
		
		for(int i=1;i<=n;i++) {
			if(map[st][i]==1) {
				map[st][i]=0;
				map[i][st]=0;
				h.put(i,st);
				find(i);
				
			}
			
			
		}
		
		
		
		
	}
	
	

}
