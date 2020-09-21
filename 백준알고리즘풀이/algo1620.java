package algo;
import java.util.*;
import java.io.*;
public class algo1620 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String in[]=br.readLine().split(" ");
		int n=Integer.parseInt(in[0]);
		int m=Integer.parseInt(in[1]);
		HashMap h=new HashMap();
		ArrayList dogam=new ArrayList();
		dogam.add("");
		for(int i=1;i<=n;i++) {
			String temp=br.readLine();
			h.put(temp, i);
			dogam.add(temp);
		}
		
		
		
		for(int i=0;i<m;i++) {
			String ic=br.readLine();
			boolean cha=false;
			
			for(int j=0;j<ic.length();j++) {
				char c=ic.charAt(j);
				if(c-'0'>=0&&c-'0'<=9) {
					// cha가 참이면 문자로
				}else {
					cha=true; //cha가 거짓이면 숫자
				}
				
			}
			if(!cha) {
				int tar=Integer.parseInt(ic);
				System.out.println(dogam.get(tar));
			}else {
				
				System.out.println(h.get(ic));
			}
			
			
		}
		
		
	}

}
