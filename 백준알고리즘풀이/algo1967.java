package algo;
import java.util.*;
public class algo1967 {
	static int totmax=0;
	static ArrayList node=new ArrayList();
	static HashMap h[]=new HashMap[10001];
//	static int w[][]=new int[10001][10001];
	static ArrayList link[]=new ArrayList[10001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		for(int i=0;i<10001;i++)link[i]=new ArrayList();
		for(int i=0;i<10001;i++)h[i]=new HashMap();
		for(int i=0;i<n-1;i++) {
			int par=scan.nextInt();
			int child=scan.nextInt();
			int wt=scan.nextInt();
			link[par].add(child);
			h[par].put(child, wt);
//			w[child][par]=wt;
//			w[par][child]=wt;
			if(!node.contains(par)) {
				node.add(par);
			}
		}
		int max=0;
		if(n==1) {
			System.out.println(0);
			return ;
		}
		
		int start=(int)node.get(0);
		find(start,0);
		
		System.out.println(totmax);
		
		
	}
	static int find(int s,int l) {
		int max=0;
		if(link[s].size()==0) {
//			return w[s][l];
			return (int)h[l].get(s);
		}
		
		ArrayList ts=new ArrayList();
		
		for(int i=0;i<link[s].size();i++) {
			int temp=find((int)link[s].get(i),s);
			ts.add(temp);
		}
		Collections.sort(ts);
		
		if(ts.size()>1) {
			int temp=(int)ts.get(ts.size()-1)+(int)ts.get(ts.size()-2);
			if(temp>totmax)totmax=temp;
		}
		int tem=(int)ts.get(ts.size()-1);
	
		if(tem>max)max=tem;
		if(max>totmax)totmax=max;
//		System.out.println(s+"  "+max+" ");
		
//		return max+w[s][l];
		if(h[l].containsKey(s)) {
			return max+(int)h[l].get(s);
		}else
		return max;
	}
}
