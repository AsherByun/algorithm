package algo;
import java.util.*;
import java.io.*;
public class algo16637 {
	static boolean visit[];
	static ArrayList<ArrayList> arr=new ArrayList<ArrayList>();
	static int n,m;
	static int c;
	static int max=-999999;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		String[] in=br.readLine().split("");
		
		int nu[]=new int[1000];
		String si[]=new String[1000];
		
		
		int t1=1;
		int t2=0;
		for(int i=0;i<in.length;i++) {
			if(in[i].equals("+")) {
				si[t1]=in[i];t1+=2;
		
			}
			else if(in[i].equals("-")) {
				si[t1]=in[i];t1+=2;
		
			}
			else if(in[i].equals("*")) {
				si[t1]=in[i];t1+=2;
	
			}else {
				nu[t2]=Integer.parseInt(in[i]);
				t2+=2;
			
			}
		}
		
		c=n/4;
		if(n==1)max=nu[0];
		else if(n<=3) {
			if(si[1].equals("+")) {
				max=nu[0]+nu[2];
			}else if(si[1].equals("-")) {
				max=nu[0]-nu[2];
			}else {
				max=nu[0]*nu[2];
			}
				
		}
		else {
		visit=new boolean[100];
		for(int i=1;i<=c;i++) {
			find(i,new ArrayList(),nu,si);
		}
		}
		
		
		System.out.println(max);
		
	
		
	}
	
	static void find(int g,ArrayList a,int[] num,String[] sik) {
		
		if(g==0) {
			
			maket(a,num,sik);
			
		}else {
			
			for(int i=1;i<=n/2;i++) {
				if(!visit[i-1]&&!visit[i]&&!visit[i+1]) {
					visit[i]=true;
					a.add(i);
					find(g-1,a,num,sik);
					a.remove((Integer)i);
					visit[i]=false;
				}
				
			}
			
		}
		
		
	}
	static void maket(ArrayList a,int[] num,String[] sik) {
		
		int tnum[]=new int[100];
		for(int i=0;i<100;i++)tnum[i]=num[i];
		String tsik[]=new String[100];
		for(int i=0;i<100;i++)tsik[i]=sik[i];
		
		for(int i=0;i<a.size();i++) {
			int temp=(int)a.get(i);
			
			temp=temp*2-1;
			
			String s=tsik[temp];
			int t1=tnum[temp-1];
			int t2=tnum[temp+1];
			
			
			if(s.equals("+")) {
				int t=t1+t2;
				tsik[temp]="+";
				tnum[temp-1]=t;
				tnum[temp+1]=0;
				
			}else if(s.equals("-")) {
				int t=t1-t2;
				tsik[temp]="+";
				tnum[temp-1]=t;
				tnum[temp+1]=0;
				
			}else {
				int t=t1*t2;
				tsik[temp]="+";
				tnum[temp-1]=t;
				tnum[temp+1]=0;
				
				
			}
			
		}
			
		for(int i=1;i<=n/2;i++) {
			int temp=2*i-1;
			
			if(tsik[temp].equals("+")) {
				tnum[temp+1]=tnum[temp-1]+tnum[temp+1];
				
			}else if(tsik[temp].equals("-")) {
				tnum[temp+1]=tnum[temp-1]-tnum[temp+1];
				
			}else if(tsik[temp].equals("*")){
				tnum[temp+1]=tnum[temp-1]*tnum[temp+1];
				
			}
			
			
		}
		
		if(max<tnum[n-1]) {
			max=tnum[n-1];
		
		}
		
		
		
	}

}
