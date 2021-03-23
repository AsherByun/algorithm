package samsong;
import java.util.*;
import java.io.*;
public class sw8295 {
	static int[] map;
	static ArrayList ha;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testc=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=testc;tc++) {
			String ins[]=br.readLine().split(" ");
			int n=Integer.parseInt(ins[0]);
			int x=Integer.parseInt(ins[1]);
			int m=Integer.parseInt(ins[2]);
			ha=new ArrayList();
			
			boolean check[]=new boolean[n+1];
			map=new int[n+1];
			
			for(int i=0;i<m;i++) {
				ins=br.readLine().split(" ");
				int l=Integer.parseInt(ins[0]);
				int r=Integer.parseInt(ins[1]);
				int s=Integer.parseInt(ins[2]);
				for(int j=l;j<=r;j++)check[j]=true;
				ha.add(new hamset(l,r,s));
			}
			for(int i=1;i<=n;i++) {
				if(!check[i])map[i]=x;
			}
			
			
			
		}
		
		
	}
	static void find(int ns) {
		hamset h=(hamset)ha.get(ns);
		
		
		
	}
}
class hamset{
	int l,r,s;
	hamset(int l,int r,int s){
		this.l=l;
		this.r=r;
		this.s=s;
	}
}
