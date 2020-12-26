package samsong;
import java.util.*;
public class sw9229 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int tc=scan.nextInt();

		
		ArrayList res=new ArrayList();
		for(int k=0;k<tc;k++) {
			
			ArrayList t=new ArrayList();
			
			int n=scan.nextInt();
			int m=scan.nextInt();
			boolean can=true;
			
			for(int i=0;i<n;i++) {
				int temp=scan.nextInt();
				if(temp<m)t.add(temp);
				
			}
			int max=0;Collections.sort(t);
			if((int)t.get(0)+(int)t.get(1)>=m)can=false;
			if(can) {
				
				for(int i=t.size()-1;i>=1;i--) {
					int c=i-1;
					while(true) {
						int temp=(int)t.get(i)+(int)t.get(c);
						
						if(temp>max&&temp<=m) {
							max=temp;break;
						}
						
						c--;
						if(c<0)break;
					}
					
					
					
				}
				
				res.add(max);
				
				
			}else {
				res.add(-1);
			}
			
			
			
			
			
			
			
			
			
			
			
		}
		
		for(int i=0;i<res.size();i++) {
			System.out.println("#"+(i+1)+" "+res.get(i));
		}
		
		
		
	}

}
