package algo;
import java.util.*;
import java.io.*;
public class algo1937_1 {
	static int map[][];
	static int save[][];
	static int visit[][];
	static int n;static int r=0;
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		map=new int[n+1][n+1];
		save=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			String in[]=br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				map[i][j]=Integer.parseInt(in[j-1]);
			}
		}
		int tot=0;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				tot=Math.max(find(i,j), tot);
			}
		}
		
		System.out.println(tot);
	}
	static int find(int i,int j) {
		int day=1;
		
		if(save[i][j]!=0) {
			return save[i][j];
		}
		
		for(int k=0;k<4;k++) {
			int x=dx[k]+i;
			int y=dy[k]+j;
			if(x>0&&y>0&&x<=n&&y<=n) {
				if(map[i][j]<map[x][y]) {
					day=Math.max(find(x,y)+1,day);
					save[i][j]=day;
				}
			}
			
		}
		
		
		
		return day;
	}
	
}
