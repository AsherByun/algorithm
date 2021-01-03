package algo;
import java.util.*;
public class algo3190 {
	static int n;
	static int[][] map;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		ArrayList<point> tall = new ArrayList<point>();
		n=scan.nextInt();
		int applec=scan.nextInt();
		map=new int[n+1][n+1];
		for(int i=0;i<applec;i++) {
			int x=scan.nextInt();
			int y=scan.nextInt();
			map[x][y]=1;
			
		}
		int time=0;
		int d=1;
		point now = new point(1,1);
		tall.add(now);
		int in=scan.nextInt();
		String direct[] = new String[10000];
		for(int i=0;i<in;i++) {
			int t=scan.nextInt();
			direct[t]=scan.next();
		}
		map[1][1]=2;
		
		while(true) {
			time++;
			point head =new point(tall.get(tall.size()-1).x,tall.get(tall.size()-1).y) ;
			
			if(direct[time-1]!=null) {
				if(direct[time-1].equals("D")) {d++;
				}
				else {d--;}
			}
			if(d>0&&d<5) {
			head=go(d,head);
			//d경계조사
			int x=head.x; int y=head.y;
			if(x>n||x<=0||y>n||y<=0||map[x][y]==2) {
				break;
			}else {
				if(map[x][y]==1) {
					tall.add(head);
					map[x][y]=2;
				}
				else{
					map[x][y]=2;
					map[tall.get(0).x][tall.get(0).y]=0;
					tall.remove(0);
					tall.add(head);
				}
				
			}
			}
			else {
				if(d<1) {d++;}
				else {d--;}
			}
			System.out.println(tall.get(tall.size()-1).x+"  "+tall.get(tall.size()-1).y);
		}
		
		
		System.out.println(time);
		
		
		
		
		

	}

	static point go(int num,point now) {
		
		
		if(num==1) {
			int y=now.y;
			now.y=y+1;
			return now;
		}else if(num==2) {
			int x=now.x;
			now.x=x+1;
			return now;
		}else if(num==3) {
			int y=now.y;
			now.y=y-1;
			return now;
		}else {
			int x=now.x;
			now.x=x-1;
			return now;
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
