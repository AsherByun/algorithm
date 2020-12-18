package algo;
import java.util.*;
public class algo2167 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int m=scan.nextInt();
		
		int map[][]=new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				map[i][j]=scan.nextInt();
			}
		}
		ArrayList res=new ArrayList();
		int dp[][]=new int[n+1][m+1];
		int num=scan.nextInt();
		for(int as=1;as<=num;as++) {
			int s1=scan.nextInt();
			int e1=scan.nextInt();
			int s2=scan.nextInt();
			int e2=scan.nextInt();
			
			int xsum=0;
			for(int i=s1;i<=s2;i++) {
				int line=0;
				
				for(int j=e1;j<=e2;j++) {
					line+=map[i][j];
				}
				xsum+=line;
			}
			
			res.add(xsum);
			
		}
		
		
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}
		
		
		
	}

}
