package algo;
import java.util.*;
public class algo1037 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
	
		int n=scan.nextInt();
		ArrayList a=new ArrayList();
		for(int i=0;i<n;i++) {
			int temp=scan.nextInt();
			a.add(temp);
		}
		Collections.sort(a);
		int a1=(int)a.get(0);
		int a2=(int)a.get(a.size()-1);
		System.out.println(a1*a2);
	}

}
