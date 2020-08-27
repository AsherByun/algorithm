package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo1051 {
	static int n,m;
	static int map[][];
	static int max=1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		map=new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			in=br.readLine().split("");
			for(int j=1;j<=m;j++) {
				map[i][j]=Integer.parseInt(in[j-1]);
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				int x[]=new int[4];int y[]=new int[4];
				for(int k=0;k<4;k++) {
					x[k]=i;y[k]=j;
				}
				find(x,y,1);
				
			}
		}
		System.out.println(max);
	}
	static void find(int[] x,int[] y,int s) {
		
		boolean can=false;
//		boolean over=false;
		if(x[1]<=n&&y[1]<=m&&x[2]<=n&&y[2]<=m&&x[3]<=n&&y[3]<=m) {
		if((map[x[0]][y[0]]==map[x[1]][y[1]])&&(map[x[0]][y[0]]==map[x[2]][y[2]])&&(map[x[0]][y[0]]==map[x[3]][y[3]])) {
			can=true;
		}
		}else {
			return;
		}
		
		
		int temp=s*s;
		if(max<temp&&can) {
			max=temp;
		}
		
		y[1]++;x[2]++;x[3]++;y[3]++;
		find(x,y,s+1);
		
	}

}
