package algo;
import java.util.*;
public class algo2110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		ArrayList map=new ArrayList();
		
		int n=scan.nextInt();int m=scan.nextInt();
		int house[]=new int[n];
		for(int i=0;i<n;i++)house[i]=scan.nextInt();
		Arrays.sort(house);
		
		int left=house[0]; int right=house[n-1]-house[0];
		int mid=0;
		
		while(left<=right) {
			int cnt=1, prev=house[0];
			mid=(left+right)/2;
			
			for(int h:house) {
				if(h-prev>=mid) {
					cnt++;prev=h;
				}
			}
			
			if(cnt>=m)left=mid+1;
			else right=mid-1;
			
		}
		System.out.println(right);
		
		
		
		
//		for(int i=0;i<tot.size();i++) {
//			ArrayList a=(ArrayList)tot.get(i);
//			for(int j=0;j<a.size();j++) {
//				System.out.printf("%d ", a.get(j));
//			}System.out.println("");
//		}
	}

}
