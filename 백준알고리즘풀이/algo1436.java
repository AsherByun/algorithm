package algo;
import java.util.*;
public class algo1436 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int n=scan.nextInt();
		
		int c=0;
		int s=666;
		boolean visit[]=new boolean[100000000];
		while(true) {
			
			int sn=0;
			String tt=Integer.toString(s);
			
			for(int i=0;i<tt.length()-2;i++) {
				if(tt.charAt(i)=='6'&&tt.charAt(i+1)=='6'&&tt.charAt(i+2)=='6') {
					sn=1;break;
				}
			}
			
			
			if(sn==1) {
				c++;
				}
			if(c==n)break;
			s++;
		}
		System.out.println(s);
		
	}

}
