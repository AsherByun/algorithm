package algo;
import java.util.*;
import java.io.*;
public class algo1254 {
	static String s;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		s=br.readLine();
		int mid=s.length()/2;
		char map[]=s.toCharArray();
		int min=9999999;
		if(s.length()==1) {
			System.out.println(1);
		}else {
		for(int i=mid;i<s.length();i++) {
			
			int r=i;int l=i-1;
			boolean can=false;
			while(true) {
				if(map[r]!=map[l]) {
					break;
				}
				r++;l--;
				if(r==s.length()) {
					can=true;
					break;
				}
			}
			if(r==s.length()&&can) {
				if(l+1<min)min=l+1;
			}
			
			
			
			can=false;
			r=i+1;l=i-1;
			if(r==s.length()) {
				can=true;
			}else {
			while(true) {
				if(map[r]!=map[l]) {
					break;
				}
				r++;l--;
				if(r==s.length()) {
					can=true;
					break;
				}
			}
			}
			if(r==s.length()&&can) {
				if(l+1<min)min=l+1;
			}
			
		}
		System.out.println(s.length()+min);	
	
	}
	}
}
