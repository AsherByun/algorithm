package algo;
import java.util.*;
public class algo2568 {
	static int map[]=new int[500001];
	static int dp[]=new int[500001];
	static int cmap[]=new int[500001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		ArrayList a=new ArrayList();
	
		int t=0;
		for(int i=0;i<n;i++) {
			int a1=scan.nextInt();
			int a2=scan.nextInt();
			map[a1]=a2;
			cmap[a2]=a1;
			a.add(a1);
			t=Math.max(Math.max(a1, a2), t);
		}
		pair p[]=new pair[500001];
		
		dp[1]=map[1];
		p[1]=new pair(1,map[1]);
		int idx=0;
		for(int i=2;i<=t;i++){
			if(map[i]==0)continue;
			
			if(dp[idx]<map[i]) {
				dp[++idx]=map[i];
				p[i]=new pair(idx,map[i]);
			}else {
				int ii=lower_bound(idx,map[i]);
				dp[ii]=map[i];
				p[i]=new pair(ii,map[i]);
			}
			
		}
		Collections.sort(a);
		boolean visit[]=new boolean[500001];
		 Stack s=new Stack();
		 Stack st=new Stack();
		 int temp=idx;
		 for(int i=t;i>=1;i--) {
			 if(p[i]!=null) {
				 if(temp==p[i].idx) {
					 visit[p[i].val]=true;
					 s.push(p[i].val);
					 --temp;
				 }
			 }
		 }
		 System.out.println(n-s.size());
		 
		 
		    while(!s.isEmpty()) {
		    	int tem=(int)s.pop();
		       	a.remove((Integer)cmap[tem]);
		    }
		    for(int i=0;i<a.size();i++)System.out.println(a.get(i));

		
	}
	static int lower_bound(int end, int n) {
	    int start = 0;
	 
	    while (start < end) {
	        int mid = (start + end) / 2;
	        if (dp[mid] >= n) {
	            end = mid;
	        } else {
	            start = mid + 1;
	        }
	    }
	    return end;
	}


}
class pair{
	int idx;
	int val;
	pair(int idx, int val){
		this.idx=idx;
		this.val=val;
	}
}