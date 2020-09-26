package algo;
import java.util.*;
public class algo1748 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int tot=0;
		int num[]= new int[10];
		boolean t=false;
		int tn=n;
		int nam=1;
		int cnt=0;
		
		for(int i=0;i<8;i++) {
			num[i]=(int)Math.pow(10, i)*9*(i+1);
		}
		
	
		
		while(true) {
			
			if(tn<10) {
				break;
			}
			tn/=10;
			cnt++;
		}
		
		for(int i=0;i<cnt;i++) {
			tot+=num[i];
		}
		for(int i=0;i<cnt;i++) {
			nam*=10;
		}
		
		for(int i=nam;i<=n;i++) {
			tot+=cnt+1;
		}
		
		
		System.out.println(tot);
		
	}

}
