package algo;
import java.util.*;
public class algo2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int tar=0;
		boolean can=false;
		for(int i=n/5;i>=0;i--) {
			int temp=5*i;
			if(temp==n) {
				tar=i;
				can=true;
				break;
			}
			if((n-temp)%3==0) {
				can=true;
				tar=i+((n-temp)/3);
				break;
			}
		}
		if(can)
		System.out.println(tar);
		else
		System.out.println(-1);
		
	}

}
