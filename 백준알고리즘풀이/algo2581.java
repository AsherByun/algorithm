package algo;

import java.util.*;

public class algo2581 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int first=scan.nextInt();
		int last=scan.nextInt();
		int res=0;
		int n,min=100000,sum=0;
		int testnum=last-first+1;
		boolean sosu=true;
		
		
		for(int i =0;i<testnum;i++) {
			sosu=true;
			if(first==1) {sosu=false;}
			for(int j=2;j<first;j++) {
				
				if(first%j==0) {
					sosu=false;
					break;
					
				}
				
			}
			
			if(sosu) {
				res++;
				sum+=first;
				if(min>first) {min=first;}
			}
			first++;
			
			
		}
		if(res==0) {System.out.println(-1);}
		else {
		System.out.println(sum);
		System.out.println(min);
		}
		
		
	}

}
