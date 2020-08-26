package algo;
import java.util.*;
public class algo1019 {
	static int map[]=new int[10];
	static int p=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int s=1;
		int e=n;
		
		
		while(s<=e) {
			
			while(s%10!=0&&s<=e) {
				cal(s);
				s++;
			}
			if(s>e)break;
			while(e%10!=9&&s<=e) {
				cal(e);
				e--;
			}
			
			s/=10;
			e/=10;
			
			for(int i=0;i<10;i++) {
				map[i]+=(e-s+1)*p;
			}
			p*=10;
			
		}
		for(int i=0;i<10;i++)System.out.printf("%d ", map[i]);
	
	
	}
	static void cal(int num) {
		while(num>0) {
			map[num%10]+=p;
			num/=10;
		}
	}
}
