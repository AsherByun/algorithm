package leetcode;
import java.util.*;
public class Permutation46 {
	static int nums[]= {1};
	static List<List<Integer>> list = new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays.sort(nums);
		push(nums);
		while(next_permutation(nums));
		
		for(int i=0;i<list.size();i++) {
			ArrayList temp=(ArrayList)list.get(i);
			for(int j=0;j<temp.size();j++) {
				System.out.printf("%d ", temp.get(j));
			}System.out.println("");
		}
		
	}
	static boolean next_permutation(int[] arr) {
		int i=arr.length-1;
		while(i>0&&arr[i-1]>=arr[i])i--;
		if(i<=0)return false;
		
		int j=arr.length-1;
		while(arr[j]<=arr[i-1]) {
			j--;
		}
		swap(i-1,j,arr);
		j=arr.length-1;
		for(;i<j;i++,j--)swap(i,j,arr);
		
		push(arr);
		return true;
	}
	static void push(int arr[]) {
		ArrayList a=new ArrayList();
		for(int i=0;i<arr.length;i++)a.add(arr[i]);
		list.add(a);
	}
	static void swap(int i,int j,int[] arr) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
