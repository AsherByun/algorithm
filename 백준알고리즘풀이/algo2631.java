package algo;
import java.util.*;
public class algo2631 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan =  new Scanner(System.in);
		
		int n=scan.nextInt();
		
		int map[]=new int[n+1];
		int dis[][]=new int[n+1][n+1];
		
		
		for(int i=1;i<=n;i++) {
			map[i]=scan.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i]==j) {
					dis[i][j]=dis[i-1][j-1]+1;
				}else {
					dis[i][j]=Math.max(dis[i-1][j], dis[i][j-1]);
				}
			}
		}
		int tot=n-dis[n][n];
		System.out.println(tot);
	}

}
