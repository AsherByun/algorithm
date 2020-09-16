package algo;
import java.util.*;
public class algo1541 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String s=scan.next();
		
		String map[]=s.split("-");

		int sum=0;int f=0;
		for(int i=0;i<map.length;i++) {
			String temp[]=map[i].split("\\+");
			
			for(int j=0;j<temp.length;j++) {
				if(f==0) {
					sum+=Integer.parseInt(temp[j]);

				}
				else{sum-=Integer.parseInt(temp[j]);

			}
				}
			f++;
			
		}
		
		
		
		System.out.println(sum);
		
		
		
		
		
	}

}
