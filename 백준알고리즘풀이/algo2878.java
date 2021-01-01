package algo;
import java.util.*;
public class algo2878 {
	static int n,m;
	static int map[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		m=scan.nextInt();
		n=scan.nextInt();
		map=new int[n+1];
		ArrayList<candy> a=new ArrayList();
		for(int i=1;i<=n;i++) {
			int temp=scan.nextInt();
			candy c=new candy(temp);
			a.add(c);
		}
		
		for(int i=0;i<a.size();i++) {
			System.out.println(((candy)a.get(i)).can);
		}
		
		
	}
	
	
}

class candy implements Comparable<candy>{
	int can;
	candy(int can){
		this.can=can;
	}
	
	@Override
	public int compareTo(candy o) {
		if(this.can<o.can) {
			return -1;
		}else if(this.can>o.can) {
			return 1;
		}else {
		return 0;
		}
	}
	
	
}