package algo;
import java.util.*;
public class algo2884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int h=scan.nextInt();
		int m=scan.nextInt();
		
		
		if(m-45<0) {
			if(h==0) {
				h=23;m+=15;
			}else {
				h--;m+=15;
			}
		}else {
			m-=45;
		}
		System.out.println(h+" "+m);
		
	}

}
