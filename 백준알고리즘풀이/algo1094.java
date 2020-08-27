package algo;
import java.util.*;
public class algo1094 {

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		
		LinkedList res =  new LinkedList();
		res.add(64);
		boolean k=true;
		
		while(k) {
			int sum=0;
			
			for(int i=0;i<res.size();i++) {
				sum+=(int)res.get(i);
			}
			
			if(sum>x) {
				int temp=(int)res.poll();
				temp=temp/2;
				if(sum-temp>=x) {res.addFirst(temp);}
				else{res.addFirst(temp);res.addFirst(temp);}
				}
			else {
			int fin=0;
			for(int i=0;i<res.size();i++) {
				fin+=(int)res.get(i);
			}
			if(fin==x) {
				k=false;
				break;
				}
			
		}
	}
		System.out.println(res.size());
		
		
		

	}

}
