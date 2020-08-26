package algo;
import java.util.*;
import java.io.*;

public class algo1016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		long min=scan.nextLong();
		long max=scan.nextLong();
		boolean visit[]=new boolean[(int)(max-min+1)];
		
		for(long i=2;i*i<=max;i++) {
			long a=i*i;
			long s=min+(a-(min%a))%a;
			
			for(long j=s;j<=max;j+=a) {
				visit[(int)(j-min)]=true;
			}
		}
		int res=0;
		for(int i=0;i<visit.length;i++) {
			if(!visit[i])res++;
		}
		System.out.println(res);
	}

}
