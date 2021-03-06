package algo;
import java.util.*;
public class algo17471 {
	
	static int map[][];
	static int n;
	static int visit[];
	static int cost[];
	static int min=99999;
	static boolean ok=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan =new Scanner(System.in);
		
		n=scan.nextInt();
		map=new int[n+1][n+1];
		visit=new int[n+1];
		cost=new int[n+1];
		boolean cant=false;
		
		
		for(int i=1;i<=n;i++) {
			cost[i]=scan.nextInt();
		}
		ArrayList link=new ArrayList();
		for(int i=1;i<=6;i++) {
			int temp=scan.nextInt();
			if(temp==0) {cant=true;}
			LinkedList l=new LinkedList();
			for(int j=1;j<=temp;j++) {
				int t=scan.nextInt();
				l.add(t);
			}
			link.add(l);
		}
		int c=0;
		
		for(int i=1;i<=n;i++) {
			find(i);
		}
		
		
		
		
	}
	
	static void find(int num) {
		if()
		for(int )
		
		
	}
	static void testing() {
		
		
		
	}
	
	

}
