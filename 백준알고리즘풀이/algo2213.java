package algo;
import java.util.*;
public class algo2213 {
	static int w[];
	static ArrayList map[]; 
	static boolean visit[];
	static int max=0;
	static ArrayList tree[];
	static boolean cho[];
	static int dp[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		w=new int[n+1];
		dp=new int[n+1][2];
		for(int i=1;i<=n;i++) {
			w[i]=scan.nextInt();
		}
		map=new ArrayList[n+1];
		for(int i=1;i<=n;i++)map[i]=new ArrayList();
		for(int i=1;i<=n;i++)tree[i]=new ArrayList();
		
		for(int i=0;i<n-1;i++) {
			int t1=scan.nextInt();
			int t2=scan.nextInt();
			map[t1].add(t2);
			map[t2].add(t1);
		}
		
		tree=new ArrayList[n+1];
		findt(1,0);
		
		
		
		
	}
	static int find(int now) {
		
		
	}
	
	
	static void findt(int now, int prv) {
		for(int i=0;i<map[now].size();i++) {
			int next=(int)map[now].get(i);
			if(next!=prv) {
				tree[now].add(next);
				findt(next,now);
			}
			
		}
	}
}
