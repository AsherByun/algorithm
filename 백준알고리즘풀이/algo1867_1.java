package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo1867_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		int n=Integer.parseInt(in[0]);
		int m=Integer.parseInt(in[1]);
		boolean visit[]=new boolean[n+1];

		xnode node[]=new xnode[n+1];

		for(int i=1;i<=n;i++) {
			node[i]=new xnode();
		}
		
		for(int i=1;i<=m;i++) {
			String ina[]=br.readLine().split(" ");
			int a=Integer.parseInt(ina[0]);
			int b=Integer.parseInt(ina[1]);
			
			node[a].pick.add(b);
			
		}
		int c=0;
		
		for(int i=1;i<=n;i++) {
			//boolean check=false;
			
			for(int j=0;j<node[i].pick.size();j++) {
				int temp=(int)node[i].pick.get(j);
				if(!visit[temp]) {
					c++;visit[temp]=true;break;
				}
			}
			
			
		}
		
		
		System.out.println(c);
		
		
		
	}
}

class xnode{
	ArrayList pick=new ArrayList();
		xnode(){}
}