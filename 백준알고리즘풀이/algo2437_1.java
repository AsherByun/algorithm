package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo2437_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		String s=br.readLine();
		String a[]=s.split(" ");
		int map[]=new int[n];
		
		for(int i=0;i<n;i++) {
			map[i]=Integer.parseInt(a[i]);
			
		}
		Arrays.sort(map);
		if(map[0]!=1) {
			System.out.println(1);
		}else {
		int sum=map[0];
		for(int i=1;i<n;i++) {
			if(sum+1>=map[i]) {
				sum+=map[i];
			}else {
				break;
			}
		}
		
		System.out.println(sum+1);
	}
	}
}
