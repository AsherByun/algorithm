package algo;
import java.util.*;
public class algo1057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int t1=scan.nextInt();
		int t2=scan.nextInt();
		boolean fin =false;
	
		int num=1;
		
		while(!fin) {
			if(n==1) {
				fin=true;
				break;
			}else {
				if(t1-t2==1) {
					if(t1%2==0) {fin=false;break;}
				}else if(t2-t1==1) {
					if(t2%2==0) {
						fin=false;break;}
				}
				if(n%2!=0) {
					n=n/2 + 1;
				}else {n=n/2;}
				if(t1%2==0) {
					t1=t1/2;
			}else {t1=t1/2 +1;}
				if(t2%2==0) {
					t2=t2/2;
			}else {t2=t2/2 +1;}
				
				
				num++;
				
			}
			
			
			
			
			
		}
		if(fin) {System.out.println(-1);}else {
		System.out.println(num);
		}
	}

}
