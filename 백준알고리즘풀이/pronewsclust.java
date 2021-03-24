package algo;
import java.util.*;
public class pronewsclust {
	static String str1="aa1+aa2";
	static String str2="AAAA12";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		str1=str1.toLowerCase();
		str2=str2.toLowerCase();
		
		ArrayList a1=new ArrayList();
		ArrayList a2=new ArrayList();
		
		HashMap h1=new HashMap();
		HashMap h2=new HashMap();
		
		for(int i=0;i<str1.length()-1;i++) {
			String temp="";
			temp+=str1.charAt(i);
			int tc=str1.charAt(i)-'0';
			if(!(tc>='a'-0&&tc<='z'-0&&tc<='Z'-0&&tc>='A'-0)||str1.charAt(i)==' ')continue;
			temp+=str1.charAt(i+1);
			tc=str1.charAt(i+1)-'0';
			if(!(tc>='a'-0&&tc<='z'-0&&tc<='Z'-0&&tc>='A'-0)||str1.charAt(i)==' ')continue;
			
			if(h1.containsKey(temp)) {
				int tk=(int)h1.get(temp);
				tk++; h1.put(temp, tk);
			}else {
				h1.put(temp, 1);
			}
			a1.add(temp);
		}
		for(int i=0;i<a1.size();i++) {
			System.out.println(a1.get(i));
		}
		for(int i=0;i<str2.length()-1;i++) {
			String temp="";
			temp+=str2.charAt(i);
			int tc=str2.charAt(i)-'0';
			if(!(tc>='a'-0&&tc<='z'-0&&tc<='Z'-0&&tc>='A'-0)||str2.charAt(i)==' ')continue;
			temp+=str2.charAt(i+1);
			tc=str2.charAt(i+1)-'0';
			if(!(ztc>='a'-0&&tc<='z'-0)&&tc<='Z'-0&&tc>='A'-0)||str2.charAt(i+1)==' ')continue;
			
			if(h2.containsKey(temp)) {
				int tk=(int)h2.get(temp);
				tk++; h2.put(temp, tk);
			}else {
				h2.put(temp, 1);
			}
			
			a2.add(temp);
		}
		
		
		double n=0;
		ArrayList ta2=new ArrayList();
		ta2=(ArrayList)a2.clone();
		double u=0;
		for(int i=0;i<a1.size();i++) {
			String temp=(String)a1.get(i);
			
			if(ta2.contains(temp)) {
				n++;ta2.remove((String)temp);
			}
			
		}
		ArrayList ta=new ArrayList();
		
		for(int i=0;i<a1.size();i++) {
			String temp=(String)a1.get(i);
			if(a2.contains(temp)) {
				a2.remove((String)temp);
				ta.add(temp);
			}else {
				ta.add(temp);
			}
			
		}
		u=ta.size()+a2.size();
		
		
		
		
		double tot=n/u;
		int ans=(int) (tot*65536);
		System.out.println(ans);
	}

}
