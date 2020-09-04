package algo;
import java.util.*;
public class algo1260 {
	static ArrayList ddfs=new ArrayList();
	static ArrayList bbfs=new ArrayList();
	static int n,m;
	static int map[][];
	static boolean visit[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		
		n=scan.nextInt();
		m=scan.nextInt();
		int v=scan.nextInt();
		
		map=new int[n+1][n+1];
		for(int i=0;i<m;i++) {
			int t1=scan.nextInt();
			int t2=scan.nextInt();
			
			map[t1][t2]=1;
			map[t2][t1]=1;
			
		}
		visit=new boolean[n+1];
		dfs(v);
		visit=new boolean[n+1];
		bfs(v);
		
		
		for(int i=0;i<ddfs.size();i++)System.out.printf("%d ",ddfs.get(i));
		System.out.println("");
		for(int i=0;i<bbfs.size();i++)System.out.printf("%d ",bbfs.get(i));
		

	}
	
	static void dfs(int v) {
		
		visit[v]=true;
		ddfs.add(v);
		for(int i=1;i<=n;i++) {
			if(!visit[i]&&map[v][i]==1) {
				dfs(i);
			}
			
			
		}
		
		
		
	}
	
	
	static void bfs(int v) {
		
		Queue q=new LinkedList();
		q.add(v);
		visit[v]=true;
		
		while(!q.isEmpty()) {
			int temp=(int)q.poll();
			bbfs.add(temp);
			
			
			
			for(int i=0;i<=n;i++) {
				if(!visit[i]&&map[temp][i]==1) {
					visit[i]=true;
					q.add(i);
				}
				
			}
			
			
			
		}
		
		
		
		
	}
	
	

}
