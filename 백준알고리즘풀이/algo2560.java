package algo;
import java.util.*;
public class algo2560 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int a=scan.nextInt();
		int b=scan.nextInt();
		int d=scan.nextInt();
		int N=scan.nextInt();
		
		int plus[]=new int[N+1];
		int minus[]=new int[N+1];
		int tot[]=new int[N+1];
		int dead[]=new int[N+1];
		
		tot[0]=1;
		if(a<=N)
		plus[a]=1;
		if(d<=N)
		dead[d]=1;
		if(b<=N)
		minus[b]=1;
		
		for(int i=1;i<=N;i++) {
			
			plus[i]=(plus[i]+plus[i-1]-minus[i]);
			
			if(i+a<=N) {
				plus[i+a]+=plus[i];
				plus[i+a]%=1000;
			}
			if(i+b<=N) {
				minus[i+b]+=plus[i];
				minus[i+b]%=1000;
			}
			if(i+d<=N) {
				dead[i+d]+=plus[i];
				dead[i+d]%=1000;
			}
			
			tot[i]=tot[i-1]+plus[i]-dead[i];
			if(tot[i]<0)tot[i]=tot[i]+1000;
			tot[i]=tot[i]%1000;
			//System.out.println(tot[i]+"  "+plus[i]+"  "+minus[i]+"  "+dead[i]);
			
		}
		System.out.println(tot[N]);
		
		
	}

}
