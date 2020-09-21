package algo;
import java.util.*;
public class algo1613 {

	static int n,k;
	static int map[];
	static boolean visit[];
	static HashMap h=new HashMap();
	static int ae1;
	static boolean f,b;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		n=scan.nextInt();
		k=scan.nextInt();
		visit=new boolean[400];
		for(int i=0;i<k;i++) {
			int t1=scan.nextInt();
			int t2=scan.nextInt();
			
			if(!visit[t1]) {
				visit[t1]=true;
				LinkedList l=new LinkedList();
				l.add(t2);
				h.put(t1,l);
				
			}else {
				((LinkedList) h.get(t1)).add(t2);
			}
			
			
		}
	
		int s=scan.nextInt();
		for(int i=0;i<s;i++) {
			int t1=scan.nextInt();
			int t2=scan.nextInt();
			visit=new boolean[400];
			ae1=0;
			f=false;b=false;
			
			find(t1,t2);
			
			if(f) {
				System.out.println(-1);
			}else {
				find(t2,t1);
				if(f) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				
			}
			
			
		}
		
	}

	static void find(int s,int e) {
		
		if(s==e) {
			ae1=1;f=true;
		}
		else {
			
			LinkedList temp=(LinkedList) h.get(s);
			
			
			
			if(temp!=null) {
			for(int i=0;i<temp.size();i++) {
				int t=(int) temp.get(i);
				if(!visit[t]) {
					visit[t]=true;
					find(t,e);
					
				}
				
			}
			
		}
		
		}

	}
}