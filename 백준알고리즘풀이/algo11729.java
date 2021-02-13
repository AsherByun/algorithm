package algo;
import java.util.*;
public class algo11729 {
	static int top[]=new int[4];
	static boolean visit[][]=new boolean[4][300];
	static int n,m;
	static int map[]=new int[4];
	static int tot=0;
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();		
		
		find(n,1,2,3);
		System.out.println(tot);
		System.out.println(sb);
		
		
		
	}
	static void find(int num,int from,int by,int to) {
		
		tot++;
		if(num==1) {
			sb.append(from+" "+to+"\n");
			return;
		}
		else {
			find(num-1,from,to,by);
			sb.append(from+" "+to+"\n");
			find(num-1,by,from,to);
			
		}
		
		
	}

}
class bn{
	int s;
	int n;
	bn(int s,int n){
		this.s=s;
		this.n=n;
	}
	
	
}