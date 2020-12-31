package algo;
import java.util.*;
public class algo2666_1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n=scan.nextInt();
		int map[]=new int[n+1];
		int td;
		int op1=scan.nextInt();
		int op2=scan.nextInt();
		int testc=scan.nextInt();
		
		Queue q = new LinkedList();
		for(int i=1;i<=testc;i++) {
			td=scan.nextInt();
			q.add(td);
		}
		int count=0;
		int dis[][][]=new int[n+1][n+1][n+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=n;j++) {
				Arrays.fill(dis[i][j], -1);
			}
		}
		while(!q.isEmpty()) {
			int now=(int)q.poll();
			if(dis[op1][op2][now]!=-1) {
				count+=dis[op1][op2][now];
			}else {
				dis[op1][op2][now]=Math.min(Math.abs(op1-now), Math.abs(op2-now));
				count+=dis[op1][op2][now];
			}
			if(Math.abs(op1-now)>Math.abs(op2-now)) {
				op2=now;
			}else {
				op1=now;
			}
			
		}
		System.out.println(count);
		
	}

}
