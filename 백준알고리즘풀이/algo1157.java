package algo;
import java.util.*;
import java.io.*;
public class algo1157 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String in=br.readLine();
		
		int map[]=new int[150];
		int max=0;
		for(int i=0;i<in.length();i++) {
			char temp=in.charAt(i);
			int c=temp-0;
			if(c>96) {
				c=c-32;
			}
			map[c]++;
			if(max<map[c])max=map[c];
		}
		int t=0;
		int tar=0;
		for(int i=0;i<150;i++) {
			if(max==map[i]) {
				t++;tar=i;
			}
		}
		if(t>1) {
			System.out.println("?");
		}else {
			System.out.println((char)tar);
		}
		
	}

}
