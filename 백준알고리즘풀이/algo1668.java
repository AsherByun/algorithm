package algo;
import java.util.*;
public class algo1668 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		
		int map[]=new int[n];
		
		int f=0;int l=0;
		int max=0;
		for(int i=0;i<n;i++) {
			map[i]=scan.nextInt();
			if(map[i]>max)f++;
			if(max<map[i]) {max=map[i];}
		}
		max=0;
		for(int i=n-1;i>=0;i--) {
			if(map[i]>max)l++;
			if(max<map[i]) {max=map[i];}
		}
		
		System.out.println(f);
		System.out.println(l);
	}

}
