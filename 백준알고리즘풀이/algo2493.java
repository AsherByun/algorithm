package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo2493 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		
		int res[]=new int[n+1];
		int map[]=new int[n+1];
		
		int max=0;
		String in=br.readLine();
		String a[]=in.split(" ");
		
		
		
		for(int i=1;i<=n;i++) {
			map[i]=Integer.parseInt(a[i-1]);

			if(max<map[i]) {
				max=map[i];
				res[i]=0;
			}else {
				for(int j=i-1;j>0;j--) {
					if(map[j]>=map[i]) {
						res[i]=j;break;
					}
				}
			}
			
			
		}
		for(int i=1;i<=n;i++) {
			System.out.print(res[i]+" ");
		}
		
	}

}
