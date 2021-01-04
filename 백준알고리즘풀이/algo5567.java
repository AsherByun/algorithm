package algo;
import java.util.*;
public class algo5567 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int m=scan.nextInt();
		
		int map[][]=new int[n+1][n+1];
		
		for(int i=1;i<=m;i++) {
			int a=scan.nextInt();
			int b=scan.nextInt();
			
			map[a][b]=1;
			map[b][a]=1;
			
			
		}
		int c=0;
		boolean visit[]=new boolean[n+1];
		visit[1]=true;
		Stack s=new Stack();
		for(int i=2;i<=n;i++) {
			if(map[1][i]==1) {
				s.push(i);
				c++;
				visit[i]=true;
			}
			
		}
		
		while(!s.isEmpty()) {
			int t=(int)s.pop();
			
			for(int i=1;i<=n;i++) {
				if(!visit[i]&&map[t][i]==1) {
					c++;visit[i]=true;
				}
			}
			
			
			
		}
		
		System.out.println(c);
		
	}

}
