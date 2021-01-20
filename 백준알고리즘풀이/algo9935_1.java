package algo;
import java.util.*;
import java.io.*;
public class algo9935_1 {
	static String res="";
	static String input;
	static int s=0;
	static String tar;
	static HashMap h = new HashMap<Integer,Integer>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		input=br.readLine();
		tar=br.readLine();
		int l=0;
		for(int i=0;i<input.length();i++) {
			char now=input.charAt(i);
			if(now==tar.charAt(0)) {
				s=i;
				l=find(s);
				if(l>0) {
					h.put(s, l-1);
					i=l;
				}
			}
		}
		for(int i=0;i<;i++) {
			if(h.containsKey(i)) {
				
			}
		}
	}
	static int find(int l) {
		String str=input.substring(s,s+tar.length());
		if(str.equals(tar)) {
			l=s+tar.length();
			if(s-(tar.length()-1)>=0) {
				if(input.charAt(s-(tar.length()-1))==tar.charAt(0)) {
					s-=(tar.length()-1);
					find(l);
				}
			}
		}
		
		return l;
	}

}
