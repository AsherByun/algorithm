package algo;
import java.util.*;
public class algo2302 {
	static int map[];
	static boolean vip[];
	static int n,m;
	static boolean visit[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		n=scan.nextInt();
		m=scan.nextInt();
		
		map=new int[41];
		visit=new boolean[n+1];
		vip=new boolean[n+1];
		map[1]=1;map[2]=2;map[0]=1;
		for(int i=3;i<=40;i++) {
			map[i]=map[i-1]+map[i-2];
		}
		
		
		for(int i=0;i<m;i++) {
			int temp=scan.nextInt();
			vip[temp]=true;
		}
		
		int c=0;int tot=1;
		for(int i=1;i<=n;i++) {
			if(!vip[i]) {
				c++;
			}
			else {
				tot*=map[c];System.out.println(map[c]);
				c=0;
			}
			if(i==n) {
				tot*=map[c];
			}
			
		}
		System.out.println(tot);
		
		
		
	}

}
