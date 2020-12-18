package algo;
import java.util.*;
public class algo2156 {
	static int n;
	static boolean visit[];
	static int map[];
	static int max=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		visit=new boolean[n+1];
		map=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			map[i]=scan.nextInt();
		}
		
		int sum=0;
		find(sum,1,0);
		System.out.println(max);
	}

	
	static void find(int sum,int c,int g) {
		g++;
		System.out.println("asd");
		if(c==n) {
			
			if(sum>max) {
				max=sum;
				}
		}
		else if(g==3) {
			find(sum,c+1,0);
		}else {
		visit[c]=true;
		sum+=map[c];
		find(sum,c+1,g);
		visit[c]=false;
		sum-=map[c];
		find(sum,c+1,0);
		
		}
	}
	
	
	
	
	
}
