package algo;
import java.util.*;
import java.io.*;
public class algo1431 {
	static int rank[][];
	static String map[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		map=new String[n];
		
		rank=new int[n][3];
		
		for(int i=0;i<n;i++) {
			map[i]=br.readLine();
			rank[i][0]=map[i].length();
			for(int j=0;j<map[i].length();j++) {
				if(map[i].charAt(j)-'0'>=0&&map[i].charAt(j)-'0'<10) {
					rank[i][1]+=(map[i].charAt(j)-'0');
				}
			}
		}
		
		for(int i=0;i<n-1;i++) {
				int minn=i;
			
			for(int j=i+1;j<n;j++) {
				if(rank[minn][0]>rank[j][0]) {
					minn=j;
				}else if(rank[minn][0]==rank[j][0]){
					if(rank[minn][1]>rank[j][1]) {
						minn=j;
					}else if(rank[minn][1]==rank[j][1]) {
						if(compare(map[minn],map[j])>0) {
							minn=j;
						}else {
							
						}
					}
					
				}
				
			}
			if(i!=minn) {
				swap(i,minn);
			}
			
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(map[i]);
		}
		
		
		
		
	}
	static int compare(String t1,String t2) {
		
		
		for(int i=0;i<t1.length();i++) {
			
			if(t1.charAt(i)-'0'>t2.charAt(i)-'0') {
				
				return 1;
				
				
			}else if(t1.charAt(i)-'0'<t2.charAt(i)-'0') {
				
				
				return -1;
				
			}else {
				
			
			}
			
			
		}
		return 0;
			
	}
	static void swap(int i,int j) {
		
		String temp=map[i];
		map[i]=map[j];
		map[j]=temp;
		
		for(int k=0;k<2;k++) {
			int tem=rank[i][k];
			rank[i][k]=rank[j][k];
			rank[j][k]=tem;
		}
		
	}

}
