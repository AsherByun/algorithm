package algo;
import java.util.*;
public class algo2959 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int map[]=new int[5];
		
		for(int i=1;i<=4;i++) {
			map[i]=scan.nextInt();
		}
		
		Arrays.sort(map);
		int n=map[1];
		int m=map[3];
		
		System.out.println(n*m);
		
		
	}

}
