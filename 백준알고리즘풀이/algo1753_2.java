package algo;
import java.util.*;
import java.io.*;
public class algo1753_2 {
	static HashMap h[];
	static int n,m,x;
	static int dis[];
	static PriorityQueue <dnode>pq=new <dnode>PriorityQueue();
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String in[]=br.readLine().split(" ");
		
		 n=Integer.parseInt(in[0]);
		 m=Integer.parseInt(in[1]);
		 x=Integer.parseInt(br.readLine());
		
		h=new HashMap[n+1];
		dis=new int[n+1];
		Arrays.fill(dis, 9999999);
		visit=new boolean[n+1];
		
		
		for(int i=1;i<=n;i++) {
			h[i]=new HashMap();
		}
		dis[x]=0;
		
		for(int i=0;i<m;i++) {
			in=br.readLine().split(" ");
			
			int s=Integer.parseInt(in[0]);
			int e=Integer.parseInt(in[1]);
			int w=Integer.parseInt(in[2]);
			
		/*	if(s==x) {
				if(dis[e]>w) {
					dis[e]=w;
					pq.add(-w);
				}
				
			}*/
			if(h[s].containsKey(e)) {
				if((int)h[s].get(e)>w)h[s].replace(e, w);
			}
			else h[s].put(e, w);
			
		}
		
		find(x);
		
	/*	for(int i=1;i<=n;i++) {
			if(i==x) {
				System.out.println(0);
			}else if(start.containsKey(i)) {
				System.out.println(start.get(i));
			}else {
				System.out.println("INF");
			}
			
			
		}*/
		
		for(int i=1;i<=n;i++) {
			if(i==x) {
				System.out.println(0);
			}else if(dis[i]==9999999) {
				System.out.println("INF");
			}else {
				System.out.println(dis[i]);
			}
		}
		
	}
	
	static void find(int st) {
		visit[st]=true;
		
		for(Object key:h[st].keySet()) {
			int t=(int)h[st].get(key);
			int k=(int)key;
			
			if(!visit[k]&&dis[st]+t<dis[k]) {
				dis[k]=dis[st]+t;
				pq.offer(new dnode(k,dis[k]));
				
			}
		}
		
		while(!pq.isEmpty()) {
			
			dnode temp=pq.poll();
					
			if(!visit[temp.index]) {
				find(temp.index);
				break;
			}
			
			
		}
		
		
		
		
	}
	
	

	
}
class dnode implements Comparable<dnode>{
	
	int index;
	int dis;
	
	dnode(int index,int dis){
		this.index=index;
		this.dis=dis;
	}
	int getindex() {
		return index;
	}
	int getdis() {
		return dis;
	}
	
	@Override
	public int compareTo(dnode o) {
		// TODO Auto-generated method stub
		return dis<=o.dis?-1:1;
	}
	
	
	
	
	
	
	
	
}
