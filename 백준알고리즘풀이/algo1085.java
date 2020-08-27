package algo;
import java.util.*;
public class algo1085 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int x,y,w,h;
		int xc,yc;
		
		x=scan.nextInt();
		y=scan.nextInt();
		w=scan.nextInt();
		h=scan.nextInt();
		
		
		if(x>(w-x)) {xc=w-x;}
		else {xc=x;}
		
		if(y>(h-y)) {yc=h-y;}
		else {yc=y;}
		
		if(xc>yc) {System.out.println(yc);}
		else {System.out.println(xc);}
		
	}

}
