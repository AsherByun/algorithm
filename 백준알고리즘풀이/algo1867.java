package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo1867 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		int n=Integer.parseInt(in[0]);
		int m=Integer.parseInt(in[1]);
		
		int map[][]=new int[n+1][n+1];
	//	int x[]=new int[n+1];
	//	int y[]=new int[n+1];
		
		int tot=m;
		for(int i=1;i<=m;i++) {
			String ina[]=br.readLine().split(" ");
			int a=Integer.parseInt(ina[0]);
			int b=Integer.parseInt(ina[1]);
			
			map[a][b]=1;
			map[0][b]++;
			map[a][0]++;
		}
		int c=0;
		while(true) {
			
		if(tot<=0) {break;}	
		c++;	
			
		int num=-1;
		int xy=-1; //0x  1y
		int max=0;
		
		for(int i=1;i<=n;i++) {
			if(max<map[0][i]) {max=map[0][i];num=i;xy=1;}
			if(max<map[i][0]) {max=map[i][0];num=i;xy=0;}
			
		}
		if(xy==0) {
			for(int i=1;i<=n;i++) {
				map[num][i]=0;
			}
			tot-=map[num][0];
			
			
		}else {
			for(int i=1;i<=n;i++) {
				map[i][num]=0;
			}
			tot-=map[0][num];
			
			
			
		}
		
		
		
		}
		System.out.println(c);
		
	}

}
