package algo;
import java.util.*;
import java.io.*;
public class algo1032 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		char map[]=new char[51];
		
		String in1=br.readLine();
		int len=in1.length();
		for(int i=0;i<len;i++) {
			map[i]=in1.charAt(i);
		}
		char res[]=new char[len];
		if(n==1) {
			System.out.printf("%s",in1);
		}else {
			for(int i=1;i<n;i++) {
				String in=br.readLine();
				for(int j=0;j<len;j++) {
					if(in.charAt(j)!=map[j]) {
						map[j]='?';
					}
				}
				
			}
			for(int i=0;i<len;i++)System.out.printf("%c",map[i]);
		}
		
		
	}

}
