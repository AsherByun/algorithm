package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class algo1722 {
	static boolean visit[];
	static ArrayList res;
	static int tot=0;
	static ArrayList com;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		int n=Integer.parseInt(br.readLine());
		String in[]=br.readLine().split(" ");
		
		int tc=Integer.parseInt(in[0]);
		int map[]=new int[in.length];
		int t=0;
		
		if(tc==1) {
			t=Integer.parseInt(in[1]);
			visit=new boolean[n+1];
			res=new ArrayList();
			find1(t,n,0,new ArrayList());
			
			
		}else {
			com=new ArrayList();
			for(int i=1;i<in.length;i++) {
				com.add(Integer.parseInt(in[i]));
			}
			visit=new boolean[n+1];
			find2(new ArrayList(),0,n);
			
		}
		
		
	}
	static void find1(int tar,int n,int c,ArrayList a) {
		
		if(c==n) {
			tot++;
			if(tot==tar) {
				for(int i=0;i<a.size();i++) {
					System.out.printf("%d ", (int)a.get(i));
				}
			}
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(!visit[i]) {
				visit[i]=true;
				a.add(i);
				find1(tar,n,c+1,a);
				visit[i]=false;
				a.remove((Integer)i);	
			}
		}
		
		
	}
	static void find2(ArrayList b,int c,int n) {
		
		if(n==b.size()) {
			tot++;
			if(b.equals(com)) {
				System.out.println(tot);
			}
			
		}
		
		for(int i=1;i<=n;i++) {
			if(!visit[i]) {
				visit[i]=true;
				b.add(i);
				find2(b,c+1,n);
				visit[i]=false;
				b.remove((Integer)i);	
			}
		}
		
		
		
	}
	
}