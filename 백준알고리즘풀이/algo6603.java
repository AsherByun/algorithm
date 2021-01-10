package algo;
import java.util.*;
import java.io.*;
public class algo6603 {

	static int n,m;
	static boolean v[];
	static ArrayList res=new ArrayList();

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
			
			int c=1;
			
			
			for(int i=1;i<=n-5;i++) {
				v[i]=true;
				sub.add(map[i]);
				make(i,c+1,sub);
				sub.remove((Integer)map[i]);
				v[i]=false;
			}
			//System.out.println(st.size());
		/*	for(int i=0;i<st.size();i++) {
				ArrayList t=(ArrayList)st.get(i);
				for(int j=0;j<t.size();j++) {
					System.out.printf("%d ", t.get(j));
				}System.out.println("");
				
			}*/
			
			
			
			
			
		}
		System.out.println("");
		
		
		
		
	}
	
	static void make(int k,int c,ArrayList ssub) {
		
		
		System.out.println("asd");
		if(c==7) {
			res.add(ssub);
			
		}
		else {
			for(int i=k+1;i<=n-(7-c);i++) {
				
				if(!v[i]) {
					v[i]=true;
					System.out.println(map[i]);
					ssub.add(map[i]);
					make(i,c++,ssub);
					ssub.remove((Integer)map[i]);
					v[i]=false;
				}
				
				
			}
			
			
			
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
