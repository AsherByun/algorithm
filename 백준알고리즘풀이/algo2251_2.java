package algo;


import java.util.*;
import java.io.*;

public class algo2251_2 {
	static int a,b,c;
	static boolean map[]=new boolean[201];
	static boolean v[][]=new boolean[201][201];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		a=Integer.parseInt(in[0]);
		b=Integer.parseInt(in[1]);
		c=Integer.parseInt(in[2]);
		
		find(0,0,c);
		
		for(int i=0;i<=200;i++)
			if(map[i])System.out.printf("%d ",i);
		


}
	
	static void find(int ta,int tb,int tc) {
		
		if(v[ta][tb]) {
			return;
		}
		
		if(ta==0) {
			map[tc]=true;
		}
		
		v[ta][tb]=true;
		
		if(ta+tb>b) {
			find(ta+tb-b,b,tc);
		}else {
			find(0,ta+tb,tc);
		}
		
		if(ta+tb>a) {
			find(a,ta+tb-a,tc);
		}else {
			find(ta+tb,0,tc);
		}
		
		if(ta+tc>a) {
			find(a,tb,ta+tc-a);
		}else {
			find(ta+tc,tb,0);
		}
		
		if(tc+tb>b) {
			find(ta,b,tc+tb-b);
		}else {
			find(ta,tc+tb,0);
		}
		
		find(ta,0,tb+tc);
		find(0,tb,ta+tc);
		
		
	}
	
	
	
	
	
	
	
	
}