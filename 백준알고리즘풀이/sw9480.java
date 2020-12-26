package samsong;
import java.util.*;
import java.io.*;
public class sw9480 {
	static int n;
	static String map[];
	static boolean visit[];
	static boolean dic[];
	static int tot=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int tc=Integer.parseInt(br.readLine());
		
		
		for(int t=1;t<=tc;t++) {
			
			dic=new boolean[26];
			
			n=Integer.parseInt(br.readLine());
			map=new String[n];
			
			for(int i=0;i<n;i++) {
				map[i]=br.readLine();
			}
			visit=new boolean[10];
			tot=0;
			for(int i=0;i<n;i++) {
				visit[i]=true;
				ArrayList a=new ArrayList();
				a.add(i);
				find(i,a,map[i].length());
				visit[i]=false;
			}
			
			System.out.println("#"+t+" "+tot);
			
		}
		
		
		
	}
	static void find(int s,ArrayList c,int len) {
		
		if(len>=26) {
		boolean can=check(c);
		if(can) {
			tot++;
		}
		}
		
		for(int i=s+1;i<n;i++) {
			if(!visit[i]) {
			visit[i]=true;
			c.add(i);
			find(i,c,len+map[i].length());
			c.remove((Integer)i);
			visit[i]=false;
			}
		}
		
		
		
	}
	
	static boolean check(ArrayList c) {
		
		boolean can=true;
		boolean v[]=new boolean[26];
		for(int i=0;i<c.size();i++) {
			int temp= (int)c.get(i);
			for(int j=0;j<map[temp].length();j++) {
				int tm=map[temp].charAt(j)-'a';
				v[tm]=true;
			}
		}
		for(int i=0;i<26;i++) {
			if(!v[i]) {
				can=false;break;
			}
		}
		
		
		return can;
	}
	
}
