package algo;
import java.util.*;
public class algo1002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int x1,y1,r1,x2,y2,r2;
		double len;
		int testcase;
		ArrayList res = new ArrayList();
		
		testcase=scan.nextInt();
		
		
		for(int i=0;i<testcase;i++) {
		
			int count=0;	
		x1=scan.nextInt();
		y1=scan.nextInt();
		r1=scan.nextInt();
		x2=scan.nextInt();
		y2=scan.nextInt();
		r2=scan.nextInt();
		
		len=Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2, 2));
		int r=r1+r2;
		int bigr=r1;
		int smallr=r2;
		if(r1<r2) {bigr=r2; smallr=r1;}
		
		if((x1==x2)&&(y1==y2)&&(r1==r2)) {
			count=-1;
		}
		else if((r<len)||(bigr>len+smallr)||(x1==x2)&&(y1==y2)&&(r1!=r2)) {
			count=0;
			
		}
		else if((r==len)||(bigr==len+smallr)) {
			count=1;
		}
		else {count=2;}
		
		
		
		res.add(count);	
		}
		
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}
		
		
		
	}

}
