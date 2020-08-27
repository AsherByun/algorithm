package algo;
import java.util.*;
public class algo1059 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		
		int arr[]=new int[n];
		boolean visit[]=new boolean[1001];
		
		for(int i=0;i<n;i++) {
			arr[i]=scan.nextInt();
			visit[arr[i]]=true;
		}
		Arrays.sort(arr);
		
		int tar=scan.nextInt();
		if(visit[tar]) {
			System.out.println(0);return;
		}
		
		int s=1;
		int e=arr[n-1]-1;
		
		if(tar<arr[0]) {
			s=1;e=arr[0]-1;
		}
		else {
			for(int i=1;i<n;i++) {
				if(tar<arr[i]&&tar>arr[i-1]) {
					s=arr[i-1]+1;e=arr[i]-1;
				}
			}
		}
//		System.out.println(s);
//		System.out.println(e);
		
		int tot=0;
		
		for(int i=s;i<=tar;i++) {
			for(int j=tar;j<=e;j++) {
				tot++;
			}
			
		}
		
		
		
		System.out.println(tot-1);
	}

}
