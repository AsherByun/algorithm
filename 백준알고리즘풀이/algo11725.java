package algo;
import java.util.*;
public class algo11725 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> h=new HashMap();
		HashMap<Integer, Integer> ch=new HashMap();
		HashMap<Integer, Integer> rh=new HashMap();
		Scanner scan = new Scanner(System.in);
		
		int n= scan.nextInt();

		for(int i=1;i<n;i++) {
			int par=scan.nextInt();
			int son=scan.nextInt();
			if(son==1) {
				ch.put(par,1);
				h.put(par,son);
			}
			else if(ch.get(son)!=null) {
				h.put(par,son);
				ch.put(par,1);
			}else if(rh.get(par)!=null) {
				
			}
			else {
			rh.put(son,1);
			h.put(son,par);
			}
			
		}
		for(int i=2;i<=n;i++) {
			System.out.println(h.get(i));
		}
		
		

	}

}
