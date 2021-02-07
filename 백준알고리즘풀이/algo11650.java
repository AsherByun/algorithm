package algo;
import java.util.*;
public class algo11650 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		ArrayList a=new ArrayList();
		
		for(int i=0;i<n;i++) {
			int x=scan.nextInt();
			int y=scan.nextInt();
			a.add(new a11(x,y));
		}
		Collections.sort(a);
		
		for(int i=0;i<a.size();i++) {
			a11 ta=(a11)a.get(i);
			System.out.println(ta.x+" "+ta.y);
		}
		
	}

}
class a11 implements Comparable<a11>{
	int x;
	int y;
	
	a11(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	@Override
	public int compareTo(a11 o) {
		if(this.x>o.x) {
			return 1;
		}else if(this.x<o.x) {
			return -1;
		}else {
			if(this.y>o.y) {
				return 1;
			}else {
				return -1;
			}
		}
	}
	
}