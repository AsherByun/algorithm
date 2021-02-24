package algo;
import java.util.*;
import java.io.*;
public class algo17281 {

	static int map[][];
	static int n,m;
	static boolean visit[];
	static int max=0;
	static int tmem[]=new int[10];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		map=new int[n+1][10];
		
		for(int i=1;i<=n;i++) {
			String in[]=br.readLine().split(" ");
			for(int j=1;j<=9;j++) {
				map[i][j]=Integer.parseInt(in[j-1]);
			}
		}
		visit=new boolean[10];
		int mem[]=new int[10];
		mem[4]=1;
		visit[1]=true;
		
		for(int i=1;i<=9;i++) {
			int c=1;
			if(!visit[i]) {
			visit[i]=true;
			mem[c]=i;
			maket(mem,c+1);
			visit[i]=false;
			}
		}
		
		System.out.println(max);
		
	}
	
	static void maket(int mem[],int c) {
		
		
		if(c==10) {
			score(mem);
		}
		else if(c==4) {
			maket(mem,c+1);
		}else {
			
			for(int i=1;i<=9;i++) {
				if(!visit[i]) {
					visit[i]=true;
					mem[c]=i;
					maket(mem,c+1);
					visit[i]=false;
				}
				
			}
		
		}
		
	}
	
	static void score(int mem[]) {
		
		int num=0;
		int tot=0;
		
		for(int i=1;i<=n;i++) {
			int ru[]=new int[4];
			int out=0;
			while(true) {
				num++;
				if(num>9)num=1;
				
				int temp=map[i][mem[num]];
				
				if(temp==1) {
					if(ru[3]==1) {
						ru[3]=0;tot++;
					}if(ru[2]==1) {
						ru[3]=1;ru[2]=0;
					}if(ru[1]==1) {
						ru[2]=1;ru[1]=0;
					}
						ru[1]=1;
					
				}else if(temp==2) {
					if(ru[3]==1) {
						ru[3]=0;tot++;
					}if(ru[2]==1) {
						ru[2]=0;tot++;
					}if(ru[1]==1) {
						ru[3]=1;ru[1]=0;
					}
						ru[2]=1;
					
				}else if(temp==3) {
					if(ru[3]==1) {
						ru[3]=0;tot++;
					}if(ru[2]==1) {
						ru[2]=0;tot++;
					}if(ru[1]==1) {
						ru[1]=0;tot++;
					}
						ru[3]=1;
					
				}else if(temp==4) {
					if(ru[3]==1) {
						ru[3]=0;tot++;
					}if(ru[2]==1) {
						tot++;ru[2]=0;
					}if(ru[1]==1) {
						tot++;ru[1]=0;
					}
						tot++;
					
				}else {
					out++;
				}
				
				if(out==3)break;
				
			}
			
					
			
		}
	
		if(tot>max) {
			max=tot;
		}
		
	}
	

}
