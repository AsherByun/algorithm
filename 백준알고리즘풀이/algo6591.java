package algo;
import java.util.*;
public class algo6591 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		while(true) {
		int n=scan.nextInt();
		int k=scan.nextInt();
		if(n==0&&k==0)break;
		
		int d=1;
		long ans=1;
		
		if(n-k<k) {
			k=n-k;
		}
		
		while(k-->0) {
			ans*=n--;
			ans/=d++;
		}
		
		System.out.println(ans);
		}
	}

}
