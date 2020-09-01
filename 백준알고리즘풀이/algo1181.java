package algo;
import java.util.*;
import java.io.*;
public class algo1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		ArrayList a=new ArrayList();
		HashMap h=new HashMap();
		for(int i=0;i<n;i++) {
			String t=br.readLine();
			if(!h.containsKey(t)) {
			h.put(t, 1);
			a81 ak=new a81(t.length(),t);
			a.add(ak);
			}
		}
		Collections.sort(a);
		for(int i=0;i<a.size();i++) {
			a81 temp=(a81)a.get(i);
			System.out.println(temp.s);
		}
		
	}

}
class a81 implements Comparable<a81>{
	int l;
	String s;
	a81(int l,String s){
		this.s=s;
		this.l=l;
	}
	
	@Override
	public int compareTo(a81 o) {
		if(this.l>o.l) {
			return 1;
		}else if(this.l<o.l) {
			return -1;
		}
		else {
			for(int i=0;i<this.l;i++) {
				if(this.s.charAt(i)>o.s.charAt(i)) {
					return 1;
				}else if(this.s.charAt(i)<o.s.charAt(i)) {
					return -1;
				}else {continue;}
			}
		}
		return 0;
	}
	
}