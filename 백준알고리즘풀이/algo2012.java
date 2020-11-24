package algo;
import java.util.*;
public class algo2012 {
	static int[] num;
	static int n;
	static int rank[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		 n=scan.nextInt();
		 num=new int[500001];
		 rank=new int[500001][2];
		for(int i=1;i<=n;i++) {
			int temp=scan.nextInt();
			rank[temp][0]++;
		}
		int up=0;
		
		for(int i=1;i<=500000;i++) {
			if(rank[i][0]>1) {
				rank[i][1]=up;
				up+=rank[i][0]-1;
//				System.out.println(up);
			}else if(rank[i][0]==0) {
				up-=1;
//				System.out.println(up);
			}else if(rank[i][0]==1){
				rank[i][1]=up;
//				System.out.println(up);
			}
			
			
		}
//		for(int i=1;i<=5;i++) {
//				System.out.println(rank[i][0]+"    "+rank[i][1]);
//			
//		}
//		
		
		
		int tot=0;
		for(int i=1;i<=500000;i++) {
			
			if(rank[i][0]!=0) {
				tot+=sum(rank[i][1],rank[i][0]);
				
				
			}
			
		}
		
		
		System.out.println(tot);
		
	}
	static int sum(int s,int r) {

		int tot=0;
		
		
		if(s>=0) {
			for(int i=s;i<s+r;i++) {
				tot+=i;
			}
			
			
		}else {
			for(int i=s;i<=s+r;i++) {
				tot+=Math.abs(i);
			}
			
		}
		
		
		
		
		
		return tot;
	}
	
	
}
