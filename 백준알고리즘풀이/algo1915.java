package algo;
import java.util.*;
public class algo1915 {
	static int n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		
		
		int map[][] = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				map[i][j]=scan.nextInt();
			}
		}
		
		
		
	}

}
