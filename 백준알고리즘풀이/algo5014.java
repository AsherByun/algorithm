package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class algo5014 {

	static int f,s,g,u,d;
	static int min=Integer.MAX_VALUE-1;
	static int visit[];
	static boolean can=false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String in[]=br.readLine().split(" ");
		
		f=Integer.parseInt(in[0]);
		s=Integer.parseInt(in[1]);
		g=Integer.parseInt(in[2]);
		u=Integer.parseInt(in[3]);
		d=Integer.parseInt(in[4]);
		visit=new int[f+1];
		
		visit[s]=1;
		find();
		
		if(visit[g]!=0) {
			System.out.println(visit[g]-1);
		}
		
		else {
			System.out.println("use the stairs");
		}
		
		
		
	}
	
	static void find(){
		
			int c=0;
			Queue q=new LinkedList();
			q.add(s);
			
			
			while(!q.isEmpty()) {
				int temp=(int)q.poll();
		
				
				if(temp+u<=f) {
					if(visit[temp+u]==0) {
						visit[temp+u]=visit[temp]+1;
						q.add(temp+u);
					}
				}
				
				if(temp-d>=1) {
					if(visit[temp-d]==0) {
						visit[temp-d]=visit[temp]+1;
						q.add(temp-d);
					}
				}
				
				
				
		}
		
		
		
	}
	
	
	
	
	
	
}
