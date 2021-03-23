package samsong;
import java.util.*;
public class sw1808 {
	static boolean map[];
	static boolean tmap[];
	static int input;
	static int min=Integer.MAX_VALUE-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int testc=scan.nextInt();
		
		for(int tc=1;tc<=testc;tc++) {
			min=Integer.MAX_VALUE-1;
			map=new boolean[10];
			for(int i=0;i<10;i++) {
				int temp=scan.nextInt();
				if(temp==1)map[i]=true;
			}
			input=scan.nextInt();
			for(int i=input;i>0;i--) {
					if(input%i==0) {
						check(i);
					}
			}
			boolean can=true;
			String str=Integer.toString(input);
			for(int i=0;i<str.length();i++) {
				if(!map[str.charAt(i)-'0'])can=false;
			}
			if(can&&min>str.length())min=str.length();
			System.out.printf("#"+tc+" ");
			if(min!=Integer.MAX_VALUE-1&&!can)System.out.println(min+2);
			else if(can&&min!=Integer.MAX_VALUE-1)System.out.println(min+1);
			else System.out.println(-1);
		}
		
	}
	static int check(int t) {
		String sa=Integer.toString(t);
		String sb=Integer.toString(input/t);
		
		for(int i=0;i<sa.length();i++) {
			if(!map[sa.charAt(i)-'0'])return -1;
		}
		for(int i=0;i<sb.length();i++) {
			if(!map[sb.charAt(i)-'0'])return -1;
		}
		if(min>sa.length()+sb.length()) {
			min=sa.length()+sb.length();
		}
		return ;
	}
}
