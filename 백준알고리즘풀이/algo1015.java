package algo;
import java.util.*;
public class algo1015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int a[]=new int[n];
		int num[]=new int[1001];
		
		for(int i=0;i<n;i++) {
			a[i]=scan.nextInt();
			num[a[i]]++;
		}
		int s[]=new int[1001];
		Arrays.fill(s, 999999);
		int e[]=new int[1001];
		int t[]=a.clone();
		Arrays.sort(a);
		
		for(int i=0;i<n;i++) {
			if(s[a[i]]==999999) {
				s[a[i]]=i;
			}
		}
//		
//		for(int i=0;i<n;i++) {
//			if(s[a[i]]==999999) {
//				s[a[i]]=i;e[a[i]]=i+num[a[i]]-1;
//			}
//		}
	
		
		
		for(int i=0;i<n;i++) {
			if(num[t[i]]>1) {
				num[t[i]]--;
				System.out.printf("%d ", s[t[i]]);
				s[t[i]]++;
			}else {
				System.out.printf("%d ", s[t[i]]);
			}
			
		}
		
		
		
		
	}

}
