package algo;
import java.util.*;
public class algo3967 {

	static boolean[] num = new boolean[13];
	static char[][] map= new char[5][9];
	static ArrayList res =new ArrayList();
	static int[][] nmap = new int[5][9];
	static int[][] fmap = new int[5][9];
	static int xc = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		
		
		for(int i=0;i<5;i++) {
			String in = scan.next();
			map[i]=in.toCharArray();
			for(int j=0;j<9;j++) {
				if(map[i][j]=='.') {
					continue;
				}else if(map[i][j]=='x') {
					nmap[i][j]=0;
					point p =  new point(i,j);
					res.add(p);
					xc++;
				}
				else {
					nmap[i][j]=map[i][j]-'A'+1;
					num[nmap[i][j]]=true;
				}
			}
		}
		int c=0;
		find(c);
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<9;j++) {
				System.out.printf("%d", fmap[i][j]);
			}
			System.out.printf("\n");
		}

	}

	static void find(int c) {
		
		point p;
		if(c>res.size()-1) {
			if(checking()) {
				fmap=nmap;
			}
		}else {
			p=(point) res.get(c);
			
			for(int i=1;i<=12;i++) {
				if(!num[i]) {
					num[i]=true;
					nmap[p.x][p.y]=i;
					find(c+1);
					nmap[p.x][p.y]=0;
					num[i]=false;
				}
				
			}
			
			
		}
		
		
		
	}
	
	static boolean checking() {
		
		
		if(nmap[0][4]+nmap[1][3]+nmap[2][2]+nmap[3][1]!=26) {return false;}
		else if(nmap[3][1]+nmap[3][3]+nmap[3][5]+nmap[3][7]!=26) {return false;}
		else if(nmap[0][4]+nmap[1][5]+nmap[2][6]+nmap[3][7]!=26) {return false;}
		else if(nmap[1][1]+nmap[1][3]+nmap[1][5]+nmap[1][7]!=26) {return false;}
		else if(nmap[1][1]+nmap[2][2]+nmap[3][3]+nmap[4][4]!=26) {return false;}
		else if(nmap[1][7]+nmap[2][6]+nmap[3][5]+nmap[4][4]!=26) {return false;}
		else {
			return true;
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