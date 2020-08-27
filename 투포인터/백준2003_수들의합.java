package algo;
/*
포인트를 첫부분에 두고 각수를 더하면서 진행하다가 값이 m값과 같아지거나 큰 순간부터 포인터를 움직이면서 값을구함
*/
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
