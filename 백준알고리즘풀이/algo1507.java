package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo1507 {
	static int map[][];
	static int cmap[][];
	static int n;
	static boolean visit[];
	static List link[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		visit=new boolean[n+1];
		cmap=new int[n+1][n+1];
		map=new int[n+1][n+1];
		boolean can=true;
		
		for(int i=1;i<=n;i++) {
			String in[]=br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				map[i][j]=Integer.parseInt(in[j-1]);
				if(i!=j&&map[i][j]==0) {can=false;}
			}
		}
		link=new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			link[i]=new ArrayList();
		}
		
		
	
		for(int i=1;i<=n;i++) {
			LinkedList l=new LinkedList();
			l.add(i);
			visit[i]=true;
			find(l,0);
			visit[i]=false;
		}
	
	
	
	
	}
	
	static void find(LinkedList l,int c) {
		
		
		
		
		
		for(int i=1;i<=n;i++) {
			
			if(!visit[i]) {
				
			}
			
		}
		
		
		
	}
	

}


class node {
	int w;
	int v;
	node(int w,int v){
		this.w=w;
		this.v=v;
	}
	
	
	
}