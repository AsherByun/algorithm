package algo;
import java.util.*;
public class algo1043 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int m=scan.nextInt();
		
		int tot=0;
		
		ArrayList a[]=new ArrayList[n+1];
		for(int i=1;i<=n;i++)a[i]=new ArrayList();
		
		
		int k=scan.nextInt();
		ArrayList know=new ArrayList();
		for(int i=1;i<=k;i++) {
			int temp=scan.nextInt();
			know.add(temp);
		}
		ArrayList res=new ArrayList();
		for(int i=1;i<=m;i++) {
			int tn=scan.nextInt();
			
			ArrayList temp=new ArrayList();
			for(int j=1;j<=tn;j++) {
				int t=scan.nextInt();
				temp.add(t);
			}
			res.add(temp);
			for(int j=0;j<temp.size();j++) {
				for(int c=j+1;c<temp.size();c++) {
					int t1=(int)temp.get(j);
					int t2=(int)temp.get(c);
					a[t1].add(t2);
					a[t2].add(t1);
				}
			}
		}
		boolean visit[]=new boolean[n+1];
		
		for(int c=0;c<know.size();c++) {
			
			Queue q=new LinkedList();
			int temp=(int)know.get(c);
			
			if(visit[temp])continue;
			
			q.add(temp);
			
			while(!q.isEmpty()) {
				int pt=(int)q.poll();
				visit[pt]=true;
				
				for(int i=0;i<a[pt].size();i++) {
					int tm=(int)a[pt].get(i);
					if(!visit[tm]) {
					q.add(tm);
					}
				}
			}	
		}
		
		for(int i=0;i<res.size();i++) {
			ArrayList temp=(ArrayList)res.get(i);
			boolean can=false;
			for(int j=0;j<temp.size();j++) {
				int tint=(int)temp.get(j);
				if(visit[tint]) {
					can=true;break;
				}
			}
			if(!can)tot++;
		}
		
//		for(int i=1;i<=n;i++) {
//			for(int j=0;j<a[i].size();j++) {
//				System.out.printf("%d ",(int)a[i].get(j));
//			}System.out.println("");
//		}
//		
		System.out.println(tot);

	}

}
