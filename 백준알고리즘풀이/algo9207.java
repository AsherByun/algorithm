package algo;
import java.util.*;
import java.io.*;
public class algo9207 {
	
	static int minc=99999;
	static int minn=99999;
	static int dx[]= {0,-1,0,1};
	static int dxx[]= {0,-2,0,2};
	static int dy[]= {-1,0,1,0};
	static int dyy[]= {-2,0,2,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testc=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<testc;tc++) {
			char[][] map=new char[6][10];
			minn=99999;minc=99999;
			if(tc!=0) {
				String tera=br.readLine();
			}
			
			for(int i=1;i<=5;i++) {
				char in[]=br.readLine().toCharArray();
				for(int j=1;j<=9;j++) {
					map[i][j]=in[j-1];
				}
			}
				dfs(0,map);
				
				System.out.println(minn+" "+minc);

				
		}
		
		
		
	}
	static void dfs(int c,char m[][]) {
		
		boolean chan=false;
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=9;j++) {
				if(m[i][j]=='o') {
					for(int k=0;k<4;k++) {
						int x=i+dx[k];
						int y=j+dy[k];
						if(x>=1&&y>=1&&x<=5&&y<=9) {
							if(m[x][y]=='o') {
								int xx=x+dx[k];int yy=y+dy[k];
								if(xx>=1&&yy>=1&&xx<=5&&yy<=9) {
									if(m[xx][yy]=='.') {
										char tmap[][]=new char[6][10];
										for(int tt=1;tt<=5;tt++)tmap[tt]=m[tt].clone();
										tmap[i][j]='.';tmap[x][y]='.';tmap[xx][yy]='o';
										chan=true;
										dfs(c+1,tmap);
									}
								}
							}
						}
					}
				}
			}
		}
		
		if(!chan) {
			int tot=0;
			for(int i=1;i<=5;i++) {
				for(int j=1;j<=9;j++) {
					if(m[i][j]=='o')tot++;
				}
			}
			if(tot<=minn) {
				minn=tot;
				minc=c;
				
			}
			
		}
		
		
		
		
		
	}

}
