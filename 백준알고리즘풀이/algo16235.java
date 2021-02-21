package algo;
import java.util.*;
import java.io.*;
public class algo16235 {
	static int n,m,k;
	static ArrayList tree[][];
	static int yang[][];
	static int map[][];
	static int dx[]= {-1,-1,-1,0,0,1,1,1};
	static int dy[]= {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		k=Integer.parseInt(in[2]);
		
		tree=new ArrayList[n+1][n+1];
		map=new int[n+1][n+1];
		for(int i=1;i<=n;i++)Arrays.fill(map[i], 5);
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				tree[i][j]=new ArrayList();
			}
		}
		
		yang=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			in=br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				yang[i][j]=Integer.parseInt(in[j-1]);
			}
		}
		for(int i=0;i<m;i++) {
			in=br.readLine().split(" ");
			int x=Integer.parseInt(in[0]);
			int y=Integer.parseInt(in[1]);
			int life=Integer.parseInt(in[2]);
			tree[x][y].add(life);
		}
		int time=0;
		while(true) {
			time++;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					Collections.sort(tree[i][j]);
				}
			}
		
			///////////////////////º½/¿©¸§/////////////////
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					int cut=100000000;
					for(int t=0;t<tree[i][j].size();t++) {
						int tyear=(int)tree[i][j].get(t);
						if(tyear>map[i][j]) {
							cut=t;break;
						}else {
							map[i][j]-=tyear;
						}
					}
					int len=tree[i][j].size();
					for(int t=0;t<len-cut;t++) {
						map[i][j]+=(int)tree[i][j].get(cut)/2;
						tree[i][j].remove(cut);
					}
					ArrayList b=new ArrayList();
					for(int t=0;t<tree[i][j].size();t++) {
						b.add((int)tree[i][j].get(t)+1);
					}
					 tree[i][j]=(ArrayList) b.clone();
				}
			}
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					for(int t=0;t<tree[i][j].size();t++) {
						int tyear=(int)tree[i][j].get(t);
						if(tyear%5==0) {
							for(int c=0;c<8;c++) {
								int x=dx[c]+i;
								int y=dy[c]+j;
								if(x>0&&y>0&&x<=n&&y<=n) {
								tree[x][y].add(1);
								}
							}
						}
				}
			}
		}
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					map[i][j]+=yang[i][j];
				}
			}
//			int tot=0;
//			
//			for(int i=1;i<=n;i++) {
//				for(int j=1;j<=n;j++) {
//				tot+=tree[i][j].size();
//			}
//		}
//			System.out.println(time);
//			
//			for(int i=1;i<=n;i++) {
//				for(int j=1;j<=n;j++) {
//				System.out.printf("%d ", tree[i][j].size());
//			}System.out.println("");
//		}
			
			if(time==k)break;
		}
		
		int tot=0;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
			tot+=tree[i][j].size();
		}
	}
		System.out.println(tot);
		
		
		
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=n;j++) {
//				
//			}
//		}
		
	}

}
class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
}