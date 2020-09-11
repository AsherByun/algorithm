package algo;
import java.util.*;
import java.io.*;
public class algo1325_1 {
	
	static int n,m;
	static ArrayList<Integer> map[];
	static int visit[];
	static int c;
	static boolean v[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		map=new ArrayList[n+1];
		for(int i=0;i<=n;i++)map[i]=new ArrayList();
		
		visit=new int[n+1];
		
		for(int i=1;i<=m;i++) {
			in=br.readLine().split(" ");
			int e=Integer.parseInt(in[0]);
			int s=Integer.parseInt(in[1]);
			
			map[e].add(s);
		}
		
		for(int i=1;i<=n;i++) {
			v=new boolean[n+1];
			find(i);
			
		}
		int max=0;
		for(int i=1;i<=n;i++) {
			if(max<visit[i]) max=visit[i];
		}
		
		for(int i=1;i<=n;i++) {
			if(visit[i]==max)System.out.printf("%d ",i);
		}
			
		
		
	}
	
	static void find(int num) {
		
		v[num]=true;
		
			
			for(int i: map[num]) {

				if(!v[i]) { 
					visit[i]++;
					find(i);
					}
		}
			
	}
	
}
