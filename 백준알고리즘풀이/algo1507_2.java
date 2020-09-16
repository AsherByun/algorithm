package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo1507_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		int map[][]=new int[n+1][n+1];
		int tmap[][]=new int[n+1][n+1];
		boolean can=false;
		for(int i=1;i<=n;i++) {

			String in[]=br.readLine().split(" ");
			
			for(int j=1;j<=in.length;j++) {
				if(i==j) {
					//if(Integer.parseInt(in[j-1])!=0)can=true;
					map[i][j]=0;tmap[i][j]=0;
				}
				else {
					//if(Integer.parseInt(in[j-1])==0) {can=true;}
					map[i][j]=Integer.parseInt(in[j-1]);
					tmap[i][j]=Integer.parseInt(in[j-1]);
				}
			}
			
		}

		
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {if(k==i)continue;
				for(int j=1;j<=n;j++) {if(i==j)continue;if(k==j)continue;
					if(map[i][j]==map[i][k]+map[k][j]) {
						tmap[i][j]=0;
					}else if(map[i][j]>map[i][k]+map[k][j])can=true;
				
				}
			}
		}
		int sum=0;
		for(int i=1;i<=n;i++) {
			for(int j=i+1;j<=n;j++) {
				sum+=tmap[i][j];
			}
		}
		if(can)System.out.println(-1);
		else System.out.println(sum);
		
	}

}
