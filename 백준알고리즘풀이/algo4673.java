package algo;
import java.util.*;
public class algo4673 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean map[]=new boolean[10001];
		
		for(int i=1;i<=10000;i++) {
			int temp=i;
			for(int j=0;j<=i/10;j++) {
				temp+=(i%(int)Math.pow(10, j+1))/(int)Math.pow(10, j);
			}
			if(temp<=10000) {
				map[temp]=true;
			}
		}
		for(int i=1;i<=10000;i++) {
			if(!map[i])System.out.println(i);
		}
	}

}
