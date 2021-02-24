package algo;
import java.util.*;
public class algo17136_2 {

	static int map[][];
	static boolean visit[][];
	static int n,m;
	static int min=Integer.MAX_VALUE;
	static int cn[]= {0,5,5,5,5,5};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		map=new int[10][10];
		visit=new boolean[10][10];
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				map[i][j]=scan.nextInt();
			}
		}
		
		
		find(0,0);
		
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else System.out.println(min);
		
		
	}
	
	static void find(int c,int num) {
		
		if(num==100) {
			min=Math.min(min,c);
			return;
		}
		
		if(min<=c)return;
		
		int x=num/10;
		int y=num%10;
		
		if(map[x][y]==1) {
			
			for(int i=5;i>0;i--) {
				if(cn[i]>0) {
					if(check(x,y,i)) {
						fill(x,y,i,0);
						cn[i]--;
						find(c+1,num+1);
						fill(x,y,i,1);
						cn[i]++;
						
					}
				}
				
			}
			
			
		}else {
			find(c,num+1);
		}
		
		
		
		
	}
	static boolean check(int x,int y,int k) {
		
		if(x+k>10||y+k>10)return false;
		
		for(int i=0;i<k;i++) {
			for(int j=0;j<k;j++) {
				if(map[x+i][y+j]!=1)return false;
			}
		}
		
		return true;
		
	}
	
	
	static void fill(int x,int y,int k, int s) {
		
		for(int i=0;i<k;i++) {
			for(int j=0;j<k;j++) {
				map[x+i][y+j]=s;
			}
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

