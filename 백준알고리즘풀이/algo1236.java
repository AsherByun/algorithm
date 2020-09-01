package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo1236 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		int n=Integer.parseInt(in[0]);
		int m=Integer.parseInt(in[1]);
		
		char[][] map=new char[n][m];
		boolean[] vr=new boolean[n];
		boolean[] vc=new boolean[m];
		int c=0;int r=0;
		
		for(int i=0;i<n;i++) {
			map[i]=br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				if(map[i][j]=='X') {			
						vr[i]=true;
						vc[j]=true;		
				}
			}
		}

		for(int i=0;i<n;i++) {
			if(!vr[i]) {
				++r;
			}
		}
		
		for(int i=0;i<m;i++) {
			if(!vc[i]) {
				++c;
			}
		}
		
		
		System.out.println(c>r?c:r);
	}

}
