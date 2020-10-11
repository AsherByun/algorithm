package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo1932 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int s=0;
		
		int map[][]=new int[n+1][n+2];
		
		
		for(int i=1;i<=n;i++) {
				String in[]=br.readLine().split(" ");
				for(int j=1;j<=in.length;j++) {
					map[i][j]=Integer.parseInt(in[j-1]);
				}
			
		}
		
		for(int i=1;i<=n;i++) {
			
			for(int j=1;j<=i;j++) {
				map[i][j]+=Math.max(map[i-1][j], map[i-1][j-1]);
			}
		}
		
		Arrays.sort(map[n]);
		System.out.println(map[n][n+1]);
		
	}

}
