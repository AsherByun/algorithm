package algo;
import java.util.*;
public class algo2164 {
	
	static int n;
	static LinkedList map = new LinkedList();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		n=scan.nextInt();
		for(int i=1;i<=n;i++) {
			map.add(i);
		}
		if(n==1) {}
		else {while(true) {
			map.poll();
			if(map.size()==1) {
				break;
			}
			map.add((int) map.poll());
		}}
		System.out.println((int) map.poll());
		

	}

}
