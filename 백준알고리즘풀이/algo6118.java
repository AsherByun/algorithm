package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo6118 {
	
	static boolean visit[];
	static int map[][];
	static int cmap[];
	static int n,m;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");		
		int n=Integer.parseInt(in[0]);
		int m=Integer.parseInt(in[1]);
		//System.out.println(n+m);
		
		map=new int[n+1][n+1];
		visit=new boolean[n+1];
		cmap=new int[n+1];
		Arrays.fill(cmap, 999999);
		
		for(int i=1;i<=m;i++) {
			String[] temp = br.readLine().split(" ");		
			int s=Integer.parseInt(temp[0]);
			int e=Integer.parseInt(temp[1]);
			System.out.println(s+"  "+e);
			map[s][e]=1;
			map[e][s]=1;
			
		}
		
		visit[1]=true;
		find(1,0);
		
		int max=0;
		for(int i=2;i<=n;i++) {
			if(cmap[i]>max) {max=cmap[i];}
		}
		
		int count=0;
		int num=0;
		for(int i=1;i<=n;i++) {
			if(cmap[i]==max) {
				if(count==0) {num=i;}
				count++;
			}
		}
		System.out.println(num+" "+max+" "+count);
		
		
	}
	
	static void find(int node,int c){
		
		if(node!=1&&c<cmap[node]) {
			cmap[node]=c;
			
		}
		
		
		for(int i=1;i<=n;i++) {
			if(map[node][i]==1&&!visit[i]) {
				visit[i]=true;
				find(i,c+1);
				visit[i]=false;
				
			}
			
		}
		
		
	}

}
