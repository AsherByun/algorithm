package samsong;
import java.util.*;
import java.awt.*;
import java.io.*;
public class sw1808_1 {
	static boolean map[];
	static int res;
	static int tar;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testc=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=testc;tc++) {
			String ins[]=br.readLine().split(" ");
			map=new boolean[10];
			for(int i=0;i<10;i++) {
				int temp=Integer.parseInt(ins[i]);
				if(temp==1)map[i]=true;
			}
			
			int tar=Integer.parseInt(br.readLine());
			int res=Integer.MAX_VALUE-1;
			int temp=isok(tar);
			if(temp!=0) {
				System.out.println("#"+tc+" "+(temp+1));
			}else {
			cal(tar);
			if(res == Integer.MAX_VALUE-1) res=-1;
			else res++;
			
			System.out.println("#"+tc+" "+res);
			}
			
		}
		
	}
	
	
	static int cal(int t) {
		int max=Integer.MAX_VALUE-1;
		int temp=isok(t);
		
		if(temp!=0)return temp;
		
		for(int i=2,end=(int) Math.sqrt(t)+1;i<end;i++) {
			if(t%i==0) {
				temp=isok(i);
				
				if(temp!=0) {
					temp++;
					int temp2 = cal(t/i);
					if(temp2!=Integer.MAX_VALUE-1) {
						int r=temp+temp2;
						if(r<max)max=r;
						if(max<res&&t==tar)res=max;
					}
				}
			}
		}
		return max;
	}

	static int isok(int t) {
		String ts=Integer.toString(t);
		for(int i=0;i<ts.length();i++) {
			if(!map[ts.charAt(i)-'0'])return 0;
		}
		return ts.length();
	}
}
