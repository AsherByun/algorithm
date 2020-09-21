package algo;
import java.util.*;
public class algo1613_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int k=scan.nextInt();
		
		int map[][]=new int[n+1][n+1];
		
		int inf=Integer.MAX_VALUE-1;
		//for(int i=1;i<=n;i++)
		//Arrays.fill(map[i], inf);
		
		
		for(int i=1;i<=k;i++) {
			int s=scan.nextInt();
			int e=scan.nextInt();
			map[s][e]=1;
		}
		
		
		for(int t=1;t<=n;t++) {
			for(int i=1;i<=n;i++) {if(t==i)continue;
				for(int j=1;j<=n;j++) {if(t==j||i==j)continue;
					if(map[i][t]==0||map[t][j]==0) {
					}else {
						map[i][j]=1;
					}
				}
			}
		}
		
	/*	for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.printf("%d", map[i][j]);
			}System.out.println("");
		}*/
		
		
		int s=scan.nextInt();
		
		for(int i=0;i<s;i++) {
			int t1=scan.nextInt();
			int t2=scan.nextInt();
			
			if(map[t1][t2]==1) {
				System.out.println(-1);
			}else if(map[t2][t1]==1) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			
			
		}
		
		
		
	}

}
