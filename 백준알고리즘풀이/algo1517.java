package algo;
import java.util.*;
public class algo1517 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		
		int map[]=new int[n];
		
		for(int i=0;i<n;i++) {
			map[i]=scan.nextInt();
		}
		int tot=0;
		while(true) {
			
			boolean can=false;
			
			for(int i=0;i<n-1;i++) {
				if(map[i]>map[i+1]) {
					int temp=map[i];
					map[i]=map[i+1];
					map[i+1]=temp;
					tot++;can=true;
				}
				
			}
			
			if(!can)break;
			
			
		}
		
		
		System.out.println(tot);
	}

}
