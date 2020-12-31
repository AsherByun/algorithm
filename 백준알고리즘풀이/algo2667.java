package algo;
import java.util.*;
public class algo2667 {
	static ArrayList res=new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int n=0;
		n=scan.nextInt();
		
		int arr[][] = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=scan.nextInt();
			}
			
		}
		int count=0;
		int[] in= new int[10000];
		int[] jn= new int[10000];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1) {
					int point=1;
					in[1]=i;jn[1]=j;count++;
					arr=find(arr, in, jn,point,count);
				}
				
				
				
			}
		}
		
		for(int i=0;i<res.size();i++) {
			
			System.out.println(res.get(i));
		}
		
		
		
		
		
	}
	
	static int[][] find(int[][] arr,int[] in,int[] jn,int point,int count) {
		int size=arr.length;
		int i = 0;
		int j = 0;
		
		if(point>0) {
		arr[in[point]][jn[point]]=0;
		i=in[point];
		j=jn[point];
		}
		
		point--;
		if(i-1>0) {
		if(arr[i-1][j]==1) {
			point++;
			in[point]=i-1;jn[point]=j;
			count++;}
		}else if(j-1>0) {if(arr[i][j-1]==1) {
			point++;
			in[point]=i;jn[point]=j-1;
			count++;}
		}else if(i+1<size) {if(arr[i+1][j]==1) {
			point++;
			in[point]=i+1;jn[point]=j;
			count++;}
		}else if(j+1<size) {if(arr[i][j+1]==1) {
			point++;
			in[point]=i;jn[point]=j+1;
			count++;}
		}else if(point==0) {
			res.add(count);
			return arr;
		}
		
		
		
		
		
		
		return find(arr, in, jn,point,count);
		
	}
	
	
	

}
