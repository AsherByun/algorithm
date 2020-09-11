package algo;
import java.util.*;
public class algo1325 {
	
	static int n,m;
	static ArrayList map[];
	static int visit[];

	static int c;
	static int max=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		n=scan.nextInt();
		m=scan.nextInt();
		
		map=new ArrayList[n+1];
		for(int i=0;i<=n;i++)map[i]=new ArrayList();
		
		visit=new int[n+1];
		
		for(int i=1;i<=m;i++) {
			int e=scan.nextInt();
			int s=scan.nextInt();
			
			map[e].add(s);
		}
		
		ArrayList res=new ArrayList();
		for(int i=1;i<=n;i++) {
			
			if(visit[i]==0) {
				boolean v[]=new boolean[n+1];
				v[i]=true;
				//ArrayList a=new ArrayList();
				//a.add(i);
				visit[i]++;
				find(i,v);
			}
			
		}
		
		for(int i=1;i<=n;i++) {
			if(max<=visit[i]) max=visit[i];
				
			
		}
	//	for(int i=1;i<=n;i++)
	//		System.out.println(visit[i]);
		
		
		for(int i=1;i<=n;i++) {
			if(visit[i]==max)System.out.printf("%d ",i);
		}
			
	}
	
	static void find(int num,boolean v[]) {
		
		if(map[num].size()>0) {
		for(int i=0;i<map[num].size();i++) {
			int temp=(int)map[num].get(i);
			
			if(visit[temp]==0) {
				visit[temp]=visit[num]+1;
				find(temp,v);
			}
			else {
				visit[temp]+=visit[num];
				adding(visit[num],temp);
			}
		}
		}	
}
	
	static void adding(int w,int num) {
		
		for(int i=0;i<map[num].size();i++) {
			int temp=(int)map[num].get(i);
		
			visit[temp]+=w;
			adding(w,temp);
		
	}
	
	}
	
	
}