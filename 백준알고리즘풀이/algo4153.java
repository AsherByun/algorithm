package algo;
import java.util.*;

public class algo4153 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a,b,c;
		int low,high;
		int x,y;
		int max,mid,min;
	
		ArrayList<String> answer = new ArrayList<String>();
		int i;
		while(true) {
			a=scan.nextInt();
			b=scan.nextInt();
			c=scan.nextInt();
			if((a==0)&&(b==0)&&(c==0)) {break;}
			a=a*a;b=b*b;c=c*c;
			if((a==0)||(b==0)||(c==0)) {answer.add("wrong");}
			else if((a==b)||(a==c)||(b==c)) {answer.add("wrong");}
			else if((a>b)&&(a>c)) {
				if(a==(b+c)) {answer.add("right");}
				else {answer.add("wrong");}
				}
			else if((b>a)&&(b>c)) {
				if(b==(a+c)) {answer.add("right");}
				else {answer.add("wrong");}
			}
			else if((c>b)&&(c>a)) {
				if(c==(b+a)) {answer.add("right");}
				else {answer.add("wrong");}
			}
			
			
		
	}
		for(String ans: answer) {
			System.out.println(ans);
		}
		
		
	}
}
