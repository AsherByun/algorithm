package algo;
import java.util.*;
import java.io.*;
public class algo1254_1 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		
		int len=s.length();
		boolean a=false;
		int res=0;
		int min=9999999;
		for(int i=0;i<len;i++) {
			if(can(s.substring(i))) {
				a=true;
				res=i+len;
				break;
			}
		}
		
		if(a) {
			System.out.println(res);
		}else {
			System.out.println(len*2-1);
		}
		
	}
	static boolean can(String s) {
		int len=s.length();
		for(int i=0;i<len;i++) {
			if(s.charAt(i)!=s.charAt(len-i-1)) {
				return false;
			}
		}
		return true;
	}
}
