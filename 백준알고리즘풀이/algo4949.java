package algo;
import java.util.*;
import java.io.*;
public class algo4949 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList res=new ArrayList();
		while(true) {
			String s=br.readLine();
			if(s.equals(".")) {
				break;
			}
			Stack sck=new Stack();
			boolean can=true;
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='.')break;
				
				if('('==s.charAt(i)) {
					sck.push('(');
				}else if('['==s.charAt(i)) {
					sck.push('[');
				}else if(')'==s.charAt(i)) {
					if(sck.isEmpty()) {
						can=false; break;
					}else {
						char temp=(char)sck.pop();
						if(temp!='(') {
							can=false; break;
						}
					}
				}else if(']'==s.charAt(i)) {
					if(sck.isEmpty()) {
						can=false; break;
					}else {
						char temp=(char)sck.pop();
						if(temp!='[') {
							can=false; break;
						}
					}
				}
			}
			if(!sck.isEmpty())can=false;
			
			if(can)res.add("yes");
			else res.add("no");
			
		}
		for(int i=0;i<res.size();i++)
			System.out.println(res.get(i));
	}

}
