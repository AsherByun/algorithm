package algo;
import java.util.*;
public class algo1065 {

	static int tot=0;
	static boolean visit[]=new boolean[1001];
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scan=new Scanner(System.in);
		
		n=scan.nextInt();
		
		
		for(int i=0;i<10;i++) {
			
			for(int j=0;j<10;j++) {
			if(i!=0||j!=0&&n>=i) {
			find(i,j,0);
			findm(i,j,0);
			}
			}
			
		}
		
		for(int i=0;i<=n;i++) {
			if(visit[i]) {System.out.println(i);}
		}
		
		System.out.println(tot);
		
		
	}
	static void find(int x,int pl,int num) {
		
		
		if(pl+x/Math.pow(10, num)>9){
			
		}
		
		else {
		int temp=(int) (x+((pl+x/(int)Math.pow(10, num))*(int)Math.pow(10, num+1)));
		
		if(temp>n) {
			
		}
		else {
			if(!visit[temp]) {
				tot++;visit[temp]=true;
			}
			find(temp,pl,num+1);
			
		}
		}
		
		
		
	}
	static void findm(int x,int pl,int num) {
		if(x==0) {
			
		}else {
			if(!visit[x]&&x<=n) {
				tot++;visit[x]=true;
			}
		}
		
		if(x/Math.pow(10, num)-pl<0){
			
		}
		else {
		int temp=(int) (x+((x/(int)Math.pow(10, num)-pl)*(int)Math.pow(10, num+1)));
		
		if(temp>n) {
			
		}
		else {
			if(!visit[temp]) {
				tot++;visit[temp]=true;
			}
			find(temp,pl,num+1);
			
		}
	}
}
}