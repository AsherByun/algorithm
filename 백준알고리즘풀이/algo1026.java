package algo;
import java.util.*;
public class algo1026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		
		int a[]=new int[n];
		int b[]=new int[n];
		
		for(int i=0;i<n;i++)a[i]=scan.nextInt();
		for(int i=0;i<n;i++)b[i]=scan.nextInt();
		
		Arrays.sort(a);
		Arrays.sort(b);
		int tot=0;
		for(int i=0;i<n;i++) {
			tot+=a[i]*b[n-1-i];
		}
		
		System.out.println(tot);
	}

}
