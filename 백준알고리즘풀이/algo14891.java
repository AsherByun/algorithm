package algo;
import java.util.*;
public class algo14891 {
	static ArrayList t1 =new ArrayList();
	static ArrayList t2 =new ArrayList();
	static ArrayList t3 =new ArrayList();
	static ArrayList t4 =new ArrayList();
	static int sum=0;
	static ArrayList<ArrayList> all = new ArrayList<ArrayList>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan =new Scanner(System.in);
		
		
		
			String in = scan.next();
			for(int j=0;j<8;j++) {
				t1.add(in.charAt(j)-'0');
			}
			all.add(t1);
			in = scan.next();
			for(int j=0;j<8;j++) {
				t2.add(in.charAt(j)-'0');
			}
			all.add(t2);
			in = scan.next();
			for(int j=0;j<8;j++) {
				t3.add(in.charAt(j)-'0');
			}
			all.add(t3);
			in = scan.next();
			for(int j=0;j<8;j++) {
				t4.add(in.charAt(j)-'0');
			}
			all.add(t4);
			int testcase=scan.nextInt();
			
			for(int k=1;k<=testcase;k++) {
				
				int num=scan.nextInt();
				int roll=scan.nextInt();
				
				rolling(roll,num);
			}
			sum();
			System.out.println(sum);
	}
	static void rolling(int r,int num) {
		
		boolean com[] = new boolean[4];
		if((int)all.get(0).get(2)==(int)all.get(1).get(6)) {com[1]=true;}
		if((int)all.get(1).get(2)==(int)all.get(2).get(6)) {com[2]=true;}
		if((int)all.get(2).get(2)==(int)all.get(3).get(6)) {com[3]=true;}
		
		
	if(r==1) {
			rc(num);
		}else {rcc(num);}
		
		int k=num;
		int rr=r;
		while(true) {
			k-=1;
			if(k==0) {break;}
			else {
				if(com[k]) {
					break;
				}else {
					if(rr==1) {rr=-1;rcc(k);}
					else {rr=1;rc(k);}
				}
			}
			
		}
		k=num;
		rr=r;
		while(true) {
			k+=1;
			if(k==5) {break;}
			else {
				if(com[k-1]) {
					break;
				}else {
					if(rr==1) {rr=-1;rcc(k);}
					else {rr=1;rc(k);}
				}
			}
			
		}
	}
		

	static void rc(int num) {
		int k=num-1;
		
		ArrayList temp = all.get(k);
		all.remove(k);
		
		int a=(int)temp.get(temp.size()-1);
		if(a==1) {temp.add(0,1);}
		else {temp.add(0,0);}
		temp.remove(temp.size()-1);
		
		all.add(k,temp);
		
		
	
	}
	static void rcc(int num) {
		int k=num-1;
		
		ArrayList temp = all.get(k);
		all.remove(k);
		
		int a=(int)temp.get(0);
		if(a==1) {temp.add(1);}
		else {temp.add(0);}
		temp.remove(0);
		
		all.add(k,temp);
		
	}
	static void sum() {
		if((int)all.get(0).get(0)==1) {
			sum+=1;
		}

		if((int)all.get(1).get(0)==1) {
			sum+=2;
		}

		if((int)all.get(2).get(0)==1) {
			sum+=4;
		}

		if((int)all.get(3).get(0)==1) {
			sum+=8;
		}

		
	}
	
}
