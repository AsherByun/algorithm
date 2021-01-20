package algo;
import java.util.*;
public class algo10610 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		String n=scan.nextLine();
		
	
		long map[]=new long[100001];
		boolean zero =false;
		long res=0;
		ArrayList arr=new ArrayList();
		for(int i=0;i<n.length();i++) {
			map[i]=n.charAt(i)-'0';
			res+=map[i];
			arr.add(map[i]);
			if(map[i]==0) {
				zero=true;
			}
		}
		
			if(res%3==0&&zero) {
			Collections.sort(arr);
			long tot=0;
			for(int i=arr.size()-1;i>=0;i--) {
				System.out.print(arr.get(i));
			}
			
		}else {
			System.out.println(-1);
		}
		
		
		
	}

}
