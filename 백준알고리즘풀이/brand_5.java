import java.util.*;
import java.awt.Point;
import java.io.*;
public class brand_5 {
	static ArrayList[] map;
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
		map=new ArrayList[n+1];
		for(int i=1;i<=n;i++)map[i]=new ArrayList();
		dp=new int[n+1];
		for(int i=0;i<m;i++) {
			str=br.readLine().split(" ");
			int s=Integer.parseInt(str[0]);
			int e=Integer.parseInt(str[1]);
			int cost=Integer.parseInt(str[2]);
			map[s].add(new Point(e,cost));
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
		for(int i=0;i<map[s].size();i++) {
			Point p=(Point)map[s].get(i);
			int c=p.y;
			int e=p.x;
			if(!v[e]) {
				if(e==last) {
					min=Math.min(cost+c, min);
					continue;
				}else {
					v[e]=true;
					if(cost+c<=dp[e])
					find(n,e,cost+c,v);
				}
			}
		}
		
	}
//	static void loopc(int start,int last,int cost) {
//		
//		for(int i=1;i<n;i++) {
//			if(!visit[i]&&map[last][i]!=0) {
//				
//				visit[i]=true;
//				if(i==start) {
//					if(cost+map[last][i]<0) {
//						can=false;continue;
//					}
//				}else {
//					loopc(start,i,cost+map[last][i]);
//				}
//			}
//		}
//		
//	}
//	
static void tloopc(int start,int last,int cost) {
		
		for(int i=0;i<map[last].size();i++) {
			Point p=(Point)map[last].get(i);
			if(!visit[p.x]) {
				visit[p.x]=true;
				tloopc(start,p.x,cost+p.y);
			}else {
				if(cost+p.y<0) {
					can=false;return;
				}
			}
		}
		
	}
}
