import java.util.*;
import java.awt.*;
import java.io.*;
public class brand_4 {
	static int map[][];
	static int n;
	static int k;
	static int max=0;
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		n=Integer.parseInt(str[0]);k=Integer.parseInt(str[1]);
		map=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			str=br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				map[i][j]=Integer.parseInt(str[j-1]);
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j]==0) {
					find(new Point(i,j));
				}
			}
		}
		System.out.println(max);
		
	}
	static void find(Point pt) {
		Queue<Point> q=new LinkedList();
		q.add(pt);
		int seq=-1;
		int count=0;
		boolean visit[][]=new boolean[n+1][n+1];
		visit[pt.x][pt.y]=true;
		while(!q.isEmpty()&&seq<k) {
			ArrayList<Point> arr=new ArrayList();
			seq++;
			while(!q.isEmpty()) {
				arr.add(q.poll());
				count++;
			}
			
			for(int i=0;i<arr.size();i++) {
				Point p=arr.get(i);
				for(int j=0;j<4;j++) {
					int nx=dx[j]+p.x; int ny=dy[j]+p.y;
					if(nx>0&&ny>0&&nx<=n&&ny<=n) {
						if(!visit[nx][ny]&&map[nx][ny]!=1) {
							q.add(new Point(nx,ny));
							visit[nx][ny]=true;
						}
					}
				}
				
			}
			
		}
		max=Math.max(max, count);
		
	}
}
