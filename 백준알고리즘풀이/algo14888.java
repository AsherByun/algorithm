package algo;
import java.util.*;
public class algo14888 {
	static int[] doing;
	static int n;
	static int[] map;
	static int[] in=new int[5];//´õÇÏ±â »¬¼À °ö¼À ³ª´°¼À
	static ArrayList res = new ArrayList();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		n=scan.nextInt();
		doing=new int[n];
		map=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			map[i]=scan.nextInt();
		}
		for(int i=1;i<=4;i++) {
			in[i]=scan.nextInt();
		}
		int c=0;
		for(int i=1;i<=4;i++) {
			
			if(in[i]>0) {
			in[i]--;
			find(i,c);
			in[i]++;
			}
		}
		Collections.sort(res);
				
		
		System.out.println(res.get(res.size()-1));
		System.out.println(res.get(0));
		
	}
	static void find(int x,int c) {
		
		c++;
		//System.out.println();
		doing[c]=x;
		
		if(c==n-1) {
			mlt();
			//System.out.println(c);
			
		}
		else {
			for(int i=1;i<=4;i++) {
				
				if(in[i]>0) {
					in[i]--;
					find(i,c);	
					in[i]++;
				}	
			}
		}
		
	}
	
	static void mlt() {
		
		int r=map[1];
		for(int i=1;i<n;i++) {
			r=account(doing[i],r,map[i+1]);
			
		}
		res.add(r);
		
	}
	
	
	
	static int account(int a,int s1,int s2){
		
		switch(a) {
		case 1:
			return s1+s2;
			
		case 2:
			return s1-s2;
		case 4:
			if(s1<0) {
				int temp=Math.abs(s1);
				s1=temp/s2;
				return 0-s1;
			}else {
				return s1/s2;
			}
		case 3:
			return s1*s2;
		}
		
		return 0;
		
	}
}
