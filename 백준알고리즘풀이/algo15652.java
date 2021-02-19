package algo;
import java.util.*;
public class algo15652 {

	static int n,m;
	static boolean[] visit;
	static ArrayList res = new ArrayList();
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		n=scan.nextInt();
		m=scan.nextInt();
		visit=new boolean[n+1];
		String pass="";
		
		for(int i=1;i<=n;i++) {
			int count=0;
			visit[i]=true;
			find(i,pass,count);
			
			
			
		}
		
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}
		
		

	}
	static void find(int i,String pass,int count) {
		count++;
		pass=pass+i+" ";
		visit[i]=true;
		if(count==m) {
			res.add(pass);
		}
		else {
			for(int j=1;j<=n;j++) {
				if(i<=j) {
					find(j,pass,count);
				}
				
				
			}
			
			
		}
		
		visit[i]=false;
		
		
	}
	
	
	
	

}
