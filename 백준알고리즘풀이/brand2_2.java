import java.io.*;
import java.util.*;
public class brand2_2 {
    static int map[][];
    static int n;
    static int hp;
    static int dp[][];
    static int max=Integer.MAX_VALUE;
    static int dx[]= {0,-1,0,1};
    static int dy[]= {-1,0,1,0};
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str[]=br.readLine().split(" ");
    	n=Integer.parseInt(str[0]);
    	hp=Integer.parseInt(str[1]);
    	map=new int[n+1][n+1];
    	dp=new int[n+1][n+1];
    	for(int i=1;i<=n;i++)Arrays.fill(dp[i], Integer.MAX_VALUE);
    	boolean visit[][]=new boolean[n+1][n+1];
    	for(int i=1;i<=n;i++) {
    		str=br.readLine().split(" ");
    		for(int j=1;j<=n;j++) {
    			map[i][j]=Integer.parseInt(str[j-1]);
    		}
    	}
    	
    	Queue<int[]> q = new LinkedList();
    	int g[]={1,1,map[1][1]};
    	dp[1][1]=map[1][1];
    	q.add(g);
    	while(!q.isEmpty()) {
//    		Queue tq=new LinkedList();
//    		while(!q.isEmpty()) {
//    			tq.add(q.poll());
//    		}
    		
//    		while(!tq.isEmpty()) {
    			int[] tarr=(int[])q.poll();
    			int x=tarr[0]; int y=tarr[1]; int cost=tarr[2];
    			if(cost<max) {
    			for(int i=0;i<4;i++) {
    				int nx=x+dx[i]; int ny=y+dy[i];
    				if(nx>0&&ny>0&&nx<=n&&ny<=n) {
    					if(dp[nx][ny]>=cost+map[nx][ny]&&hp-(cost+map[nx][ny])>=0) {
    						dp[nx][ny]=cost+map[nx][ny];
    						if(nx==n&&ny==n&&dp[n][n]<max) {
    							max=dp[n][n];
    						}
    						q.add(new int[] {nx,ny,cost+map[nx][ny]});
    					}
    				}
    			}
    			}	
//    		}
    		
    		
    	}
    	int res=hp-dp[n][n];
    	if(res<=0)System.out.println("-1");
    	else System.out.println(res);
    }
}
