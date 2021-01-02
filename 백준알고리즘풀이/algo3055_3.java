package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo3055_3 {
	static int n,m;
	static int map[][];
	static int water[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		n=Integer.parseInt(str[0]);
		m=Integer.parseInt(str[1]);
		
		int sx=0;int sy=0;
		int swx=0;int swy=0;
		int ex=0;int ey=0;
		map=new int[n+1][m+1];
		water=new int[n+1][m+1];
		
		
		for(int i=1;i<=n;i++) {
			String in=br.readLine();
			for(int j=1;j<=in.length();j++) {
				char t=in.charAt(j-1);
				if(t=='D') {
					ex=i;ey=j;
					water[i][j]=-1;
				}else if(t=='*') {
					water[i][j]=1;
					swx=i;swy=j;
				}else if(t=='S') {
					sx=i;sy=j;
					water[i][j]=-1;
				}
			}
			
		}
		
		
	}

}
