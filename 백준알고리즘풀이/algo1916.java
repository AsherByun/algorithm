package algo;
import java.util.*;
public class algo1916 {

	static int n,m;
	static boolean visit[];
	static int map[][];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int m=scan.nextInt();
		
		int dis[]=new int[n+1];
		map=new int[n+1][n+1];
		int inf=Integer.MAX_VALUE-1;
		visit=new boolean[n+1];
		
		for(int i=1;i<=n;i++)
		Arrays.fill(map[i], inf);
		
		for(int i=1;i<=m;i++) {
			int s=scan.nextInt();
			int e=scan.nextInt();
			int w=scan.nextInt();
			
			if(map[s][e]>w)
			map[s][e]=w;
			
			
			
		}
		int s=scan.nextInt();
		int e=scan.nextInt();
		
		Arrays.fill(dis, inf);
		dis[s]=0;
		
		
		for(int k=1;k<=n;k++) {
		
		
		int from=s;
		int min=inf;
		
		
		
		for(int i=1;i<=n;i++) {
			
			if(dis[i]<min&&!visit[i]) {
				min=dis[i];
				from=i;
			}
		}
		
		visit[from]=true;
		
		for(int i=1;i<=n;i++) {
			
			if(map[from][i]!=inf&&dis[i]>=map[from][i]+dis[from]) {
				dis[i]=map[from][i]+dis[from];
			}
			
			
		}
		
		
		
		
		
		}
		System.out.println(dis[e]);
		
	}

}
