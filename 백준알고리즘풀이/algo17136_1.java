package algo;
import java.util.*;
public class algo17136_1 {

	static int n,m;
	static int map[][]=new int[11][11];
	static int visit[][]=new int[11][11];
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static ArrayList arr;
	static boolean v[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				map[i][j]=scan.nextInt();
			}
		}
		
		visit=new int[11][11];
		
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				if(map[i][j]==1) {
					if(i+1<=10&&j+1<=10) {
					if(two(i,j)) {
						if(i+2<=10&&j+2<=10) {
						if(thr(i,j)) {
							if(i+3<=10&&j+3<=10) {
							if(four(i,j)) {
								if(i+4<=10&&j+4<=10) {
								if(five(i,j)) {
								}
							}}
						}}
						}
					
					
				}else if(visit[i][j]==0) {
					visit[i][j]=1;
				}
				else if(visit[i][j]==0&&map[i][j]==1) {
					visit[i][j]=1;
				}
			}
				}
				
			}
			
		
		}
		
		v=new boolean[11][11];
		int tot[]=new int[6];
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				System.out.printf("%d ",visit[i][j]);
			}System.out.println("");
		}
		
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				if(!v[i][j]&&visit[i][j]!=0) {
					switch(visit[i][j]) {
					case 1:
						tot[1]++;v[i][j]=true;
						break;
					case 2:
						if(twof(i,j)) {
							tot[2]++;
						}else {
							tot[1]++;
						}break;
					case 3:
						if(thrf(i,j)) {
							tot[3]++;
						}else {
							tot[1]++;
						}break;
					case 4:
						if(fourf(i,j)) {
							tot[4]++;
						}else {
							tot[1]++;
						}break;
					case 5:
						if(fivef(i,j)) {
							tot[5]++;
						}else {
							tot[1]++;
						}break;
						default:
							break;
					}
					
				}
				
			}
		}
		
		
		
		
		boolean cu=true;
		int res=0;
		for(int i=1;i<=5;i++) {
			System.out.println(tot[i]);
			if(tot[i]>5)cu=false;
			res+=tot[i];
		}
		if(cu) {
			System.out.println(res);
		}else {
			System.out.println(-1);
		}
		
		
	}
	
	static boolean two(int x,int y) {
		boolean can=true;
		for(int i=0;i<2;i++) {
			if(map[x+1][y+i]!=1) {
				can=false;
			}
			if(map[x+i][y+1]!=1) {
				can=false;
			}
		}
		if(can) {
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					if(visit[x+i][y+j]<2)
					visit[x+i][y+j]=2;
				}
			}
		}
		
		
		return can;
	}
	static boolean thr(int x,int y) {
	
		boolean can=true;
		for(int i=0;i<3;i++) {
			if(map[x+2][y+i]!=1) {
				can=false;
			}
			if(map[x+i][y+2]!=1) {
				can=false;
			}
		}
		if(can) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(visit[x+i][y+j]<3)
					visit[x+i][y+j]=3;
				}
			}
		}
		
		
		return can;
	}
	static boolean four(int x,int y) {
		boolean can=true;
		for(int i=0;i<4;i++) {
			if(map[x+3][y+i]!=1) {
				can=false;
			}
			if(map[x+i][y+3]!=1) {
				can=false;
			}
		}
		if(can) {
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(visit[x+i][y+j]<4)
					visit[x+i][y+j]=4;
				}
			}
		}
		
		
		return can;
	}
	static boolean five(int x,int y) {
		boolean can=true;
		for(int i=0;i<5;i++) {
			if(map[x+4][y+i]!=1) {
				can=false;
			}
			if(map[x+i][y+4]!=1) {
				can=false;
			}
		}
		if(can) {
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					if(visit[x+i][y+j]<5)
					visit[x+i][y+j]=5;
				}
			}
		}
		
		
		return can;
	}
	
	static boolean twof(int x,int y) {
		boolean can=true;
		for(int i=0;i<2;i++) {
			if(visit[x+1][y+i]!=2) {
				can=false;
			}
			if(visit[x+i][y+1]!=2) {
				can=false;
			}
		}
		if(can) {
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					v[x+i][y+j]=true;
				}
			}
		}
		
		
		return can;
	}
	static boolean thrf(int x,int y) {
	
		boolean can=true;
		for(int i=0;i<3;i++) {
			if(visit[x+2][y+i]!=3) {
				can=false;
			}
			if(visit[x+i][y+2]!=3) {
				can=false;
			}
		}
		if(can) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					v[x+i][y+j]=true;
				}
			}
		}
		
		
		return can;
	}
	static boolean fourf(int x,int y) {
		boolean can=true;
		for(int i=0;i<4;i++) {
			if(visit[x+3][y+i]!=4) {
				can=false;
			}
			if(visit[x+i][y+3]!=4) {
				can=false;
			}
		}
		if(can) {
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					v[x+i][y+j]=true;
				}
			}
		}
		
		
		
		return can;
	}
	static boolean fivef(int x,int y) {
		boolean can=true;
		for(int i=0;i<5;i++) {
			if(visit[x+4][y+i]!=5) {
				can=false;
			}
			if(visit[x+i][y+4]!=5) {
				can=false;
			}
		}
		if(can) {
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					
					v[x+i][y+j]=true;
				}
			}
		}
		
		
		
		return can;
	}
	
}
class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
}
