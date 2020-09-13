package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo1427 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split("");
		int map[]=new int[in.length];
		int k[]=new int[10];
		for(int i=0;i<in.length;i++) {
			map[i]=Integer.parseInt(in[i]);
			k[map[i]]++;
		}
		int res[]=new int[in.length];
		int t=0;
		for(int i=9;i>=0;i--) {
			
			for(int j=0;j<k[i];j++) {
				res[t]=i;t++;
			}
			
		}
		for(int i=0;i<in.length;i++)System.out.printf("%d",res[i]);
		
	
		
		
		
	}
}