package algo;
import java.util.*;
public class algo2455 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int map[][]=new int[4][2];
		
		int max=0;
		int now=0;
		
		for(int i=0;i<4;i++) {
			map[i][0]=scan.nextInt();
			map[i][1]=scan.nextInt();
			
			now-=map[i][0];
			now+=map[i][1];
			if(now>max)max=now;
		}
		System.out.println(max);
		
	}

}
