package algo;

import java.util.*;

public class algo1448 {
	static int big=0;static boolean can=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int k=3;
		int c=0;
		
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scan.nextInt();
		}
		Integer[] in=Arrays.stream(arr).boxed().toArray(Integer[]::new);
		
		Arrays.sort(in, Comparator.reverseOrder());
		perm(in,0,n,3);
		
		if(big==0) {System.out.println(-1);}
		else System.out.println(big);
		
	}
	
	static void perm(Integer[] arr,int depth,int n,int k) {
		
		if(depth==k) {
//			for(int i=0;i<3;i++) {
//				System.out.printf("%d ", arr[i]);
//			}System.out.println("");
//			
			if(arr[0]>=arr[1]&&arr[0]>=arr[2]) {
				if(arr[0]<arr[1]+arr[2]) {
					if(big<arr[0]+arr[1]+arr[2])big=arr[0]+arr[1]+arr[2];
					can=true;
				}
				
			}if(arr[1]>=arr[0]&&arr[1]>=arr[2]) {
				if(arr[1]<arr[2]+arr[0]) {
					if(big<arr[0]+arr[1]+arr[2])big=arr[0]+arr[1]+arr[2];
					can=true;
				}
			}if(arr[2]>=arr[1]&&arr[2]>=arr[0]) {
				if(arr[2]<arr[1]+arr[0]) {
					if(big<arr[0]+arr[1]+arr[2])big=arr[0]+arr[1]+arr[2];
					can=true;
				}
			}
			
			return;
		}
		if(can)return;
		for(int i=depth;i<n;i++) {
			swap(arr,i,depth);
			perm(arr,depth+1,n,k);
			swap(arr,i,depth);
		}
		
	}
	
	static void swap(Integer[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	

}
