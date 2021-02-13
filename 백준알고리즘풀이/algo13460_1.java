package algo;
import java.util.*;
import java.io.*;
public class algo13460_1 {
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static boolean bb=false,rr=false;
	static int m,n;
	static int min=Integer.MAX_VALUE-1;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		String[][] tmap=new String[n+1][m+1];
		
		point rp=new point(0,0);
		point bp=new point(0,0);
		point fp=new point(0,0);
		
		for(int i=1;i<=n;i++) {
			in=br.readLine().split("");
			for(int j=1;j<=m;j++) {
				tmap[i][j]=in[j-1];
			if(tmap[i][j].equals("B")) {
				bp.x=i;bp.y=j;
			}if(tmap[i][j].equals("O")) {
				fp.x=i;fp.y=j;
			}if(tmap[i][j].equals("R")) {
				rp.x=i;rp.y=j;
			}
			}
		}
		
	for(int k=0;k<4;k++) {
			
			ArrayList d=new ArrayList();
			d.add(k);
			find(tmap,d,1,rp,bp);
			
		}
	/*	right(emap,tr,tb,tr);
		right(emap,tr,tb,tb);
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				System.out.printf("%s", emap[i][j]);
			}System.out.println("");
		}
		*/
		if(min==Integer.MAX_VALUE-1)System.out.println(-1);
		else System.out.println(min);
		
		
	}
	static void find(String[][] map,ArrayList d,int c,point rp,point bp) {
		
		if(c>10) {
			return;
		}
		else {
			point tr=new point(rp.x,rp.y);
			point tb=new point(bp.x,bp.y);
			String tmap[][]=new String[n+1][m+1];
			for(int i=1;i<=n;i++) {tmap[i]=map[i].clone();}
			 bb=false;rr=false;
			for(int i=0;i<d.size();i++) {
				int dir=(int)d.get(i);
				if(dir==0) {
					up(tmap,tr,tb,tr);
					up(tmap,tr,tb,tb);
				}else if(dir==1) {
					right(tmap,tr,tb,tr);
					right(tmap,tr,tb,tb);
				}else if(dir==2) {
					down(tmap,tr,tb,tr);
					down(tmap,tr,tb,tb);
				}else if(dir==3) {
					left(tmap,tr,tb,tr);
					left(tmap,tr,tb,tb);
				}
				
				if(bb) {
					return;
				}else if(rr) {
					if(min>c) {
					min=c;return;
					}
				}
			}	
		}
		for(int i=0;i<4;i++) {
			d.add(i);
			find(map,d,c+1,rp,bp);
			d.remove((Integer)i);
		}
		
	}
	static void up(String map[][],point rp,point bp,point p) {
		int y=p.y;
		
		while(true) {
			boolean can=false;
			
			for(int i=2;i<=n;i++) {
				if(map[i][y]!=null) {
				if(map[i][y].equals("R")||map[i][y].equals("B")) {
					if(map[i-1][y].equals(".")) {
						if(map[i][y].equals("R")) {
							map[i][y]=".";map[i-1][y]="R";rp.x-=1;can=true;
						}else {
							map[i][y]=".";map[i-1][y]="B";bp.x-=1;can=true;
						}	
					}else if(map[i-1][y].equals("O")) {
						if(map[i][y].equals("R")) {
							map[i][y]=".";rp.x=1;rr=true;can=true;
						}else if(map[i][y].equals("B")){
							map[i][y]=".";bp.x=1;bb=true;can=true;
						}
					}
				}
				}
			}
			if(!can)break;		
		}
		
	}
	
	static void down(String map[][],point rp,point bp,point p) {
		int y=p.y;
		while(true) {
			boolean can=false;
			
			for(int i=n-1;i>=1;i--) {
				if(map[i][y]!=null) {
				if(map[i][y].equals("R")||map[i][y].equals("B")) {
					if(map[i+1][y].equals(".")) {
						if(map[i][y].equals("R")) {
							map[i][y]=".";map[i+1][y]="R";rp.x+=1;can=true;
						}else {
							map[i][y]=".";map[i+1][y]="B";bp.x+=1;can=true;
						}	
					}else if(map[i+1][y].equals("O")) {
						if(map[i][y].equals("R")) {
							map[i][y]=".";rp.x=1;rr=true;can=true;
						}else if(map[i][y].equals("B")){
							map[i][y]=".";bp.x=1;bb=true;can=true;
						}
					}
				}
				}
			}
			if(!can)break;		
		}
		
	}
	static void right(String map[][],point rp,point bp,point p) {
		int x=p.x;
		while(true) {
			boolean can=false;
			
			for(int j=m-1;j>=1;j--) {
				if(map[x][j]!=null) {
				if(map[x][j].equals("R")||map[x][j].equals("B")) {
					if(map[x][j+1].equals(".")) {
						if(map[x][j].equals("R")) {
							map[x][j]=".";map[x][j+1]="R";rp.y+=1;can=true;
						}else {
							map[x][j]=".";map[x][j+1]="B";bp.y+=1;can=true;
						}	
					}else if(map[x][j+1].equals("O")) {
						if(map[x][j].equals("R")) {
							map[x][j]=".";rp.x=1;rr=true;can=true;
						}else if(map[x][j].equals("B")){
							map[x][j]=".";bp.x=1;bb=true;can=true;
						}
					}
				}
				}
			}
			if(!can)break;		
		}
		
	}
	static void left(String map[][],point rp,point bp,point p) {
		int x=p.x;
		while(true) {
			boolean can=false;
			
			for(int j=1;j<=m;j++) {
				if(map[x][j]!=null) {
				if(map[x][j].equals("R")||map[x][j].equals("B")) {
					if(map[x][j-1].equals(".")) {
						if(map[x][j].equals("R")) {
							map[x][j]=".";map[x][j-1]="R";rp.y-=1;can=true;
						}else {
							map[x][j]=".";map[x][j-1]="B";bp.y-=1;can=true;
						}	
					}else if(map[x][j-1].equals("O")) {
						if(map[x][j].equals("R")) {
							map[x][j]=".";rp.x=1;rr=true;can=true;
						}else if(map[x][j].equals("B")){
							map[x][j]=".";bp.x=1;bb=true;can=true;
						}
					}
				}
				}
				
			}
			if(!can)break;		
		}
		
	}
}



class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
}
