package algo;
import java.util.*;
public class algo1021 {
	static ArrayList q=new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int m=scan.nextInt();
		
		for(int i=1;i<=n;i++)q.add(i);
		
		ArrayList tar=new ArrayList();
		
		for(int i=0;i<m;i++) {
			int temp=scan.nextInt();
			tar.add(temp);
		}
		int size=n;
		int turn=0;
		
		for(int c=0;c<m;c++) {
			
			
			int t=(int)tar.get(c);
			int idx=q.indexOf(t);
//			System.out.println(t+" "+idx);
			if(t==(int)q.get(0)) {
				q.remove(0);
			}
			else if(q.size()-idx>=idx) {//¿À¸¥ÂÊÀÌ ´õ±è->¿ÞÂÊÀ¸·Î
				while(true) {
					int temp=(int)q.get(0);
					if(temp==t) {
						q.remove(0);
						break;
					}else {
						turn++;
						q.add(q.size(), temp);
						q.remove(0);
					}
				}
			}else {
				while(true) {
					int temp=(int)q.get(0);
					if(temp==t) {
						q.remove(0);
						break;
					}else {
						turn++;
						int temp2=(int)q.get(q.size()-1);
						q.add(0,temp2);
						q.remove(q.size()-1);
					}
				}
			}
			//System.out.println(q.size()+" "+turn);
			
//			for(int i=0;i<q.size();i++) {
//				System.out.printf("%d ", (int)q.get(i));
//			}System.out.println("?//////////////?");
			
		}
		
		System.out.println(turn);
		
	}
	
}
