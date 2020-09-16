package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo1507_1 {
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
		
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				
				if(i!=j&&map[i][j]!=0) {
					
					visit[i]=true;
					find(i,j,0,i,map[i][j]);
					visit[i]=false;
				}
			}
		}
		int sum=0;
		for(int i=1;i<=n;i++) {
			for(int j=i+1;j<=n;j++) {
				sum+=map[i][j];
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.printf("%d ",map[i][j]);
			}System.out.println("");
		}
		
		System.out.println(sum);
		
		
		
		
		
	}
	
	static void find(int s,int tar,int tot,int now,int target) {//tar:목표 번호,tot:현재까지 거리합,now:현재 위치,target:한방거리
		
		if(tar==now) {
			map[s][tar]=0;
			map[tar][s]=0;
			System.out.println("1");
		}
		
		
		
		
		for(int i=1;i<=n;i++) {
			
			if(!visit[i]&&tot+cmap[now][i]<=target&&cmap[now][i]!=0) {
				if(s!=now&&tar!=i) {
				visit[i]=true;
				find(s,tar,tot+cmap[now][i],i,target);
				visit[i]=false;
				
				}
				
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