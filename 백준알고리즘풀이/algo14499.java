package algo;
import java.util.*;
public class algo14499 {
	static int n,m;
	static int map[][];
	static int now[][];
	static int dice[]=new int[6];
	static point nowp=new point(0,0); 
	static ArrayList res =new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		n=scan.nextInt();
		m=scan.nextInt();
		
		int tx=scan.nextInt();
		int ty=scan.nextInt();
		int testc = scan.nextInt();
		nowp.x=tx;nowp.y=ty;
		map=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=scan.nextInt();
			}
		}
		
		for(int i=0;i<testc;i++) {
			
			int dir=scan.nextInt();
			int tempx=nowp.x;int tempy=nowp.y;
			if(dir==1) {
				tempy+=1;
			}else if(dir==2) {
				tempy-=1;
			}else if(dir==3) {
				tempx-=1;
			}else if(dir==4) {
				tempx+=1;
			}
			if(tempy<0||tempy>=m||tempx<0||tempx>=n) {
				
			}else {
				roll(dir);
			
			
			if(map[nowp.x][nowp.y]==0) {
				
				map[nowp.x][nowp.y]=dice[0];
			}//else if(dice[0]==0&&map[nowp.x][nowp.y]!=0){
				//dice[0]=map[nowp.x][nowp.y];
				//map[nowp.x][nowp.y]=0;
			else {
				dice[0]=map[nowp.x][nowp.y];
				map[nowp.x][nowp.y]=0;
			}
			
			
			res.add(dice[1]);
			}
			
			
			
		}
		
		
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}
		
		

	}
	static void roll(int d) {
		
		
		if(d==1) {
			nowp.y+=1;
			int t1=dice[1];
			dice[1]=dice[4];
			dice[4]=dice[0];
			dice[0]=dice[5];
			dice[5]=t1;
		}else if(d==2) {
			nowp.y-=1;
			int t1=dice[1];
			dice[1]=dice[5];
			dice[5]=dice[0];
			dice[0]=dice[4];
			dice[4]=t1;
		}else if(d==3) {
			nowp.x-=1;
			int t1=dice[1];
			dice[1]=dice[2];
			dice[2]=dice[0];
			dice[0]=dice[3];
			dice[3]=t1;
		}else if(d==4) {
			nowp.x+=1;
			int t1=dice[1];
			dice[1]=dice[3];
			dice[3]=dice[0];
			dice[0]=dice[2];
			dice[2]=t1;
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