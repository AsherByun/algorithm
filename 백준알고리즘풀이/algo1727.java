package algo;
import java.util.*;
import java.io.*;
public class algo1727 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		int n=Integer.parseInt(in[0]);
		int m=Integer.parseInt(in[1]);
		
		int man[]=new int[n];
		int wom[]=new int[m];
		
		String temp[]=br.readLine().split(" ");
		for(int i=0;i<temp.length;i++)man[i]=Integer.parseInt(temp[i]);
		
		
		temp=br.readLine().split(" ");
		for(int i=0;i<temp.length;i++)wom[i]=Integer.parseInt(temp[i]);
		
		Arrays.sort(man);Arrays.sort(wom);
		
		
		
		for(int i=0;i<n;i++) {
			int tar=0;
			int manmin=man[0];
			int term=0;
			int min=99999999;
			
			for(int j=0;j<m;j++) {
			
		
			}
		
		}
		
	}

}
