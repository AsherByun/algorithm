package algo;
import java.util.*;
import java.io.*;
public class algo1439 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int one=0;
		int z=0;
		
		String in=br.readLine();
		int nx=2;
		for(int i=0;i<in.length();i++) {
			char tt=in.charAt(i);
			int t=tt-'0';
			if(t!=nx) {
				if(t==0) {
					z++;nx=0;
				}else {
					one++;nx=1;
				}
			}
			
		}
		
		System.out.println(Math.min(z, one));
	}

}
