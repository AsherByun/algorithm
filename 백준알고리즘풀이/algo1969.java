package algo;
import java.util.*;
public class algo1969 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		//a=1 t=2 g=3 c=4
		int n=scan.nextInt();
		int k=scan.nextInt();
		String res="";
		int ch[][]=new int[k+1][5];
		char map[][]=new char[n+1][k+1];
		
		
		for(int i=1;i<=n;i++) {
			String in =scan.next();
			map[i]=in.toCharArray();
			for(int j=1;j<=k;j++) {
				if(in.charAt(j-1)=='A') {
					ch[j][1]++;
				}else if(in.charAt(j-1)=='C') {
					ch[j][2]++;
				}else if(in.charAt(j-1)=='G') {
					ch[j][3]++;
				}else {
					ch[j][4]++;
				}
				
			}
		}
		for(int i=1;i<=k;i++) {
			if(ch[i][1]>=ch[i][2]&&ch[i][1]>=ch[i][3]&&ch[i][1]>=ch[i][4]) {
				res+="A";
			}else if(ch[i][2]>=ch[i][3]&&ch[i][2]>=ch[i][4]&&ch[i][2]>=ch[i][1]) {
				res+="C";
			}else if(ch[i][3]>=ch[i][4]&&ch[i][3]>=ch[i][1]&&ch[i][3]>=ch[i][2]) {
				res+="G";
			}else{
				res+="T";
			}
		}

		int count=0;
		for(int i=1;i<=k;i++) {
			for(int j=1;j<=n;j++) {
				char temp=res.charAt(i-1);
				if(map[j][i-1]!=temp) {
					count++;
				}
			}
		}
		System.out.println(res);
		System.out.println(count);
		
		
	}

}
