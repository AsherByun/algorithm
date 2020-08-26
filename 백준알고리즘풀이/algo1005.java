package algo;
import java.util.*;
public class algo1005 {
	static int tot=0;
	static int time[];
	static ArrayList map[];
	static int max=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int testc=scan.nextInt();
		
		for(int ic=0;ic<testc;ic++) {
			
			int n=scan.nextInt();
			int k=scan.nextInt();
			
			time=new int[n+1];
		//	int map[][]=new int[n][n];
			map=new ArrayList[n+1];
			for(int i=1;i<=n;i++)map[i]=new ArrayList();
			
			for(int i=1;i<=n;i++)time[i]=scan.nextInt();
			
			for(int i=1;i<=k;i++) {
				int s=scan.nextInt();
				int e=scan.nextInt();
				
				map[e].add(s);
				
//				map[s][e]=1;
//				map[e][s]=1;
			}
			int tar=scan.nextInt();
			
//			Queue q=new LinkedList();
//			
//			tot=time[tar];
//			for(int i=0;i<map[tar].size();i++) {
//				q.add(map[tar].get(i));
//			}
			
//			while(!q.isEmpty()) {
//				System.out.println((int)q.poll());
//			}
			int first=time[tar];
			max=first;
			
			for(int i=0;i<map[tar].size();i++) {
				int temp=(int)map[tar].get(i);
				find(temp,first);
			}
			
			
			System.out.println(max);	
		
		}
	}
	
	static void find(int nx,int tot) {
		
		if(map[nx].size()==0) {
			tot+=time[nx];
			if(max<tot)max=tot;
			return;
		}
		
		for(int i=0;i<map[nx].size();i++) {
			int t=(int)map[nx].get(i);
			find(t,tot+time[nx]);
			
		}
		
		
		
		
		
	}

}
