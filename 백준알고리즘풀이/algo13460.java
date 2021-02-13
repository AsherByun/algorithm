package algo;
import java.util.*;
import java.io.*;
public class algo13460 {
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static String tmap[][];
	static int m,n;
	static boolean visit[][];
	static point rp=new point(0,0);
	static point bp=new point(0,0);
	static point fp=new point(0,0);
	static int min=Integer.MAX_VALUE-1;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		tmap=new String[n+1][m+1];
		
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
		point tr=new point(rp.x,rp.y);
		point tb=new point(bp.x,bp.y);
		
		String map[][]=new String[n+1][m+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				map[i][j]=tmap[i][j];
			}
		}
		
		find(tr,tb,0,map);
		
		System.out.println(min);
		
		
	}
	static void find(point r,point b,int c,String map[][]) {
		
		if(c>10) {
			min=-1;
		}
		
		for(int i=0;i<4;i++) {
			
			set s=roll(b,r,i,map);
			
			point tb=s.b;
			point tr=s.r;
			if(tb.x!=fp.x&&tb.y!=fp.y) {
				if(tr.x==fp.x&&tr.y==fp.y) {
					if(c<min)min=c;
				}
				else {
					find(tr,tb,c+1,s.map);
				}
			}
			
			
		}
		
		
		
		
	}

	static set roll(point b,point r,int d,String map[][]) {
		
		if(d==0) {
			if(b.x<r.x) {
				
				while(true) {
					if(map[b.x-1][b.y].equals(".")) {
						map[b.x][b.y]=".";	b.x-=1; map[b.x][b.y]="B";
					}else if(map[b.x-1][b.y].equals("O")) {
						map[b.x][b.y]=".";b.x-=1;break;
					}else{
						break;
					}

				}
				
				while(true) {
					if(map[r.x-1][r.y].equals(".")) {
						map[r.x][r.y]=".";	r.x-=1; map[r.x][r.y]="R";
					}else if(map[r.x-1][r.y].equals("O")) {
						map[r.x][r.y]=".";	r.x-=1;break;
					}else{
						break;
					}

				}
				
			}else {
				while(true) {
					if(map[r.x-1][r.y].equals(".")) {
						map[r.x][r.y]=".";	r.x-=1;map[r.x][r.y]="R";
					}else if(map[r.x-1][r.y].equals("O")) {
						map[r.x][r.y]=".";r.x-=1;break;
					}else{
						break;
					}

				}
				while(true) {
					if(map[b.x-1][b.y].equals(".")) {
						map[b.x][b.y]=".";	b.x-=1; map[b.x][b.y]="B";
					}else if(map[b.x-1][b.y].equals("O")) {
						map[b.x][b.y]="."; b.x-=1;break;
					}else{
						break;
					}

				}
			}
			
			
			
			
		}else if(d==1) {
			if(b.y>r.y) {
				while(true) {
					if(map[b.x][b.y+1].equals(".")) {
						map[b.x][b.y]=".";	b.y+=1; map[b.x][b.y]="B";
					}else if(map[b.x][b.y+1].equals("O")) {
						map[b.x][b.y]=".";	b.y+=1;break;
					}else{
						break;
					}

				}
				while(true) {
					if(map[r.y][r.y+1].equals(".")) {
						map[r.x][r.y]=".";	r.y+=1;map[r.x][r.y]="R";
					}else if(map[r.x][r.y+1].equals("O")) {
						map[r.x][r.y]=".";	r.y+=1;break;
					}else{
						break;
					}
				}
				
				
			
		}else {
			while(true) {
				if(map[r.x][r.y+1].equals(".")) {
					map[r.x][r.y]=".";	r.y+=1;map[r.x][r.y]="R";
				}else if(map[r.x][r.y+1].equals("O")) {
					map[r.x][r.y]=".";	r.y+=1;break;
				}else{
					break;
				}
			}
		}
		while(true) {
				if(map[b.x][b.y+1].equals(".")) {
					map[b.x][b.y]=".";b.y+=1;map[b.x][b.y]="B";
				}else if(map[b.x][b.y+1].equals("O")) {
					map[b.x][b.y]=".";	b.y+=1;break;
				}else{
					break;
				}

			}
		}else if(d==2) {
			if(b.x>r.x) {
				while(true) {
					if(map[b.x+1][b.y].equals(".")) {
						map[b.x][b.y]=".";		b.x+=1;map[b.x][b.y]="B";
					}else if(map[b.x+1][b.y].equals("O")) {
						map[b.x][b.y]=".";	b.x+=1;break;
					}else{
						break;
					}

				}
				while(true) {
					if(map[r.x+1][r.y].equals(".")) {
						map[r.x][r.y]=".";	r.x+=1;map[r.x][r.y]="R";
					}else if(map[r.x+1][r.y].equals("O")) {
						map[r.x][r.y]="."; r.x+=1;break;
					}else{
						break;
					}
				}
			
		}else {
			while(true) {
				if(map[r.x+1][r.y].equals(".")) {
					map[r.x][r.y]=".";	r.x+=1;map[r.x][r.y]="R";
				}else if(map[r.x+1][r.y].equals("O")) {
					map[r.x][r.y]=".";	r.x+=1;break;
				}else{
					break;
				}
			}while(true) {
				if(map[b.x+1][b.y].equals(".")) {
					map[b.x][b.y]=".";	b.x+=1;map[b.x][b.y]="B";
				}else if(map[b.x+1][b.y].equals("O")) {
					map[b.x][b.y]=".";	b.x+=1;break;
				}else{
					break;
				}

			}
		}
			
		}else {
			if(b.y<r.y) {
				while(true) {
					if(map[b.x][b.y-1].equals(".")) {
						map[b.x][b.y]=".";	b.y-=1;map[b.x][b.y]="B";
					}else if(map[b.x][b.y-1].equals("O")) {
						map[b.x][b.y]=".";	b.y-=1;break;
					}else{
						break;
					}

				}
				while(true) {
					if(map[r.x][r.y-1].equals(".")) {
						map[r.x][r.y]=".";r.y-=1;map[r.x][r.y]="R";
					}else if(map[r.x][r.y-1].equals("O")) {
						map[r.x][r.y]=".";	r.y-=1;break;
					}else{
						break;
					}
				}
			
		}
			else {
				while(true) {
					if(map[r.x][r.y-1].equals(".")) {
						map[r.x][r.y]=".";	r.y-=1;map[r.x][r.y]="R";
					}else if(map[r.x][r.y-1].equals("O")) {
						map[r.x][r.y]=".";	r.y-=1;break;
					}else{
						break;
					}
				}while(true) {
					if(map[b.x][b.y-1].equals(".")) {
						map[b.x][b.y]=".";	b.y-=1;map[b.x][b.y]="B";
					}else if(map[b.x][b.y-1].equals("O")) {
						map[b.x][b.y]=".";b.y-=1;break;
					}else{
						break;
					}

				}
			}
		}
		
		
		
		
		
		
		set s=new set(r,b,map);
		
		return s;
		
	}
	
	
	
}
class set{
	String map[][];
	point r;
	point b;
		set(point r,point b,String[][] map){
			this.r=r;
			this.b=b;
			this.map=map;
		}
	
}


class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
}
