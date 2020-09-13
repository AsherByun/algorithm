package algo;
import java.util.*;
public class algo1477 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int m=scan.nextInt();
		int l=scan.nextInt();
		
		ArrayList a=new ArrayList();
		
		for(int i=0;i<6;i++) {
			int temp=scan.nextInt();
			a.add(temp);
		}
		Collections.sort(a);
		
		ArrayList d=new ArrayList();
		for(int i=0;i<a.size();i++) {
			if(i==a.size()-1) {
				d.add(l-(int)a.get(i));
			}
			else {
			int t1=(int)a.get(i);
			int t2=(int)a.get(i+1);
			d.add(t2-t1);
			}
		
		}
		Collections.sort(d);
		
		
		
		
	}

}
