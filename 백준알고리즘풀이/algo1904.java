package algo;
import java.util.*;
public class algo1904 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		
		long map[]=new long[1000001];
		map[0]=0;map[1]=1;map[2]=2;
		
		for(int i=3;i<=1000000;i++) {
			map[i]=(map[i-1]+map[i-2])%15746;
			
		}
		System.out.println(map[n]);
	}

}
