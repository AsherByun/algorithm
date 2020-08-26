package algo;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo1049 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner scan=new Scanner(System.in);
			
			int n=scan.nextInt();
			int m=scan.nextInt();
		
			int dan=99999;
			int pak=99999;
			
			for(int i=0;i<m;i++) {
			int	p=scan.nextInt();
			int	d=scan.nextInt();
				if(p<pak) {pak=p;}
				if(d<dan) {dan=d;}
			}
			int tot=0;
			
			
				
				int mok=n/6;
				int nam=n%6;
				if(nam==0) {
				tot=Math.min(dan*n,pak*mok);
				}else {
					int k=Math.min(pak*mok+dan*nam, pak*(mok+1));
					tot=Math.min(dan*n,k);
				}
				
			
			System.out.println(pak+"  "+dan);
			System.out.println(tot);
	}

}
