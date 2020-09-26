package algo;
import java.util.*;
import java.io.*;
public class algo1753_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String in[]=br.readLine().split(" ");
		
		int n=Integer.parseInt(in[0]);
		int m=Integer.parseInt(in[1]);
		int x=Integer.parseInt(br.readLine());
		HashMap h[]=new HashMap[n+1];
		
		for(int i=1;i<=n;i++) {
			h[i]=new HashMap();
		}
		
		for(int i=0;i<m;i++) {
			in=br.readLine().split(" ");
			
			int s=Integer.parseInt(in[0]);
			int e=Integer.parseInt(in[1]);
			double w=Integer.parseInt(in[2]);
			
			h[s].put(e, w);
			
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {if(i==k)continue;
				for(int j=1;j<=n;j++) {if(i==j||k==j)continue;
					if(h[i].containsKey(j)&&h[i].containsKey(k)&&h[k].containsKey(j)) {
						h[i].put(j, Math.min((double)h[i].get(k)+(double)h[k].get(j), (double) h[i].get(j)));
					}else if(h[i].containsKey(k)&&h[k].containsKey(j)) {
						h[i].put(j,(double)h[i].get(k)+(double)h[k].get(j));
					}
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			if(i==x) {System.out.println(0);}
		else if(h[x].containsKey(i)) {
				double a=(double)h[x].get(i);
				System.out.println((int)a);
			}else {
				System.out.println("INF");
			}
		}
		
		
		
	}

	
}

