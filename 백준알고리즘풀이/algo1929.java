package algo;
import java.util.*;
public class algo1929 {
	static ArrayList a=new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int s=scan.nextInt();
		int e=scan.nextInt();
		
		boolean map[]=new boolean[1000001];
		map[0]=true;map[1]=true;
		for(int i=2;i<=1000000;i++) {
			if(!map[i]) {
				int temp=1000000/i;
				for(int j=2;j<=temp;j++) {
					map[j*i]=true;
				}
			}
		}
		for(int i=s;i<=e;i++) {
			if(!map[i])a.add(i);
		}
		
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i));
		}
	}

}
