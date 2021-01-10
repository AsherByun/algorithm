package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo6118_1 {
	
	static boolean visit[];
	static int cmap[];
	static int n,m;
	static List link[];
	static Queue q=new LinkedList();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in[]=br.readLine().split(" ");
		
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		visit=new boolean[n+1];
		cmap=new int[n+1];
		link=new ArrayList[n+1];
		
		for(int i=1;i<=n;i++) {
			link[i]=new ArrayList();
			
		}
	
		for(int i=1;i<=m;i++) {
			String ina[]=br.readLine().split(" ");
			
			int s=Integer.parseInt(ina[0]);
			int e=Integer.parseInt(ina[1]);
			
			link[s].add(e);
			link[e].add(s);
			
		}
		
		visit[1]=true;
		cmap[0]=0;
		q.add(1);
		int c=0;
		int max=0;
		while(!q.isEmpty()) {
			
			int temp=(int)q.poll();
			
			
			for(int i=0;i<link[temp].size();i++) {
				int t=(int)link[temp].get(i);
				if(!visit[t]) {
					cmap[t]=cmap[temp]+1;
					if(cmap[t]>max) {max=cmap[t];}
					visit[t]=true;
					q.add(t);
				}
				
				
			}
			
			
			
			
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
	
	

}
