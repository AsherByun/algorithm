//위상정렬 dfs

package algo;
import java.util.*;
public class algo1005_1 {
	static Stack s;
	static ArrayList num[];
	static ArrayList<Integer> map[];
	static boolean visit[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int tc=scan.nextInt();
		
		for(int ttt=0;ttt<tc;ttt++) {
			int n=scan.nextInt();
			int k=scan.nextInt();
			
			int time[]=new int[n+1];
			for(int i=1;i<=n;i++)time[i]=scan.nextInt();
			
			map=new ArrayList[n+1];
			for(int i=1;i<=n;i++) {
				map[i]=new ArrayList();
			}
			num=new ArrayList[n+1];
			for(int i=0;i<=n;i++) {
				num[i]=new ArrayList();
			}
			
			for(int i=1;i<=k;i++) {
				int s=scan.nextInt();
				int e=scan.nextInt();
				
				map[e].add(s);
			}
			int tar=scan.nextInt();
			
			
			
			s=new Stack();
			visit=new boolean[n+1];
			for(int i=0;i<map[tar].size();i++) {
				ArrayList a=new ArrayList();
				a.add(map[tar].get(i));
				if(!visit[map[tar].get(i)]) {
					visit[map[tar].get(i)]=true;
					dfs(a,map[tar].get(i),1);
				}
			}
			
			s.push(tar);
			int tot=0;
			while(!s.isEmpty()) {
				int temp=(int)s.pop();
				tot+=time[temp];
				
			}
			
		//	System.out.println(tot);
		}
		
		
		
	}
	static void dfs(ArrayList a,int nx,int c) {
		
		boolean can=false;
		
		for(int i=0;i<map[nx].size();i++) {
			
		}
		
		
		
		
	}

}
