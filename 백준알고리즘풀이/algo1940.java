package algo;
import java.util.*;
public class algo1940 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int m=scan.nextInt();
		boolean visit[]=new boolean[1000000];
		ArrayList a=new ArrayList();
		
		for(int i=0;i<n;i++) {
			int temp=scan.nextInt();
			a.add(temp);
		}
		Collections.sort(a);
		int tot=0;
		for(int i=0;i<a.size();i++) {
			int temp=(int)a.get(i);
			if(temp>=m)break;
//			if(m==temp) {
//				tot++;
//				break;
//			}
			
			int tar=Collections.binarySearch(a, m-temp);
			

			if(tar>=0&&!visit[m-temp]&&temp!=m-temp) {
				tot++;
				visit[m-temp]=true;visit[temp]=true;
			}
			
		}
		System.out.println(tot);
		
	}

}
