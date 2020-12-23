package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo2437 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		String s=br.readLine();
		String a[]=s.split(" ");
		int map[]=new int[n];
		ArrayList arr = new ArrayList();
		for(int i=0;i<n;i++) {
			arr.add(Integer.parseInt(a[i]));
		}
		
		
		int num=1;
		while(true) {
			if(arr.contains((Integer)num)) {
				
				ArrayList temp=new ArrayList();
				for(int i=0;i<arr.size();i++) {
					temp.add(arr.get(i));temp.add((int)arr.get(i)+num);
				}
				
				arr=temp;
			}else {
				break;
			}
			
			
			num++;
		}
		

		
		
		
		
		
		
		System.out.println(num);
		
	}

}
