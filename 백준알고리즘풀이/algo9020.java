package algo;
import java.util.*;
public class algo9020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int testc=scan.nextInt();
		ArrayList res=new ArrayList();
		
		boolean map[]=new boolean[10001];
		Arrays.fill(map, false);
		
		map[0]=true;map[1]=true;
		map[2]=false;
		
		for(int i=3;i<=10000;i++) {
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					map[i]=true;
					break;
				}
			}
		}
		
		for(int tc=1;tc<=testc;tc++) {
			int tar=scan.nextInt();
			int min=0;
			int a,b;
			boolean tmap[]=new boolean[10001];
			for(int i=2;i<tar;i++) {
				if(!tmap[i]&&)
				
			}
			
		}
		
	}

}


//for(int i=1;i<=10000;i++) {
//	if(!map[i])System.out.println(i);
//}
