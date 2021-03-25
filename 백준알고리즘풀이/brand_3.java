import java.util.*;
import java.io.*;
public class brand_3 {
	static int[][] map;
	static int n;
	static int m;
	static boolean visit[];
	static int[] dp;
	static boolean can;
	static int min=Integer.MIN_VALUE-1;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		n=Integer.parseInt(str[0]);
		m=Integer.parseInt(str[1]);
		map=new int[n+1][n+1];
		dp=new int[n+1];
		for(int i=0;i<m;i++) {
			str=br.readLine().split(" ");
			int s=Integer.parseInt(str[0]);
			int e=Integer.parseInt(str[1]);
			int cost=Integer.parseInt(str[2]);
			map[s][e]=cost;
		}
		///음수 무한 루프 체크
//		for(int i=1;i<n;i++) {
//			can=true;
//			visit=new boolean[n+1];
//			loopc(i,i,0);
//			if(!can) {
//				System.out.println("bug");
//				return;
//			}
//		}
		can=true;
		visit=new boolean[n+1];
		visit[1]=true;
		tloopc(1,1,0);
		if(!can) {
			System.out.println("bug");
			return;
		}
		
		// 찾기
		dp=new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		find(n,1,0,new boolean[n+1]);
		if(min==Integer.MIN_VALUE-1) {
			System.out.println("bug");
		}else {
			System.out.println(min);
		}
		
	}
	static void find(int last,int s,int cost,boolean v[]) {
		dp[s]=cost;
		for(int i=2;i<=n;i++) {
			if(map[s][i]!=0&&!v[i]) {
				
				if(i==last) {
					min=Math.min(cost+map[s][i], min);
					continue;
				}else {
					v[i]=true;
					if(cost+map[s][i]<=dp[i])
					find(n,i,cost+map[s][i],v);
				}
			}
		}
		
	}

static void tloopc(int start,int last,int cost) {
		
		for(int i=1;i<n;i++) {
			if(map[last][i]!=0) {
				if(!visit[i]) {
					visit[i]=true;
					tloopc(start,i,cost+map[last][i]);
				}else {
					if(cost+map[last][i]<0) {
						can=false;return;
					}
				}
			}
		}
		
	}
}
