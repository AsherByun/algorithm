package algo;
import java.util.*;
import java.io.*;
public class algo6603_1 {

	static int n,m;
	static boolean v[];
	static ArrayList res=new ArrayList();
	static ArrayList st;
	static int map[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		
		
		while(true) {
			
			
			
			String in[]=br.readLine().split(" ");
			n=Integer.parseInt(in[0]);
			
			if(n==0)break;
			
			map=new int[50];
			
			v=new boolean[n+1];
			
			for(int i=1;i<=n;i++) {
				
				map[i]=Integer.parseInt(in[i]);
				
			}
			
			ArrayList sub=new ArrayList();
		
			for(int i=1;i<=n-5;i++) {
				
				v[i]=true;
				sub.add(map[i]);
				find(map[i],sub);
				sub.remove((Integer)map[i]);
				v[i]=false;
				
				
			}
			
			
			System.out.println("");
			
			
				
	}

		
		
		
		
		
}
	
	static void find(int k,ArrayList s) {
		
		
		if(s.size()==6) {
			res.add(s);
			for(int j=0;j<s.size();j++) {
				System.out.printf("%d ", s.get(j));
			}System.out.println("");
		}
		else {
			
			for(int i=1;i<=n;i++) {
				
				if(!v[i]&&map[i]>k) {
					v[i]=true;
					s.add(map[i]);
					find(map[i],s);
					s.remove((Integer)map[i]);
					v[i]=false;
					
				}
				
				
			}
			
			
			
			
			
		}
		
		
		
		
		
	}
	
	
}