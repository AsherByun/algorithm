package algo;
import java.util.*;
public class algo2012_1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int map[]=new int[n+1];
		map[0]=0;
		
		for(int i=1;i<=n;i++) {
			map[i]=scan.nextInt();
		}
		long tot=0;
		Arrays.sort(map);
		for(int i=1;i<=n;i++) {
			tot+=Math.abs(map[i]-i);
		}
		System.out.println(tot);
	}
	
}
