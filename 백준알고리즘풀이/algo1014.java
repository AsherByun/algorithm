package algo;
import java.util.*;
import java.io.*;
public class algo1014 {
	static int n,m;
	static char map[][];
	static int max=0;
	static int dx[]= {0,1,0,1,-1,-1};
	static int dy[]= {-1,-1,1,1,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testc=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<testc;tc++) {
			
			String in[]=br.readLine().split(" ");
			n=Integer.parseInt(in[0]);
			m=Integer.parseInt(in[1]);
			map=new char[n+1][m+1];
			max=0;
			for(int i=1;i<=n;i++) {
				char inn[]=br.readLine().toCharArray();
				for(int j=1;j<=m;j++) {
					map[i][j]=inn[j-1];
				}
			}
			f1();
//			System.out.println(max);
			f2();
			
			System.out.println(max);
		}
		
		
		
	}
	static void f1() {
		int tot=0;
		char tmap[][]=new char[n+1][m+1];
		for(int i=1;i<=n;i++) {
			tmap[i]=map[i].clone();
		}
		
		for(int i=1;i<=m;i=i+2) {
			for(int j=1;j<=n;j++) {
				if(tmap[j][i]=='.') {
					tmap[j][i]='s';tot++;;
				}
			}
		}
		
		for(int i=2;i<=m;i=i+2) {
			for(int j=1;j<=n;j++) {
				boolean can=true;
				if(tmap[j][i]=='.') {
				for(int k=0;k<6;k++) {
					int x=j+dx[k];int y=i+dy[k];
					if(x>=1&&y>=1&&x<=n&&y<=m) {
						if(tmap[x][y]=='s')can=false;
					}
				}
				if(can) {
//					System.out.println(j+" "+i);
					tmap[j][i]='s';
					tot++;
				}
				}
			}
		}
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=m;j++) {
//				System.out.printf("%c",tmap[i][j]);
//			}System.out.println("");
//		}
//		
//		System.out.println(tot);
		if(tot>max)max=tot;
		
	}
	static void f2() {
		int tot=0;
		char tmap[][]=new char[n+1][m+1];
		for(int i=1;i<=n;i++)tmap[i]=map[i].clone();
		
		for(int i=2;i<=m;i=i+2) {
			for(int j=1;j<=n;j++) {
				if(tmap[j][i]=='.') {
					tmap[j][i]='s';tot++;
				}
			}
		}
		
		for(int i=1;i<=m;i=i+2) {
			for(int j=1;j<=n;j++) {
				boolean can=true;
				if(tmap[j][i]=='.') {
				for(int k=0;k<6;k++) {
					int x=j+dx[k];int y=i+dy[k];
					if(x>=1&&y>=1&&x<=n&&y<=m) {
						if(tmap[x][y]=='s')can=false;
					}
				}
				if(can) {
					tmap[j][i]='s';
					tot++;
				}
				}
				}
		}
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=m;j++) {
//				System.out.printf("%c",tmap[i][j]);
//			}System.out.println("");
//		}
//		
//		
//		System.out.println(tot);
		if(tot>max)max=tot;
		
	}
	
	
}
