package algo;
import java.util.*;
public class algo1005_2 {
	static int n;
	static int k;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int tc=scan.nextInt();
		
		for(int tt=0;tt<tc;tt++) {
			n=scan.nextInt();
			k=scan.nextInt();
			
			boolean map[][]=new boolean[n+1][n+1];
			int time[]=new int[n+1];
			
			for(int i=1;i<=n;i++)time[i]=scan.nextInt();
			
			int indegree[]=new int[n+1];
			for(int i=0;i<k;i++) {
				int s=scan.nextInt();
				int e=scan.nextInt();
				
				map[s][e]=true; indegree[e]++;
			}
			int tar=scan.nextInt();
			
			
			int[] res=find(map,time,indegree);
			
			
			System.out.println(res[tar]);
		}
		
		
	}
	static int[] find(boolean map[][],int time[],int indegree[]) {
		
		int res[]=new int[n+1];
		Queue q=new LinkedList();
		
		for(int i=1;i<=n;i++) {
			if(indegree[i]==0) {
				q.offer(i);
				res[i]+=time[i];
			}
		}
		
		while(!q.isEmpty()) {
			
			int v=(int)q.poll();
			
			for(int i=1;i<=n;i++) {
				
				if(map[v][i]) {
					res[i]=Math.max(res[i], res[v]+time[i]);
					indegree[i]--;
				
				if(indegree[i]==0) {
					q.offer(i);
				}
				}
			}
			
		}
		
		
		
		
		
		
		return res;
	}
}
