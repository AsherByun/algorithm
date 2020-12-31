package algo;
import java.util.*;
public class algo2644 {

	static int[][] map;
	static int n,m;
	static int[] visit;
	static int count=0;
	static boolean res=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		n=scan.nextInt();
		map=new int[n+1][n+1];
		visit = new int[n+1];
		int t1=scan.nextInt();
		int t2=scan.nextInt();
		
		m=scan.nextInt();
		
		for(int i=1;i<=m;i++) {
			int a=scan.nextInt();
			int b=scan.nextInt();
			
			map[a][b]=1;
			map[b][a]=1;
		}
		
		int c=-1;
		find(t1,t2,c);
		
		if(res) {
		System.out.printf("%d", count);
		}else {System.out.printf("-1");}

	}

	static void find(int t1,int t2,int c) {
		visit[t1]=1;
		c++;
		if(t1==t2) {
			count=c;
			res=true;
		}
		
		else {
		for(int i=1;i<=n;i++) {
			if(visit[i]==0&&map[t1][i]==1) {
				map[t1][i]=0;
				map[i][t1]=0;
				
				find(i,t2,c);
			}
			
		}
		
		
	}
	
	
	
}
	
	
}
