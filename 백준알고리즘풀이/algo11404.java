package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo11404 {

	static int n,m;
	static int map[][];
	static boolean visit[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		
		map=new int[n+1][n+1];
		
		for(int i=1;i<=m;i++) {
			
			String[] in=br.readLine().split(" ");
			int s=Integer.parseInt(in[0]);
			int e=Integer.parseInt(in[1]);
			int w=Integer.parseInt(in[2]);
			
			if(map[s][e]==0) {
				map[s][e]=w;
			}else if(map[s][e]>w) {
				map[s][e]=w;
			}
			
			
			
		}
		
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i!=j&&map[i][j]!=0) {
					find(map[i][j],i,j);
				}
				
				
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.printf("%d ", map[i][j]);
			}System.out.println("");
		}System.out.println("");
		
		
	}
	
	
	static void find(int cost,int s,int now) {
		
		
		for(int i=1;i<=n;i++) {
			int tempc=cost;
			if(now!=i&&map[now][i]!=0&&i!=s) {
				if(cost+map[now][i]<map[s][i]||map[s][i]==0) {
					//System.out.println("현재:"+now+"  갈곳:"+i+"  시작:"+s+"  cost"+cost);
					map[s][i]=tempc+map[now][i];
					tempc+=map[now][i];
					find(tempc,s,i);
				}
			}
			
		}
		
		
		
	}
	
	
	
	
	
	

}
