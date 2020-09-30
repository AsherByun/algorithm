package algo;
import java.util.*;
public class algo1920 {
	static int[] map;
	static int n;
	static int m;
	static ArrayList res=new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		map=new int[n];
		for(int i=0;i<n;i++) {
			map[i]=scan.nextInt();
		}
		Arrays.sort(map);
		m=scan.nextInt();

		for(int i=0;i<m;i++) {
			int t=scan.nextInt();
			if(bsearch(0,n-1,t))res.add(1);
			else res.add(0);
		}
		
		for(int i=0;i<m;i++) {
			System.out.println(res.get(i));
		}
		
	}
	static boolean bsearch(int s,int e,int tar) {
		int start=s;
		int end=e;
		int mid;
		boolean can=false;
		while(start<=end) {
			mid=(start+end)/2;
			
			if(map[mid]==tar) {
				return true;
			}
			if(map[mid]>tar){
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		
		return false;
	}
}
