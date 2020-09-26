package algo;
import java.util.*;
import java.io.*;
public class algo1753 {
	static HashMap h[];
	static int n,m,x;
	static HashMap start=new HashMap();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String in[]=br.readLine().split(" ");
		
		 n=Integer.parseInt(in[0]);
		 m=Integer.parseInt(in[1]);
		 x=Integer.parseInt(br.readLine());
		
		h=new HashMap[n+1];
		
		for(int i=1;i<=n;i++) {
			h[i]=new HashMap();
		}
		
		for(int i=0;i<m;i++) {
			in=br.readLine().split(" ");
			
			int s=Integer.parseInt(in[0]);
			int e=Integer.parseInt(in[1]);
			int w=Integer.parseInt(in[2]);
			
			if(s==x) {
				start.put(e, w);
			}
			h[s].put(e, w);
			
		}
		
		find(x,0);
		
		for(int i=1;i<=n;i++) {
			if(i==x) {
				System.out.println(0);
			}else if(start.containsKey(i)) {
				System.out.println(start.get(i));
			}else {
				System.out.println("INF");
			}
			
			
		}
		
		
	}
	
	static void find(int st,int l) {
		

		for(Object gop:h[st].keySet()) {
			int gow=l+(int) h[st].get(gop);
			
			if(start.containsKey(gop)) {
				if((int)start.get(gop)>=gow) {
					start.replace(gop, gow);
					find((int)gop,gow);
				}
				
			}else {
				start.put(gop, gow);
				find((int)gop,gow);
			}
			
			
		}
		
		
		
		
		
	}
	
	

	
}

