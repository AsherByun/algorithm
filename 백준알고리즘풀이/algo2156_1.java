package algo;
import java.util.*;
public class algo2156_1 {
	static int n;
	static int end;
	static boolean visit[];
	static int tot[][];
	static int map[];
	static int max=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		visit=new boolean[n+1];
		map=new int[n+1];
		tot=new int[n+1/3][3];
		for(int i=0;i<n;i++) {
			map[i]=scan.nextInt();
			if(i%3==0||i%3==1) {
				tot[i/3][0]+=map[i];
			}if(i%3==0||i%3==2) {
				tot[i/3][1]+=map[i];
			}if(i%3==1||i%3==2) {
				tot[i/3][2]+=map[i];
			}
			
		}
		
		end=n/3;
		
			find(0,0,0);
			find(0,1,0);
			find(0,2,0);
			
	
			System.out.println(max);
	
	
}
	static void find(int c,int num,int sum) {
		
	//	System.out.println("sdfa");
		if(c==end) {
			if(max<sum) {
				max=sum;
			}
		}else if(num==0) {
			sum+=tot[c][0];
			find(c+1,0,sum);
			find(c+1,1,sum);
			find(c+1,2,sum);
		}else if(num==1) {
			sum+=tot[c][1];
			find(c+1,1,sum);
			find(c+1,2,sum);
		}else {
			sum+=tot[c][2];
			find(c+1,2,sum);
		}
		
		
		
		
	}
	
	
	
	
}
