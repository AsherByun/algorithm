package algo;
import java.util.*;
public class algo3009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;int j=0;
		
		Scanner scan = new Scanner(System.in);
		int comein[][] = new int[4][2];
		int x,y;
		int tx,ty;
		
		for(i=0;i<3;i++) {
			for(j=0;j<2;j++) {
				comein[i][j]=scan.nextInt();
			}
			
		}
		

			if(comein[0][0]==comein[1][0]) {
				x=comein[2][0];
			}
			else if(comein[0][0]==comein[2][0]) {
				x=comein[1][0];
			}
			else {
				x=comein[0][0];
			}
			
			if(comein[0][1]==comein[1][1]) {
				y=comein[2][1];
			}
			else if(comein[0][1]==comein[2][1]) {
				y=comein[1][1];
			}
			else {
				y=comein[0][1];
			}
		
		
			System.out.println(x+" "+y);
		
		
		
		
	}

}
