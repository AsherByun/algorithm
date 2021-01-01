package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo2819 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=scan.nextInt();
		int m=scan.nextInt();
		PriorityQueue axu=new PriorityQueue();
		PriorityQueue axd=new PriorityQueue();
		PriorityQueue ayu=new PriorityQueue();
		PriorityQueue ayd=new PriorityQueue();
		PriorityQueue ays=new PriorityQueue();
		PriorityQueue axs=new PriorityQueue();
		int xsum=0;
		int ysum=0;
		boolean xz=false;boolean yz=false;
		
		int sx=0;int sy=0;
		for(int i=0;i<n;i++) {
			int tx=scan.nextInt();
			int ty=scan.nextInt();
			xsum+=Math.abs(tx);
			ysum+=Math.abs(ty);
			if(tx>0) {
				axu.add(tx);
			}else if(tx<0) {
				axd.add(-tx);
			}else if(tx==0) {
				axs.add(tx);
			}
			if(ty>0) {
				ayu.add(ty);
			}else if(ty<0){
				ayd.add(-ty);
			}else if(ty==0) {
				ays.add(ty);
			}
			
		}
	
		String in=br.readLine();
		
		
		for(int i=0;i<in.length();i++) {
			char tchar=in.charAt(i);
			int tot=0;
			
			
			if(tchar=='S') {
				sy++;
				if(ayu!=null) {
					
					
				}
				
			}else if(tchar=='J') {
				sy--;
				
				
			}else if(tchar=='I') {
				sx++;
				
				
			}else if(tchar=='Z') {
				sx--;
				
			}
			
			System.out.println(tot);
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