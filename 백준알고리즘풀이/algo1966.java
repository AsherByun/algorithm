package algo;
import java.util.*;
public class algo1966 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList res = new ArrayList();
		int testcase=scan.nextInt();
		
		for(int f=0;f<testcase;f++){
			
			int n=scan.nextInt();
			int m=scan.nextInt();
			ArrayList pri = new ArrayList();
			Queue q =new LinkedList();
			
			for(int i=0;i<n;i++) {
				int temp=scan.nextInt();
				state s = new state(i,temp);
				q.add(s);
				pri.add(temp);
			}
			boolean a=true;
			int count=0;
			while(a) {
				Collections.sort(pri);
				int max=0;
				state s = (state)q.peek();
				//System.out.println(s);
				if(s!=null) {
					max=(int)pri.get(pri.size()-1);
					//System.out.println(s.pr);
				}
				if(s!=null) {
				if(s.pr<max) {
					//System.out.println(s.pr);
					q.poll();
					q.add(s);
				}else {
					//System.out.println("!!");
					count++;
					if(s.num==m) {a=false;break;}
					
					q.poll();
					pri.remove(pri.size()-1);
				}}
				
			}
			
			res.add(count);
			
			
		}
		for(int i=0;i<res.size();i++) {
		System.out.println(res.get(i));
		}
	}

}
class state{
	int num;
	int pr;
	
	
		state(int num,int pr){
			this.num=num;
			this.pr=pr;
		}
	
	
	
	
	
	
	
}