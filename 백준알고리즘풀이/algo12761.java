package algo;
import java.util.*;
public class algo12761 {
	static int res;
	static int go[]=new int[8];
	static int map[]=new int[100001];
	static int a,b,n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		a=scan.nextInt();
		b=scan.nextInt();
		n=scan.nextInt();
		m=scan.nextInt();
		
		for(int i=0;i<=100000;i++) {
			map[i]=Integer.MAX_VALUE-1;
		}
		map[n]=0;
		Queue q=new LinkedList();
		
		q.add(n);
		int c=0;
		while(!q.isEmpty()) {
			int temp=(int)q.poll();
			
			if(temp==m)break;
			
			go[0]=temp+1;go[1]=temp-1;go[2]=temp+a;go[3]=temp+b;go[4]=temp-a;go[5]=temp-b;
			go[6]=temp*a;go[7]=temp*b;
			
			for(int i=0;i<8;i++) {
				int t=go[i];
				if(t<=100000&&t>=0&&map[t]>map[temp]+1) {
					map[t]=map[temp]+1;
					q.add(t);
				}
			}
		}
		
		
		System.out.println(map[m]);
	}
	
}
