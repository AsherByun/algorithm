package algo;
import java.util.*;
import java.io.*;

public class algo17143 {

	static int n,m,k;
	static shark sak[];
	static int map[][];
	static boolean visit[][];
	static ArrayList nearg[];
	static ArrayList fight[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		k=Integer.parseInt(in[2]);
		
		
		
		//nearg=new ArrayList[m+1];
		
		//for(int i=1;i<=m;i++)nearg[i]=new ArrayList();
		
		
		fight=new ArrayList[n+1][m+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				fight[i][j]=new ArrayList();
			}
		}
		
		
		sak=new shark[k+1];
		
		for(int i=1;i<=k;i++) {
			in=br.readLine().split(" ");
			int r=Integer.parseInt(in[0]);
			int c=Integer.parseInt(in[1]);
			int s=Integer.parseInt(in[2]);
			int d=Integer.parseInt(in[3]);
			int z=Integer.parseInt(in[4]);
			
			sak[i]=new shark(r,c,s,d,z);
			fight[r][c].add(sak[i]);
			
		}
		
		int tot=k;
		int gets=0;
		int man=0;
		
		while(true) {
			man++;
			System.out.println(gets);
			if(k<=0||man>6)break;
			
			for(int i=1;i<=n;i++) {
				if(fight[i][man].size()>0) {
					 shark ts=(shark)fight[i][man].get(0);
					 gets+=ts.z;
					 fight[i][man].remove((shark)ts);
				}
			}
			
			map=new int[n+1][m+1];
			for(int i=1;i<=m;i++) {
				
				if(nearg[i].size()>0) {
					move(nearg[i]);
				}
				
			}
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					if(fight[i][j].size()>1) {
						for(int t=0;t<fight[i][j].size();t++) {
							shark tts=(shark)fight[i][j].get(t);
							if(tts.z<map[i][j]) {
								fight[i][j].remove((shark)tts);
								nearg[j].remove((shark)tts);
								tot--;
							}
							
						}
					}
				}
			}
			
			
				
		}
		
		System.out.println(gets);
	}
	
	static void move(ArrayList a) {
		
		for(int i=0;i<a.size();i++) {
			shark ts=(shark)a.get(i);
			map[ts.r][ts.c]--;
			nearg[ts.c].remove((shark)ts);
			
			for(int j=1;j<=ts.s;j++) {
				if(ts.d==1) {
					if(ts.c-1<1) {
						ts.d=2;ts.r++;
					}else {
						ts.d--;
					}
				}else if(ts.d==2) {
					if(ts.c+1>n) {
						ts.d=1;ts.r--;
					}else {
						ts.d++;
					}
				}else if(ts.d==3) {
					if(ts.c+1>m) {
						ts.d=4;ts.r--;
					}else {
						ts.d++;
					}
				}else if(ts.d==4) {
					if(ts.c-1<1) {
						ts.d=3;ts.r++;
					}else {
						ts.d--;
					}
				}
			}
			map[ts.r][ts.c]++;
			nearg[ts.c].add(ts);
			if(map[ts.r][ts.c]<ts.z)map[ts.r][ts.c]=ts.z;
			fight[ts.r][ts.c].add(ts);
		}
		
		
		
	}

}
class shark{
	int r,c,s,d,z;
	
	shark(int r,int c,int s,int d,int z){
		this.r=r;this.c=c;this.s=s;this.d=d;this.z=z;
	}
	
	
}