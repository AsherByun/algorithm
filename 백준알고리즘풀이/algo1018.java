package algo;
import java.util.*;
public class algo1018 {

	static int n,m;
	ArrayList res = new ArrayList();
	static char[][] smap;
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan =new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		smap=new char[n][m];
		map=new int[n][m];
		for(int i=0;i<n;i++) {
			String in = scan.next();
			smap[i]=in.toCharArray();
			for(int j=0;j<m;j++) {
				if(smap[i][j]=='W') {
					map[i][j]=1;
				}else {
					map[i][j]=-1;
				}
			}
		}
	
	
		int min=99999;
		
		for(int i=0;i<n-7;i++) {
			for(int j=0;j<m-7;j++) {
				int bt=bfirst(i,j);
				int wt=wfirst(i,j);
				if(bt<wt&&bt<min) {
					min=bt;}
				else if(bt>=wt&&wt<min) {min=wt;}
				
			}
		}
		
		
		
		System.out.println(min);
		
	
	}
	
	
	static int bfirst(int x,int y) {
		int c=0;
		
		
		
		for(int i=x;i<=x+7;i++) {
			for(int j=y;j<=y+7;j++) {
				if((i+j)%2==0) {
					if(map[i][j]!=-1) {c++;}
				}else {
					if(map[i][j]!=1) {c++;}
				}
			}
		}
		
		
		
		
		return c;
	}
	
	
	static int wfirst(int x,int y) {
		int c=0;
		
		
		
		for(int i=x;i<=x+7;i++) {
			for(int j=y;j<=y+7;j++) {
				if((i+j)%2==0) {
					if(map[i][j]!=1) {c++;}
				}else {
					if(map[i][j]!=-1) {c++;}
				}
			}
		}
		
		
		
		
		return c;
	}
	
	
	

}
