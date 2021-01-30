package algo;
import java.util.*;
import java.io.*;
public class algo10835_1 {

	static int n;
	static int[] l;static int[] r;static int[] lm;static int[] rm; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		n=scan.nextInt();
		l=new int[n+1];
		r=new int[n+1];
		lm=new int[n+1];
		rm=new int[n+1];
		
		int tmx=0;
		
		for(int i=0;i<n;i++) {
			int temp=scan.nextInt();
			l[i]=temp;
		}
		for(int i=0;i<n;i++) {
			r[i]=scan.nextInt();
		}
		for(int i=n-1;i>=0;i--) {
			if(tmx<l[i]) {
				tmx=l[i];
				lm[i]=tmx;
			}else {
				lm[i]=tmx;
			}
		}
	
		
//		for(int i=0;i<n;i++) {
//			System.out.println(lm[i]);
//		}
		int tot=0;
		int left=0;int right=0;
		while(true) {
			if(right==n||left==n)break;
			
			if(l[left]>r[right]) {
				tot+=r[right];right++;
			}else {
				if(lm[left]>r[right]) {
					left++;
				}else {
					left++;right++;
				}
				
			}
			
		}
		System.out.println(tot);
		
	}

}
