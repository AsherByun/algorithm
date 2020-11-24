package algo;
import java.util.*;
public class algo2003 {
	static int n,m;
	static int[] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		int res=0;
		int sum=0;
		int l=0;
		for(int i=0;i<n;i++) {
			sum+=map[i];
			if(sum==m) {
				res++;
				sum-=map[l];
				l++;
			}else if(sum>m) {
				while(sum>m) {
					sum-=map[l];
					l++;
					if(sum==m)res++;
				}
			}
		}
		System.out.println(res);
	}
	static void input() {
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();m=scan.nextInt();
		map=new int[n];
		for(int i=0;i<n;i++) {
			map[i]=scan.nextInt();
		}
	}
}
