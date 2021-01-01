package algo;
import java.util.*;
public class algo2869 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int a,b,v;
		int h=0;
		int up=0;
		int day=0;
		int i=0;
		a=scan.nextInt();
		b=scan.nextInt();
		v=scan.nextInt();
		
		up=a-b;
		v=v-a;
		if((v%up)>0) {
			day=v/up+2;
		}
		if((v%up)==0) {
			day=v/up+1;
		}
		
		
		System.out.println(day);
		
		
	}

}
