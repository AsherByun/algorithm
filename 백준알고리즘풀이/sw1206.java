package samsong;
import java.util.*;
public class sw1206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		
		for(int j=1;j<=10;j++) {
			
			int n=sc.nextInt();
			int map[]=new int[n];
			
			for(int i=0;i<n;i++) {
				map[i]=sc.nextInt();
			}
			int tot=0;
			for(int i=2;i<n-2;i++) {
				int max=Math.max(Math.max(map[i-2], map[i-1]), Math.max(map[i+1], map[i+2]));
				if(max<map[i]) {
					//System.out.println(i);
					tot+=map[i]-max;
				}
			}
			
			System.out.println("#"+j+" "+tot);
			
		}
		
		
		
	}

}
