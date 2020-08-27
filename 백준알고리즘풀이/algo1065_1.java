package algo;
import java.util.*;
public class algo1065_1 {
	static int n;
	static int tot=0;
	static boolean visit[]=new boolean[1001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		n=scan.nextInt();
		
		
		if(n<100)tot=n;
		
		else {
			tot=99;int temp=0;
			for(int i=100;i<=n;i++) {
				int n1=i/100;
				int n2=i/10 % 10;
				int n3=i%10%10;
				if(n1+n3==n2*2)temp++;
				
			}
			tot+=temp;
			
		}
		
		
		System.out.println(tot);
	}
	
}