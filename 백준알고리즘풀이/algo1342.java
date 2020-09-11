package algo;
import java.util.*;
import java.io.*;

public class algo1342 {
	static int n;static int tot=0;
	static boolean visit[];
	static String map[];
	static HashSet h=new HashSet();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		map=br.readLine().split("");
		
		n=map.length;
		visit=new boolean[n];
		
		for(int i=0;i<n;i++) {
			ArrayList a=new ArrayList();
			a.add(map[i]);
			visit[i]=true;
			find(a,1);
			visit[i]=false;
		}
		
		System.out.println(tot);
	}
	static void find(ArrayList a,int c) {
		if(c>=2) {
			String t1=(String)a.get(c-2);
			String t2=(String)a.get(c-1);
			if(t1.equals(t2))return;
		}
		
		
		if(c==n) {
			boolean can=true;
			for(int i=1;i<a.size();i++) {
				String t1=(String)a.get(i-1);
				String t2=(String)a.get(i);
				if(t1.equals(t2))can=false;
			}
		if(can) {
			String x="";
			for(int i=0;i<a.size();i++) {
				x+=(String)a.get(i);
			}
			if(!h.contains(x)) {
				tot++;h.add(x);
			}
		}
			
		}
		else {
			for(int i=0;i<n;i++) {
				if(!visit[i]) {
				a.add(map[i]);
				visit[i]=true;
				find(a,c+1);
				visit[i]=false;
				a.remove((String)map[i]);
				}
			}
			
			
			
			
		}
		
		
	}

}
