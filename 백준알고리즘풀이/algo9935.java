package algo;
import java.util.*;
import java.io.*;

public class algo9935 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in=br.readLine();
		String bm=br.readLine();
		
		ArrayList map=new ArrayList();
		Stack s=new Stack();
		
		for(int i=0;i<in.length();i++) {
			map.add(in.charAt(i));
			if(in.charAt(i)==bm.charAt(0)) {
				s.add(i);
			}
		}
		int tsize=map.size();
		int np=0;
		
		while(!s.isEmpty()) {
			
			if(map.size()<bm.length())break;
			
			int p=(int)s.pop();
			boolean bc=true;
			
			if(p+bm.length()<=map.size()) {
			for(int i=0;i<bm.length();i++) {
				
				if(bm.charAt(i)!=(char)map.get(p+i)) {
					bc=false;
				}
			}
			if(bc) {
				for(int i=0;i<bm.length();i++) {
					map.remove(p);
				}
			}
			}
			
			
		}
		if(map.size()>0) {
		for(int i=0;i<map.size();i++)System.out.printf("%c", map.get(i));
		}else {
			System.out.println("FRULA");
		}
		
	}

}
