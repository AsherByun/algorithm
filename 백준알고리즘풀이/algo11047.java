package algo;
import java.util.*;
public class algo11047 {
	static int k;
	static ArrayList a;
	static int min=Integer.MAX_VALUE-1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		k=scan.nextInt();
		a=new ArrayList();
		
		for(int i=0;i<n;i++) {
			int temp=scan.nextInt();
			if(temp<=k)a.add(temp);
		}
		int sum=0;
		int c=0;
		for(int i=a.size()-1;i>=0;i--) {
			int s=(int)a.get(i);
			if(k>=s) {
				c+=k/s;
				k=k%s;
			}
			
		}
		System.out.println(c);
		
	}
	
}
