package algo;
import java.util.*;
public class algo1342_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int tot=0;
		char arr[]=scan.next().toCharArray();
		Arrays.sort(arr);
		
		while(true) {
			if(isluck(arr)) {
				tot++;
			}
			if(!nextpermutation(arr)) {
				break;
			}
			
		}
		
		System.out.println(tot);
			
	}
	static boolean isluck(char[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]==arr[i+1]) {
				return false;
			}
			
		}
		return true;
	}
	static boolean nextpermutation(char[] arr) {
		int i=arr.length-1;
		while(i>0&&arr[i-1]>=arr[i]) {
			--i;
		}
		
		if(i<=0)
			return false;
		
		int j=arr.length-1;
		
		while(arr[j]<=arr[i-1]) {
			j--;
		}
		
		char temp=arr[i-1];
		arr[i-1]=arr[j];
		arr[j]=temp;
		
		j=arr.length-1;
		while(i<j) {
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;j--;
		}
		
		return true;
		
		
	}

}
