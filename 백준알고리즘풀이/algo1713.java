package algo;
import java.util.*;
public class algo1713 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int k=scan.nextInt();
		
		int map[][]=new int[101][2];
		
		int min=999999;
		
		for(int i=1;i<=k;i++) {
			int temp=scan.nextInt();
			
			if(n!=0) {
				if(map[temp][0]>0) {
					map[temp][0]++;
				}else {
					map[temp][0]++;n--;map[temp][1]=i;
				}
			}
			else if(map[temp][0]>0) {
				map[temp][0]++;
			}
			else{
				min=99999;
				for(int j=1;j<101;j++) {
					if(min>map[j][0]&&map[j][0]!=0)min=map[j][0];
				}
				
				ArrayList a=new ArrayList();
				
				for(int j=1;j<101;j++) {
					if(map[j][0]==min)a.add(j);
				}
				
				int m=99999;
				for(int j=0;j<a.size();j++) {
					int t=(int)a.get(j);
					if(m>map[t][1]) {
						m=map[t][1];min=t;
					}
				}
				map[min][0]=0;map[min][1]=0;
				
				map[temp][0]=1;map[temp][1]=i;
				
			}
			
		}
		
		for(int i=1;i<101;i++) {
			if(map[i][0]!=0)System.out.printf("%d ", i);
		}
		
		
		
	}

}

