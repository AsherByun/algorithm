package algo;
import java.util.*;
import java.io.*;

public class algo10828 {
	static int tar=0;
	static int stack[]=new int[100001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String in[]=br.readLine().split(" ");
			
			if(in[0].equals("push")) {
				int var=Integer.parseInt(in[1]);
				tar++;
				stack[tar]=var;
			}else if(in[0].equals("pop")&&tar!=0) {
				System.out.println(stack[tar]);
				tar--;
			}else if(in[0].equals("pop")&&tar==0) {
				System.out.println(-1);
				
			}else if(in[0].equals("size")) {
				System.out.println(tar);
			}else if(in[0].equals("empty")) {
				if(tar==0) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}else if(in[0].equals("top")) {
				if(tar==0) {
					System.out.println(-1);
				}else {
					System.out.println(stack[tar]);
				}
			}
		}
		
		
	}

}
