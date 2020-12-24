package algo;
import java.util.*;
public class algo2580 {
	
	static int[][] map=new int[10][10];
	static boolean[][] col=new boolean[10][10];
	static boolean[][] row=new boolean[10][10];
	static boolean[][] box=new boolean[10][10];
	static ArrayList savep =new ArrayList();
	static int fc;
	static int[][] fmap=new int[10][10];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				int temp=scan.nextInt();
				if(temp!=0) {
				map[i][j]=temp;
				row[j][temp]=true;
				col[i][temp]=true;
				boxing(i,j,temp);
				}
				else if(temp==0) {
					point p=new point(i,j);
					savep.add(p);
				}
				
			}
		}
		fc=savep.size();
		int c=0;
		find()
		
		
		
		
		
	}

	
	
	

	
	
	
	
	
	
	static void boxing(int i,int j,int t) {
		if(i<4&&j<4) {box[1][t]=true;}
		else if(3<i&&i<7&&j<4) {box[2][t]=true;}
		else if(6<i&&i<10&&j<4) {box[3][t]=true;}
		else if(i<4&&3<j&&j<7) {box[4][t]=true;}
		else if(3<i&&i<7&&3<j&&j<7) {box[5][t]=true;}
		else if(6<i&&i<10&&3<j&&j<7) {box[6][t]=true;}
		else if(i<4&&6<j&&j<10) {box[7][t]=true;}
		else if(3<i&&i<7&&6<j&&j<10) {box[8][t]=true;}
		else if(6<i&&i<10&&6<j&&j<10) {box[9][t]=true;}
	}
	
	
	
}


class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
}
