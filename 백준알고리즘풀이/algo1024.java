package algo;
import java.util.*;
public class algo1024 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		ArrayList a=new ArrayList();
		int n=scan.nextInt();
		int l=scan.nextInt();
		boolean c=false;
		int s=l;
		while(true) {
			boolean can=false;
			int t=n/s;
			int st=t-(s-1);
			for(int i=0;i<t;i++) {
				int temp=0;
				for(int j=0;j<s;j++) {
					temp+=st+j;
				}
				if(temp==n) {
					for(int j=0;j<s;j++) {
						a.add(st+j);
					}can=true;
					break;
				}else {
					st++;
				}
			}
			s++;
			if(can)break;
			if(s>100) {c=true;break;}
		}
		if(c)System.out.println(-1);
		else for(int i=0;i<a.size();i++)System.out.printf("%d ", a.get(i));
		
	}

}
