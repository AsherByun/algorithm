package algo;
import java.util.*;
public class algo10815 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		ArrayList a=new ArrayList();
		for(int i=0;i<n;i++) {
			int temp=scan.nextInt();
			a.add(temp);
		}
		
		int k=scan.nextInt();
		int res[]=new int[k];
		Collections.sort(a);
		for(int i=0;i<k;i++) {
			int temp=scan.nextInt();
			int c=Collections.binarySearch(a, temp);
			if(c<0) {
				res[i]=0;
			}else {
				res[i]=1;
			}
		
		}
		for(int i=0;i<k;i++) {
			System.out.printf("%d ", res[i]);
		}
	}

}
