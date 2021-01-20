package algo;
import java.util.*;
import java.io.*;
public class algo9466 {
	
	static int n,m;
	static int map[];
	static int visit[];
	static boolean v[];
	static int c;
	static boolean can;
	static ArrayList res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc=Integer.parseInt(br.readLine());
		
		for(int t=0;t<tc;t++) {
			
			n=Integer.parseInt(br.readLine());
			map=new int[n+1];
			String in[]=br.readLine().split(" ");
			
			
			for(int i=1;i<=n;i++)map[i]=Integer.parseInt(in[i-1]);
			
			
			c=0;
			
			
			visit=new int[n+1];
			for(int i=1;i<=n;i++) {
				if(visit[i]==0&&visit[map[i]]==0) {
				visit[i]=1;
				find(map[i]);
				}
				
			}
			
			
			System.out.println(n-c);
			
			
		}
		
		
		
	}
	static void find(int num) {
		visit[num]=1;
		
		if(visit[map[num]]==2) {}
		else if(visit[map[num]]==1) {
				trace(map[num]);
			}
			else find(map[num]);
		
		
		}
		
	static void trace(int tar) {
		
		
		int po=tar;
		visit[po]=2;
		while(true) {
			c++;
			po=map[po];
			visit[po]=2;
			if(po==tar)break;
			
		}

	}
}