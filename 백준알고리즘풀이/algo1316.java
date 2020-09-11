package algo;
import java.util.*;

public class algo1316 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan =new Scanner(System.in);
		
		int testc=scan.nextInt();
		int c=0;String in[]=new String[testc];
		for(int i=0;i<testc;i++) {
			in[i]=scan.next();
		}
		for(int i=0;i<testc;i++) {
			
			
			boolean visit[]=new boolean[1000];
			
			boolean can=true;
			
			for(int j=0;j<in[i].length();j++) {
				int t=in[i].charAt(j)-'0';
				if(j==0) {
					visit[t]=true;
				}else if(!visit[t]) {
					visit[t]=true;
				}else if(visit[t]&&in[i].charAt(j-1)==in[i].charAt(j)) {
					
				}else if(visit[t]) {
					can=false;break;
				}
			}
			if(can)c++;
		
			
			
		}
		
		System.out.println(c);
		
	}

}
