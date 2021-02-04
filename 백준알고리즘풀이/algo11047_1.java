package algo;
import java.util.*;
public class algo11047_1 {
	static int k;
	static ArrayList a;
	static int min=Integer.MAX_VALUE-1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		k=scan.nextInt();
		a=new ArrayList();
		
		for(int i=0;i<n;i++) {
			int temp=scan.nextInt();
			if(temp<=k)a.add(temp);
		}
		int tar=a.size()-1;
		for(int i=k/((int)a.get(a.size()-1));i>=0;i--) {
			if(k==(int)a.get(tar)*i) {
				min=i;break;
			}else {
				find(i,k-(int)a.get(a.size()-1)*i,tar-1);
			}
		}
		System.out.println(min);
	}
	static void find(int count,int nam,int l) {
		if(l<0)return;
		int g=(int)a.get(l);
		for(int i=nam/g;i>=0;i--) {
			if(nam==g*i) {
				if(min>count+i)min=count+i;
				return;
			}else {
				find(count+i,nam-i*g,l-1);
			}
		}
		
	}
}