package algo;
import java.util.*;
public class algo2217 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int n=scan.nextInt();
		int max=0;int min=99999;
		int count=0;int mc=0;int tc=0;
		int pmc=0;int nmc=0;
		int map[]=new int[n+1];
		for(int i=1;i<=n;i++) {
			int temp=scan.nextInt();
			map[i]=temp;
			int tmax=0;
			if(map[i-1]<temp) {
				mc=0;
				for(int j=1;j<=i;j++) {
					if(map[j]>=temp) {mc++;}//System.out.println(mc);
				}
				nmc=mc*temp;System.out.println(nmc);
			}else if(map[i-1]>=temp) {
				tc=0;
				if(min>temp) {min=temp;}
				for(int j=1;j<=i;j++) {
					if(map[j]<=temp) {tc++;}
				}
				pmc=Math.max(min*tc, tc*temp);
			}
			max=Math.max(Math.max(nmc, pmc), Math.max(max, temp));
			System.out.println(max);
		}
		
		//System.out.println(max);
		
	}

}
