package algo;
import java.util.*;
public class algo1461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		ArrayList minus=new ArrayList();
		ArrayList plus=new ArrayList();
		
		int n=scan.nextInt();
		int m=scan.nextInt();
		
		for(int i=0;i<n;i++) {
			int temp=scan.nextInt();
			if(temp>0)plus.add(temp);
			if(temp<0)minus.add(-temp);
		}
		Collections.sort(plus);
		Collections.sort(minus);
		int tot=0;
		boolean mbig=false;
		if((int)plus.get(plus.size()-1)<(int)minus.get(minus.size()-1)) {
			mbig=true;
		}
		if(mbig) {//플라스부터 
			boolean nam=false;
			
			if(plus.size()%m!=0)nam=true;
			for(int i=plus.size()-1;i>=0;i=i-m) {
				tot+=(int)plus.get(i)*2;
				System.out.println(plus.get(i));
			}
			if(nam) {
				int namm=plus.size()%m;
				System.out.println(plus.get(namm-1));
				tot+=(int)plus.get(namm-1)*2;
			}
			nam=false;
			if(minus.size()%m!=0)nam=true;
			for(int i=minus.size()-1;i>=0;i=i-m) {
				if(i==minus.size()-1) {
					System.out.println(minus.get(i));
					tot+=(int)minus.get(i);
				}else {
					System.out.println(minus.get(i));
				tot+=(int)minus.get(i)*2;
				}
			}	
//			if(nam) {
//				int namm=minus.size()%m;
//				System.out.println(minus.get(namm-1));
//				tot+=(int)minus.get(namm-1)*2;
//			}
		}else {//마이너스부터
			boolean nam=false;
			if(minus.size()%m!=0)nam=true;
			for(int i=minus.size()-1;i>=0;i=i-m) {
				tot+=(int)minus.get(i)*2;
			}
			if(nam) {
				int namm=minus.size()%m;
				tot+=(int)minus.get(namm-1)*2;
			}
			nam=false;
			if(plus.size()%m!=0)nam=true;
			for(int i=plus.size()-1;i>=0;i=i-m) {
				if(i==plus.size()-1) {
					tot+=(int)plus.get(i);
				}else {
				tot+=(int)plus.get(i)*2;
				}
			}	
//			if(nam) {
//				int namm=plus.size()%m;
//				tot+=(int)plus.get(namm-1)*2;
//			}
		}
		
		
		System.out.println(tot);
	}

}
