package algo;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo1339 {
	static int n;
	static ArrayList a=new ArrayList();
	static String[] map;
	static int max=0;
	static int m;
	static ArrayList res=new ArrayList();
	static boolean visit[]=new boolean[10];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		boolean alpa[]=new boolean[10000];
		map=new String[n];
		for(int i=0;i<n;i++) {
			map[i]=br.readLine();
			char in[]=map[i].toCharArray();
			for(int j=0;j<in.length;j++) {
				if(!alpa[in[j]-'0']) {
					a.add(in[j]);alpa[in[j]-'0']=true;
				}
			}
		}
		Collections.sort(a);
		m=a.size();
		
		dfs(0);
//		for(int i=0;i<a.size();i++)System.out.println(a.get(i));

		
		
		System.out.println(max);
		
		
	}
	static void dfs(int c) {
		
		if(c==m) {
			findmax();
			return;
		}
		
		for(int i=9;i>9-m;i--) {
			if(!visit[i]) {
				visit[i]=true;
				res.add(i);
				dfs(c+1);
				visit[i]=false;
				res.remove((Integer)i);
			}
		}
		
	}
	static void findmax() {
		String[] tmap=map.clone();
		String[] toin=new String[n];
		for(int i=0;i<n;i++)toin[i]="";
		for(int i=0;i<tmap.length;i++) {
			char temp[]=tmap[i].toCharArray();
			for(int j=0;j<temp.length;j++) {
				int t=a.indexOf(temp[j]);
				int tar=(int)res.get(t);
				toin[i]+=tar;
			}
		}
		int imap[]=new int[n];int tres=0;
		for(int i=0;i<tmap.length;i++) {
//			imap[i]=Integer.parseInt(tmap[i]);
			imap[i]=Integer.parseInt(toin[i]);
			tres+=imap[i];
		}
		
		if(tres>max) {
			max=tres;
		}
		
	}

}
