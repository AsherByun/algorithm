package algo;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo1946 {
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testc=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<testc;tc++) {
			ArrayList a=new ArrayList();
			n=Integer.parseInt(br.readLine());
			
			for(int i=0;i<n;i++) {
				String in[]=br.readLine().split(" ");
				int t1=Integer.parseInt(in[0]);
				int t2=Integer.parseInt(in[1]);
				a.add(new ene(t1,t2));
			}
			Collections.sort(a);
			
//			for(int i=0;i<a.size();i++) {
//				ene t=(ene)a.get(i);
//				System.out.println(t.ca);
//			}
			
			boolean visit[]=new boolean[100001];
			int tot=1;
			ene ttem=(ene)a.get(0);
			int min=ttem.cb;
			for(int i=1;i<a.size();i++) {
				ene temp=(ene)a.get(i);
				if(temp.cb<min)tot++;
				if(min>temp.cb) {
					min=temp.cb;
				}
				
			}
			
			System.out.println(tot);
			
		}
		
		
	}

}
class ene implements Comparable<ene>{
	int ca,cb;
	
	ene(int ca, int cb){
		this.ca=ca;
		this.cb=cb;
	}

	@Override
	public int compareTo(ene e) {
		// TODO Auto-generated method stub
		if(e.ca>this.ca) {
			return -1;
		}
		else if(e.ca==this.ca) {
			return 0;
		}else {
			return 1;
		}
	}
	
}