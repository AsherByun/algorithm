package algo;
import java.util.*;
public class algo14889_1 {

	static int n;
	static int min=99999;
	static int[][] map;
	static boolean[] visit;
	static int count;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		n=scan.nextInt();
		map=new int[n+1][n+1];
		visit=new boolean[n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j]=scan.nextInt();
			}
		}
		count=n/2;
		int c=0;
		
			find(1,c);
		
		
		System.out.println(min);
		
		
		

	}
	
	static void find(int x,int c) {
		
		c++;
		visit[x]=true;
		
		if(c==count) {
			counting();
		}else {
			for(int i=x;i<=n;i++) {
				if(!visit[i]) {
					find(i,c);
					
				}
			}	
		}
		visit[x]=false;
	}
	
	
	static void counting() {
		
		int sum1=0;
		int sum2=0;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(visit[i]&&visit[j]&&(i!=j)) {
					sum1+=map[i][j];
				}
				else if(!visit[i]&&!visit[j]&&(i!=j)) {
					sum2+=map[i][j];
				}
			}
		}
		
		int result = Math.abs(sum1-sum2);
		if(result<min) {min=result;}
		
		
	}
	
	
	
	
	

}
