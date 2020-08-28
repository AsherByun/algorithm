package algo;
import java.util.*;
public class algo1145 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int map[]=new int[5];
		

		int res=0;
		int min=99999;
		for(int i=0;i<5;i++) {
			map[i]=scan.nextInt();
			if(min>map[i])min=map[i];
		}
		int n=min;
		while(true) {
			int c=0;
			for(int i=0;i<5;i++) {
				if(n%map[i]==0)c++;
			}
			if(c>=3)break;
			
			n++;
			
		}
		System.out.println(n);
	}

}
